package model;

import DTOs.ItemDTO;

/***
 * Class that represents an item being bought/sold
 */
public class Item {
    private String name;
    private String description;
    private double price;
    private double VATRate;
    /**
     * Creates an instance with parameters from a DTO
     */
    public Item(ItemDTO attributes){
        name = attributes.getName();
        description = attributes.getDescription();
        price = attributes.getPrice();
        VATRate = attributes.getVATRate();
    }
    public ItemDTO getItem(){
        ItemDTO details = new ItemDTO(name, description, price, VATRate);
        return details;
    }


}
