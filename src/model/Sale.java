package model;

import java.time.LocalTime;

/**
 * A sale made by the store, a unit that is payed for by one customer with one payment
 */
public class Sale {
    private LocalTime saleTime;
    private Receipt receipt;
    /**
     * Creates a new instance and records the time at creation.
     */
    public Sale(){
        saleTime =  LocalTime.now();
        receipt = new Receipt();
    }
}
