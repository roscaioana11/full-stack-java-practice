package ro.fasttackit.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Optional.ofNullable;

public class NoDuplicateProduct {
    private String name;
    private int price;
    private List<Category> categories;
    private String description;

//    public NoDuplicateProduct(String name,int price,List<Category> categories,String description) {
//        this.name = name;
//        this.price = price;
//        this.categories = ofNullable(categories)
//                .map(ArrayList::new)
//                .orElseGet(ArrayList::new);;
//        this.description = description;
//    }

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
            if(product.categories == null){
                product.categories = new ArrayList<>();
            }
            product.categories.add(category);
            return this;
        }
        public NoDuplicateProductBuilder description(String description){
            product.description = description;
            return this;
        }

        public NoDuplicateProduct build(){
            product.categories = ofNullable(product.categories) //ii da lock sa nu mai poata fi editat
                    .map(ArrayList::new)
                    .orElseGet(ArrayList::new);
            return product;
        }
    }
}
