package model;

import DTOs.ItemDTO;
import DTOs.SaleDTO;
import DTOs.IntegrationDTO;
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
    private double totalCost = 0;
    private double totalVAT = 0;

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
    private double calculatePrice(ItemDTO product){
       double total = (product.getPrice());
       return total;
    }
    private double calculateVAT(ItemDTO product){
        double VATCost = (product.getPrice() * product.getVATRate());
        return VATCost;
    }
    private void updateTotal(ItemDTO scannedItem){
        totalCost += (calculatePrice(scannedItem) + calculateVAT(scannedItem));
        totalVAT += calculateVAT(scannedItem);
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
    private void increaseQuantity(SaleItem item, double amount){ item.addQuantity(amount);
    }

    /**
     * Finishes a sale by interacting with other units and then printing a receipt
     * @param comms
     * @param paidAmount
     * @return
     */
    public  double finishSale(IntegrationDTO comms, double paidAmount){
        SaleDTO thisSale = getSaleInfo();
        comms.getAcc().recordSale(thisSale);
        comms.getInv().updateInventory(thisSale);
        Payment saleFinalPayment = new Payment(thisSale, paidAmount);
        printReceipt(saleFinalPayment);
        return comms.getReg().updateRegister(saleFinalPayment);
    }
    public SaleDTO getSaleInfo(){
        return new SaleDTO(this, itemsInSale.getLast());
    }
    private void printReceipt(Payment amount) {
        receipt.printReceipt(new SaleDTO(this, itemsInSale.getLast()), amount);
    }

    /**
     * saves the time when a Sale started.
     * @return shows
     */
    public LocalTime getSaleTime() {
        return saleTime;
    }

    public ArrayList<SaleItem> getItemsInSale() {
        return itemsInSale;
    }

    public double getTotal() {
        return totalCost;
    }

    public double getTotalVAT() {
        return totalVAT;
    }
}
