
package models;

import java.util.List;

public class Restaurant {
    private static int counter = 0;

    private int restaurantId;
    private String name;
    private String address;
    private List<Food> menu;

    
    public Restaurant(String name,String address)
    {
        counter++;
        this.restaurantId = counter;
        this.name = name;
        this.address = address;
    }

    /**
     * @return int return the restaurantId
     */
    public int getRestaurantId() {
        return restaurantId;
    }

    /**
     * @param restaurantId the restaurantId to set
     */
    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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

    /**
     * @return List<Food> return the menu
     */
    public List<Food> getMenu() {
        return menu;
    }

    /**
     * @param menu the menu to set
     */
    public void setMenu(List<Food> menu) {
        this.menu = menu;
    }

}
