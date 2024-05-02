package integration;

import DTOs.ItemDTO;
import model.ItemInInventory;

/**
 * Placeholder for an actual integration class that handles inventory
 */
public class InventoryHandler {
    private final ItemInInventory[] dummyInventory = new ItemInInventory[4];

    /**
     * Sets up the integration layer with the dummy data it will operate on.
     */
    public InventoryHandler() {
    ItemDTO banana = new ItemDTO("Banana", "Yellow", 12.5, 0.12, "1337");
    dummyInventory[0] = new ItemInInventory(banana, 15);
    ItemDTO onion = new ItemDTO("Onion", "Sustainably Farmed", 2.5, 0.12, "4242");
    dummyInventory[1] = new ItemInInventory(onion, 34);
    ItemDTO apple = new ItemDTO("Apple", "Green", 5.34, 0.08, "1234");
    dummyInventory[2] = new ItemInInventory(apple, 89);
    ItemDTO milk = new ItemDTO("Milk", "Whole, 2%", 19, 0.08, "1111");
    dummyInventory[3] = new ItemInInventory(milk, 60);
    }
    /**
     * Hittar ett item med matchande ID, skulle då egentligen kolla detta mot en riktig databas
     */
    public ItemDTO getItemDetails(String ID){
        for (int i = 0; i < dummyInventory.length; i++){
            if (dummyInventory[i].getQuantity() > 0){
                if (dummyInventory[i].getItemInfo().getID().equals(ID)){
                    return dummyInventory[i].getItemInfo();
                }
            }
        }
        return null;
    }

}
