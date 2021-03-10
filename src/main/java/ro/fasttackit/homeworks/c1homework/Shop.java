package ro.fasttackit.homeworks.c1homework;

import java.util.HashMap;

public class Shop {
    private HashMap<Product, Integer> inventory;

    public Shop() {
        this.inventory = new HashMap<>(); //initializez intern HashMap-ul ca dupa aceea sa il pot manipula numa cu functiile din clasa Shop
    }

    public void add(Product product, int inventoryCount){ //parametrii product&count vin dinafara metodei
        //boolean productAlreadyExists = false;
        Product existingProduct = null;
        for(Product existingProductKey : inventory.keySet()){ //am luat produsele existente 1 cate 1
            if(existingProductKey.getName().toLowerCase().trim()
                    .equals(product.getName().toLowerCase().trim())){ //toLowerCase-> face totul cu litere mici, .trim-> scoate spatiile din fata si din spate
                //productAlreadyExists = true;
                existingProduct = existingProductKey;
                break;
            }
        }
        //if(productAlreadyExists){
        if(existingProduct != null){
            inventory.put(existingProduct, inventory.get(existingProduct) + inventoryCount); // inventory.get(existingProduct)-> cantitatea care exista + inventoryCount-> cantitatea noua
        }else{
            inventory.put(product, inventoryCount);
        }
    }

    public void buy(String productName, int productCount){
        Product existingProduct = null;
        for(Product existingProductKey : inventory.keySet()){
            if(existingProductKey.getName().toLowerCase().trim()
                    .equals(productName.toLowerCase().trim())){
                existingProduct = existingProductKey;
                break;
            }
        }
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
}
