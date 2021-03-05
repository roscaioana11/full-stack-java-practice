package ro.fasttackit.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NoDuplicateProduct {
    private String name;
    private int price;
    private List<Category> categories;
    private String description;

    private NoDuplicateProduct(){
        this.categories = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public List<Category> getCategories() {
        return new ArrayList<>(categories); //se trimite o copie dupa lista originala, deci lista originala nu este niciodata accesata
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NoDuplicateProduct that = (NoDuplicateProduct) o;
        return price == that.price && Objects.equals(name,that.name) && Objects.equals(categories,that.categories) && Objects.equals(description,that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,price,categories,description);
    }

    @Override
    public String toString() {
        return "NoDuplicateProduct{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", categories=" + categories +
                ", description='" + description + '\'' +
                '}';
    }

    static class NoDuplicateProductBuilder {
        private NoDuplicateProduct product = new NoDuplicateProduct();

        public static NoDuplicateProductBuilder productBuilder(){

            return new NoDuplicateProductBuilder();
        }

        public NoDuplicateProductBuilder name(String name){
            product.name = name;
            return this;
        }
        public NoDuplicateProductBuilder price(int price){
            product.price = price;
            return this;
        }
        public NoDuplicateProductBuilder category(Category category){
            if(category != null){
                product.categories.add(category);
            }
            return this;
        }
        public NoDuplicateProductBuilder description(String description){
            product.description = description;
            return this;
        }

        public NoDuplicateProduct build(){
            return product;
        }
    }
}
