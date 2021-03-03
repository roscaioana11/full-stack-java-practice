package ro.fasttackit.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Optional.ofNullable;

public class DuplicatedProduct {
    private String name;
    private int price;
    private List<Category> categories;
    private String description;

//    public DuplicatedProduct(String name,int price,List<Category> categories,String description) {
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
        DuplicatedProduct that = (DuplicatedProduct) o;
        return price == that.price && Objects.equals(name,that.name) && Objects.equals(categories,that.categories) && Objects.equals(description,that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,price,categories,description);
    }

    @Override
    public String toString() {
        return "DuplicatedProduct{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", categories=" + categories +
                ", description='" + description + '\'' +
                '}';
    }

    static class DuplicatedProductBuilder {
        private DuplicatedProduct product = new DuplicatedProduct();

        public static DuplicatedProductBuilder productBuilder(){

            return new DuplicatedProductBuilder();
        }

        public DuplicatedProductBuilder name(String name){
            product.name = name;
            return this;
        }
        public DuplicatedProductBuilder price(int price){
            product.price = price;
            return this;
        }
        public DuplicatedProductBuilder category(Category category){
            if(product.categories == null){
                product.categories = new ArrayList<>();
            }
            product.categories.add(category);
            return this;
        }
        public DuplicatedProductBuilder description(String description){
            product.description = description;
            return this;
        }

        public DuplicatedProduct build(){
            product.categories = ofNullable(product.categories) //ii da lock sa nu mai poata fi editat
                    .map(ArrayList::new)
                    .orElseGet(ArrayList::new);
            return product;
        }
    }
}
