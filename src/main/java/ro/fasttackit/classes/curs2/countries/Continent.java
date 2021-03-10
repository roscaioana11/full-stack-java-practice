package ro.fasttackit.classes.curs2.countries;

import java.util.Optional;
import java.util.stream.Stream;

public enum Continent { //instante, obiecte care se creaza o sg data(Singleton)
    EUROPE(true, 1234321421),
    ASIA(true, 365689476),
    AFRICA(false, 57486538),
    AMERICA(true, 5432545),
    AUSTRALIA(false,5453634);

    private final boolean isNorthHemisphere;
    private final long area;

    Continent(boolean isNorthHemisphere, long area) {
        this.isNorthHemisphere = isNorthHemisphere;
        this.area = area;
    }

    public static Optional<Continent> of(String continentName) {
        return Stream.of(values())
                .filter(val -> val.name().equalsIgnoreCase(continentName))
                .findFirst();
    }

    public boolean isNorthHemisphere() {
        return isNorthHemisphere;
    }

    public long getArea() {
        return area;
    }
}
