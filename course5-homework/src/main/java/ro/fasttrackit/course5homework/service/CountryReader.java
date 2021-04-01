package ro.fasttrackit.course5homework.service;

import org.springframework.stereotype.Component;
import ro.fasttrackit.course5homework.domain.Country;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.stream.Collectors.toList;

@Component
public class CountryReader {
    private List<Country> countries;
    private final String sourceFile = "src/main/resources/countries.txt";

    public CountryReader() {
        countries = read();
    }

    public List<Country> getCountries() {
        return countries;
    }

    private List<Country> read() {
        try {
            //clasa Files din Java ajuta sa citesti un fisier, Files.lines - inseamna ca citeste cate o linie deodata
            AtomicInteger id = new AtomicInteger(1);
            return Files.lines(Path.of(sourceFile))
                    .map(line -> readOne(line, id.getAndIncrement()))
                    .collect(toList());
        } catch (IOException e) {
            System.err.println("Could not read from file " + sourceFile);
        }
        return List.of();
    }

    private Country readOne(String line, int id){
        //transforma o linie de text intr-un country (citeste un String si il face Country)
        List<String> countryInfo = Arrays.asList(line.split("\\|"));
        List<String> neighbours = new ArrayList<>();
        if(countryInfo.size() >= 6){
            neighbours = Arrays.asList(countryInfo.get(5).split("~"));
        }
        return new Country(
                id,
                countryInfo.get(0),
                countryInfo.get(1),
                Long.parseLong(countryInfo.get(2)),
                Long.parseLong(countryInfo.get(3)),
                countryInfo.get(4),
                neighbours
                //countryInfo.size() > 5 ? parseNeighbours(countryInfo.get(5)) : List.of()
        );
    }

//    private List<String> parseNeighbours(String neighbours) {
//        if (neighbours != null) {
//            return Arrays.stream(neighbours.split("~"))
//                    .collect(toList());
//        } else {
//            return List.of();
//        }
//    }
}
