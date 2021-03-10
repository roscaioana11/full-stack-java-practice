package ro.fasttackit.classes.curs2.countries.composition;

import ro.fasttackit.classes.curs2.countries.Country;

import java.util.List;

public interface CountryProvider {
    List<Country> readCountries();
}
