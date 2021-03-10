package ro.fasttackit.classes.curs2.countries;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class FileCountryReportGenerator extends CountryReportGenerator{
    private final String sourceFile;

    public FileCountryReportGenerator(String sourceFile) {
        this.sourceFile = sourceFile;
    }

    @Override
    protected List<Country> readCountries() {
        try {
            return Files.lines(Path.of(sourceFile))
                    .map(this::readCountry)
                    .collect(toList());
        } catch (IOException e) {
            System.err.println("Could not read from file " + sourceFile);
        }
        return List.of();
    }

    private Country readCountry(String line) {
        String[] countryInfo = line.split("\\|");
        return new Country(
                countryInfo[0],
                countryInfo[1],
                Continent.of(countryInfo[4]).orElse(null),
                Long.parseLong(countryInfo[3]),
                Long.parseLong(countryInfo[2]),
                countryInfo.length > 5 ? parseNeighbours(countryInfo[5]) : List.of()
        );
    }

    private List<String> parseNeighbours(String neighbours) {
        if (neighbours != null) {
            return Arrays.stream(neighbours.split("~"))
                    .collect(toList());
        } else {
            return List.of();
        }
    }
}
