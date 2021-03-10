package ro.fasttackit.classes.curs2.countries;

import ro.fasttackit.classes.curs2.countries.composition.InMemoryCountryProvider;
import ro.fasttackit.classes.curs2.countries.composition.ReportGenerator;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        var generator = new FileCountryReportGenerator("src/main/resources/countries.txt");
        generator.generateReport("output.txt");
        new InMemoryCountryReportGenerator().generateReport("romania.txt");
        InMemoryCountryProvider provider = new InMemoryCountryProvider();
        new ReportGenerator(provider).generateReport("moldova.txt");

        new ReportGenerator(Main::provideCountries);
    }

    private static List<Country> provideCountries() {
        return List.of(new Country("Hungary", "Budapest", Continent.EUROPE, 93030, 9_906_0000, List.of("ROU")));
    }
}
