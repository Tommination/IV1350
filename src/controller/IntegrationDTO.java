package controller;

import integration.AccountingHandler;
import integration.InventoryHandler;
import integration.PrinterHandler;
import integration.RegisterHandler;

public class IntegrationDTO {
    InventoryHandler inv;
    AccountingHandler acc;
    RegisterHandler reg;
    PrinterHandler prnt;
    public IntegrationDTO(InventoryHandler inventory, AccountingHandler accounting, RegisterHandler register, PrinterHandler printer){
        inv = inventory;
        acc = accounting;
        reg = register;
        prnt = printer;
    }

    public InventoryHandler getInv(){
        return inv;
    }
    public AccountingHandler getAcc(){
        return acc;
    }

}
