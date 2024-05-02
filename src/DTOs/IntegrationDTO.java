package DTOs;

import controller.Controller;
import integration.AccountingHandler;
import integration.InventoryHandler;
import integration.RegisterHandler;

public class IntegrationDTO {
    InventoryHandler inv;
    AccountingHandler acc;
    RegisterHandler reg;

    public IntegrationDTO(Controller contr){
        inv = contr.getInv();
        acc = contr.getAcc();
        reg = contr.getReg();
    }

    public InventoryHandler getInv(){
        return inv;
    }
    public AccountingHandler getAcc(){
        return acc;
    }
    public RegisterHandler getReg() {
        return reg;
    }
}
