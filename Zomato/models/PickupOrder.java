package models;

public class PickupOrder extends Order {
    private String resAddress;

    public PickupOrder()
    {
        resAddress = "";
    }

    @Override
    public String getType() {
        return "Pickup";
    }

    

    /**
     * @return String return the resAddress
     */
    public String getResAddress() {
        return resAddress;
    }

    /**
     * @param resAddress the resAddress to set
     */
    public void setResAddress(String resAddress) {
        this.resAddress = resAddress;
    }

}
