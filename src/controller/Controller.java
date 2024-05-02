package controller;

import integration.AccountingHandler;
import integration.InventoryHandler;
import integration.PrinterHandler;
import integration.RegisterHandler;
import model.Sale;

/**
 * This is the Applications controller class, all calls to the
 * model will pass through an object of this class.
 */
public class Controller {
    private InventoryHandler inv;
    private AccountingHandler acc;
    private RegisterHandler reg;
    private PrinterHandler prnt;
    private Sale sale;

    public void setAccHandl(AccountingHandler acc) {
        this.acc = acc;
    }

    public void setPrntHandl(PrinterHandler prnt) {
        this.prnt = prnt;
    }

    public void setInvHandl(InventoryHandler inv) {
        this.inv = inv;
    }

    public void setRegHandl(RegisterHandler reg) {
        this.reg = reg;
    }
    /**
     * Starts a new sale, method must be the first called in a sale
     */
    public void startSale(){
        sale = new Sale(inv);
    }
}


