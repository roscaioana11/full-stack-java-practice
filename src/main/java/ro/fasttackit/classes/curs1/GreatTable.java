package ro.fasttackit.classes.curs1;

import java.util.Objects;

public class GreatTable {
    private final int height;
    private final String colour;

    public GreatTable(int height, String colour) {
        this.height = height;
        this.colour = colour;
    }

    public String getColor() {
        return colour;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GreatTable greatTable = (GreatTable) o;
        return height == greatTable.height &&
                Objects.equals(colour, greatTable.colour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, colour);
    }

    @Override
    public String toString() {
        return "Table{" +
                "heigth=" + height +
                ", colour='" + colour + '\'' +
                '}';
    }
}
