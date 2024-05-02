package model;

import DTOs.SaleDTO;

public class Payment {
    private double total;
    private double paidAmount;

    /**
     * Creates an instance, groups both values for payment
     * @param saleInfo where total comes from, an entire sale to improve encapsulation
     * @param amount how much the customer has paid.
     */
    public Payment(SaleDTO saleInfo, double amount){
        total = saleInfo.getTotal();
        paidAmount = amount;
    }

    public double getTotal() {
        return total;
    }

    /**
     * Calculates the change from a given payment
     * @return
     */
    public double getChange(){
        return getPaidAmount() - getTotal();
    }
    private double getPaidAmount() {
        return paidAmount;
    }
}
