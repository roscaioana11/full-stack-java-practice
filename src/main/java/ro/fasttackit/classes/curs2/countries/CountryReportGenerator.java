package ro.fasttackit.classes.curs2.countries;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

abstract class CountryReportGenerator {

    public void generateReport(String outputFile) throws IOException {
        List<Country> countries = readCountries();
        writeReport(countries, outputFile);
    }

    public void writeReport(List<Country> countries, String outputFile) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            countries.stream()
                    .map(country -> country.getName() + "," + country.getCapital())
                    .forEach(line -> writeLine(writer, line));
        }
    }

    private void writeLine(BufferedWriter writer, String line) {
        try {
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected abstract List<Country> readCountries();
}
