package ro.fasttackit.homework;

import java.util.HashMap;

public class Shop {
    private HashMap<Product, Integer> inventory;

    public Shop() {
        this.inventory = new HashMap<>(); //initializez intern HashMap-ul ca dupa aceea sa il pot manipula numa cu functiile din clasa Shop
    }

    public void add(Product product, int inventoryCount){
        boolean productAlreadyExists = false;
        Product existingProduct = null;
        for(Product existingProductKey : inventory.keySet()){ //am luat produsele existente 1 cate 1
            if(existingProductKey.getName().toLowerCase().trim()
                    .equals(product.getName().toLowerCase().trim())){ //toLowerCase-> face totul cu litere mici, .trim-> scoate spatiile din fata si din spate
                productAlreadyExists = true;
                existingProduct = existingProductKey;
                break;
            }
        }
        if(productAlreadyExists){
            inventory.put(existingProduct, inventory.get(existingProduct) + inventoryCount); // inventory.get(existingProduct)-> cantitatea care exista + inventoryCount-> cantitatea noua
        }else{
            inventory.put(product, inventoryCount);
        }
    }

    //TODO buy function
}
