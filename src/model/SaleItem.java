package model;

import DTOs.ItemDTO;

/**
 * This class groups Items and a quantity of said item.
 */
public class SaleItem {
    private Item item;
    private double quantity;
     /**
      * Creates an instance
      */
    public SaleItem(Item good, double amount){
        item = good;
        quantity = amount;
    }

    public double getQuantity() {
        return quantity;
    }
    public void addQuantity(double amount){
        quantity += amount;
    }

    public ItemDTO getItem() {
        return item.getItem();
    }


}
