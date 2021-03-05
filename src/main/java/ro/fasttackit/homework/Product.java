package ro.fasttackit.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Optional.ofNullable;

public class Product {
    private final String name;
    private final int price;
    private final List<Category> categories;
    private final String description;

    public Product(String name,int price,List<Category> categories,String description) {
        this.name = name;
        this.price = price;
        this.categories = ofNullable(categories)
                .map(ArrayList::new)
                .orElseGet(ArrayList::new);
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price && Objects.equals(name,product.name) && Objects.equals(categories,product.categories) && Objects.equals(description,product.description);
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

    static class ProductBuilder{
        private String name;
        private int price;
        private List<Category> categories;
        private String description;

        public ProductBuilder(){
            this.categories = new ArrayList<>();
        }
        public static ProductBuilder productBuilder(){
            return new ProductBuilder();
        }

        public ProductBuilder name(String name){
            this.name = name;
            return this;
        }
        public ProductBuilder price(int price){
            this.price = price;
            return this;
        }
        public ProductBuilder category(Category category){
//            if(this.categories == null){
//                this.categories = new ArrayList<>();
//            }
            this.categories.add(category);
            return this;
        }
        public ProductBuilder description(String description){
            this.description = description;
            return this;
        }

        public Product build(){
            return new Product(name, price, categories, description);
        }
    }
}
