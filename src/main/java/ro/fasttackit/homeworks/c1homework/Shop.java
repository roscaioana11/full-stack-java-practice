package ro.fasttackit.homeworks.c1homework;

import java.util.HashMap;

public class Shop {
    private HashMap<Product, Integer> inventory;

    public Shop() {
        this.inventory = new HashMap<>(); //initializez intern HashMap-ul ca dupa aceea sa il pot manipula numa cu functiile din clasa Shop
    }

    public void add(Product product, int inventoryCount){ //parametrii product&count vin dinafara metodei
        //boolean productAlreadyExists = false;
        Product existingProduct = findProduct(product.getName());

        //if(productAlreadyExists){
        if(existingProduct != null){
            inventory.put(existingProduct, inventory.get(existingProduct) + inventoryCount); // inventory.get(existingProduct)-> cantitatea care exista + inventoryCount-> cantitatea noua
        }else{
            inventory.put(product, inventoryCount);
        }
    }

    public void buy(String productName, int productCount){
        Product existingProduct = findProduct(productName);

        if(existingProduct != null){
            if(inventory.get(existingProduct) >= productCount){
                inventory.put(existingProduct,inventory.get(existingProduct) - productCount);
            }else{
                throw new RuntimeException("Not enough products! There are " + inventory.get(existingProduct) + " " + existingProduct.getName() + " left.");
            }
        }else{
            throw new RuntimeException("Product not found!");
        }
    }

    public Product findProduct(String productName){
        Product existingProduct = null;
        for(Product existingProductKey : inventory.keySet()){
            if(existingProductKey.getName().toLowerCase().trim()
                    .equals(productName.toLowerCase().trim())){
                existingProduct = existingProductKey;
                break;
            }
        }
        return existingProduct;
    }
}
