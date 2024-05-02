package model;

import DTOs.SaleDTO;

import java.util.ArrayList;

/**
 * Contains information from a Sale
 */
public class Receipt {
    String itemName;
    String ID;
    double totalCost;
    double totalVAT;
    double change;
    public void printReceipt(SaleDTO saleInfo, Payment payment){
        System.out.println("---------- RECEIPT ----------");
        System.out.println("Time of Sale: " + saleInfo.getSaleTime());
        ArrayList<SaleItem> soldItems = saleInfo.getItemsInSale();
        for (int i = 0; i < soldItems.size(); i++){
            itemName = soldItems.get(i).getItem().getName();
            ID = soldItems.get(i).getItem().getID();
            double quantity = soldItems.get(i).getQuantity();
            System.out.println(itemName + "x" + quantity + " ID " + ID);
        }
        totalCost = saleInfo.getTotal();
        totalVAT = saleInfo.getTotalVAT();
        change = payment.getChange();
        System.out.println("Total cost: " + totalCost + " | Total VAT: " + totalVAT + " | Change due: " + change );
    }
}
