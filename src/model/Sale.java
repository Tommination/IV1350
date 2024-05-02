package model;

import DTOs.ItemDTO;
import DTOs.SaleDTO;
import integration.InventoryHandler;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 * A sale made by the store, a unit that is payed for by one customer with one payment
 */
public class Sale {
    private InventoryHandler inventory;
    private ArrayList<SaleItem> itemsInSale;
    private LocalTime saleTime;
    private Receipt receipt;
    private double total = 0;

    /**
     * Creates a new instance and records the time at creation.
     */
    public Sale(InventoryHandler inv){
        saleTime =  LocalTime.now();
        receipt = new Receipt();
        itemsInSale = new ArrayList<SaleItem>();
        inventory = inv;
    }

    /**
     * Checks for an identifier in the sale and if there isnt one passes check to integration layer
     */
    public SaleDTO checkIdentifier(String ID){
        if (IDinSale(ID) != null){
            increaseQuantity(IDinSale(ID), 1);
            SaleItem increasedItem = IDinSale(ID);
            updateTotal(increasedItem.getItem());
            return new SaleDTO(this, increasedItem);
        }
        else {
            if (inventory.getItemDetails(ID) != null){
                Item itemFromDB = new Item(inventory.getItemDetails(ID));
                updateTotal(itemFromDB.getItem());
                addItemToSale(itemFromDB);
                return new SaleDTO(this, itemsInSale.getLast());
            }
        }
    return null;
    }

    private void updateTotal(ItemDTO scannedItem){
        total += scannedItem.getPrice();
    }

    private void addItemToSale(Item item){
        SaleItem itemToAdd = new SaleItem(item, 1);;
        itemsInSale.add(itemToAdd);
    }

    private SaleItem IDinSale(String ID){
        for (int i = 0; i < itemsInSale.size(); i++){
            SaleItem itemInSale = itemsInSale.get(i);
            if (itemInSale.getItem().getID().equals(ID)) {
                return itemInSale;
            }
        }
        return null;
    }
    private void increaseQuantity(SaleItem item, double amount){
        item.addQuantity(amount);
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public LocalTime getSaleTime() {
        return saleTime;
    }

    public ArrayList<SaleItem> getItemsInSale() {
        return itemsInSale;
    }

    public double getTotal() {
        return total;
    }
}
