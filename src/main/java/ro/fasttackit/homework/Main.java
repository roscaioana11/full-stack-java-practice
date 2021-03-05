package ro.fasttackit.homework;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Product product = Product.ProductBuilder.productBuilder().name("paine").price(10).build();
        Shop shop = new Shop();
        shop.add(product, 10);
        //shop.buy("paine1", 11);
        try{
            shop.buy("paine", 11);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("ceva");

        //lock Testing
        NoDuplicateProduct product1 = NoDuplicateProduct.NoDuplicateProductBuilder.productBuilder().name("iaurt").price(15)
                .category(Category.ELECTRONICS).category(Category.CLOTHES).build();
        System.out.println(product1.getCategories().size());
        List<Category> auxList = product1.getCategories();
        auxList.remove(0);
        System.out.println(product1.getCategories().size());
    }
}
