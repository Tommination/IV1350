package view;

import controller.Controller;

/**
 * This is a placeholder for the real view. It has hardcoded executions for all system operations.
 */
public class View {
    private Controller contr;
/**
 * Creates a new instance, uses the specified controller for calls to other layers
 * @param contr The controller that is used for calls to other layers
 */
    public View(Controller contr){
        this.contr = contr;
    }
    /**
     * Performs a fake sale by calling all the system operations
     */
    public void runFakeExecution(){
        contr.startSale();
        System.out.println("A new sale has been started.");
    }
}
