package ro.fasttackit.homework;

public class Main {
    public static void main(String[] args) {
        Product product = Product.ProductBuilder.productBuilder().name("paine").price(10).build();
        Shop shop = new Shop();
        shop.add(product, 10);
    }
}
