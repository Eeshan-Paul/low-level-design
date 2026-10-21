package models;

public class DeliveryOrder  extends Order{
    private String address;

    public DeliveryOrder()
    {
        address = "";
    }

    @Override
    public String getType() {
        return "Delivery";
    }

    

    /**
     * @return String return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

}
