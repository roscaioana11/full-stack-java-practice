package ro.fasttackit.classes.curs2.countries;

import java.util.List;

import static ro.fasttackit.classes.curs2.countries.Continent.EUROPE;

public class InMemoryCountryReportGenerator extends CountryReportGenerator{

    @Override
    protected List<Country> readCountries() {
        return List.of(
                new Country("Romania",
                        "Bucharest",
                        EUROPE,
                        217889,
                        19_000_000,
                        List.of("HUN"))
        );
    }
}
