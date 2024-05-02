package DTOs;

import model.Receipt;
import model.Sale;
import model.SaleItem;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 * DTO for the Sale class, also contains the latest scanned item as it interacts with the view
 */
public class SaleDTO {
    private ArrayList<SaleItem> itemsInSale;
    private LocalTime saleTime;
    private Receipt receipt;
    private SaleItem latestScan;
    private double total;
    private double totalVAT;

    public SaleDTO(Sale sale, SaleItem latest){
        itemsInSale = sale.getItemsInSale();
        saleTime = sale.getSaleTime();
        receipt = sale.getReceipt();
        latestScan = latest;
        total = sale.getTotal();
        totalVAT = sale.getTotalVAT();
    }

    public LocalTime getSaleTime() {
        return saleTime;
    }

    public SaleItem getLatestScan() {
        return latestScan;
    }

    public ArrayList<SaleItem> getItemsInSale() {
        return itemsInSale;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public double getTotal() {
        return total;
    }

    public double getTotalVAT() {
        return totalVAT;
    }
}
