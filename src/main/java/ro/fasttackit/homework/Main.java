package ro.fasttackit.homework;

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
    }
}
