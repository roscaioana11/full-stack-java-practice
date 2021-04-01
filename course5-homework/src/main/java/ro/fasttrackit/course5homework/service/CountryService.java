package ro.fasttrackit.course5homework.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.course5homework.domain.Country;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

@Service
public class CountryService {
    private final CountryReader countryReader;

    public CountryService(CountryReader countryReader) {
        this.countryReader = countryReader;
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



    public Optional<List<String>> getCountryNeighbours(int countryId){
        return countryReader.getCountries()
                .stream()
                .filter(country -> country.getId() == countryId)
                .map(country -> country.getNeighbours())
                .findFirst();
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
}
