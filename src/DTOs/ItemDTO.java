package DTOs;

public class ItemDTO {
    private String name;
    private String description;
    private double price;
    private double VATRate;
    /**
     * Creates a DTO for the class Item, with the attributes of Item
     */
    public ItemDTO(String name, String description, double price, double VATRate){
        this.name = name;
        this.description = description;
        this.price = price;
        this.VATRate = VATRate;
    }
    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public double getPrice() {
        return price;
    }

    public double getVATRate() {
        return VATRate;
    }
}
