package ro.fasttackit.classes.curs2.countries;

import java.util.List;
import java.util.Objects;

public class Country {
    private final String name;
    private final String capital;
    private final Continent continent;
    private final long area;
    private final long population;
    private final List<String> neighbours;

    public Country(String name,String capital,Continent continent,long area,long population,List<String> neighbours) {
        this.name = name;
        this.capital = capital;
        this.continent = continent;
        this.area = area;
        this.population = population;
        this.neighbours = neighbours;
    }

    public Continent getContinent() {
        return continent;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public long getArea() {
        return area;
    }

    public long getPopulation() {
        return population;
    }

    public List<String> getNeighbours() {
        return neighbours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return area == country.area && population == country.population && Objects.equals(name,country.name) && Objects.equals(capital,country.capital) && Objects.equals(neighbours,country.neighbours);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,capital,area,population,neighbours);
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", area=" + area +
                ", population=" + population +
                ", neighbours=" + neighbours +
                '}';
    }
}
