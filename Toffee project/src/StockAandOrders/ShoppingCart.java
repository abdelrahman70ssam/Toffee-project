package StockAandOrders;
import java.util.Scanner;
import java.lang.System;
import StockAandOrders.Item;

import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Item> items = new ArrayList<Item>();
    private int quantityForitem;

    public ArrayList<Item> getCart()
    {
        return items;
    }

    public void addItemToCart(Item item) {
        items.add(item);
    }

    public void removeItemFromCart(Item item) {
        items.remove(item);
    }

    public int cartSize() {
        return items.size();
    }

    public void showCart() {
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i).getName() + " - " + items.get(i).getPrice());
        }
    }

    public void deleteCart() {
        items.clear();
    }

    public void setQuantityForItem(int quantity , Item item)
    {
       if(item.getUnitType() == "units"){
           if(quantity > 50){
               System.out.println("can not buy more than 50 units per order");
           }
           else{
                quantityForitem = quantity ;
           }
       }
       else{
           if(quantity > 10){
               System.out.println("can not buy more than 10 kg per order");
           }
           else{
               quantityForitem = quantity ;
           }
       }
    }

}
