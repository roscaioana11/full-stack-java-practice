package ro.fasttrackit.course5homework.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.course5homework.domain.Country;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.*;

@Service
public class CountryService {
    private final CountryReader countryReader;

    @Resource(name = "myCountryBean")
    private MyCountryBean myCountryBean;

    public CountryService(CountryReader countryReader) {
        this.countryReader = countryReader;
    }

    public Optional<Country> getMyCountry(String myCountry){
        return myCountryBean.myCountry(myCountry);
    }

    public List<Country> getAllCountries(){
        return countryReader.getCountries();
    }

    public List<String> getAllCountryNames(){
        return countryReader.getCountries().stream()
                .map(country -> country.getName())
                .collect(toList());
    }

    public Optional<String> getCountryCapital(int countryId){
        return countryReader.getCountries()
                .stream()
                .filter(country -> country.getId() == countryId)
                .map(country -> country.getCapital())
                .findFirst();
    }

    public Optional<Long> getCountryPopulation(int countryId){
        return countryReader.getCountries()
                .stream()
                .filter(country -> country.getId() == countryId)
                .map(country -> country.getPopulation())
                .findFirst();
    }

    public List<Country> getCountriesByContinent(String continent){
        return countryReader.getCountries()
                .stream()
                .filter(country -> country.getContinent().equals(continent))
                .collect(toList());
    }

    public Optional<List<String>> getCountryNeighbours(int countryId){
        return countryReader.getCountries()
                .stream()
                .filter(country -> country.getId() == countryId)
                .map(country -> country.getNeighbours())
                .findFirst();
    }

    public List<Country> getCountriesByContinentAndPopulation(String continent, long population){
        return countryReader.getCountries()
                .stream()
                .filter(country -> country.getContinent().equals(continent))
                .filter(country -> country.getPopulation() > population)
                .collect(toList());
    }

    public boolean countryContainsNeighbour(Country country, String neighbour){
        return country.getNeighbours().stream()
                .anyMatch(neighbourElement -> neighbourElement.equals(neighbour));
    }

    public List<Country> getCountriesWithNeighbourXWithoutNeighbourY(String neighbourX, String neighbourY){
        return countryReader.getCountries()
                .stream()
                .filter(country -> countryContainsNeighbour(country,neighbourX))
                .filter(country -> !countryContainsNeighbour(country,neighbourY))
                .collect(toList());
    }

    public Map<String, Long> getPopulationsForCountries(){
        return countryReader.getCountries().stream()
                .collect(toMap(Country::getName, Country::getPopulation));
    }

    public Map<String, List<Country>> getAllCountriesMappedToContinent(){
        return countryReader.getCountries().stream()
                .collect(groupingBy(country -> country.getContinent()));
    }
}
