package models;
import java.util.ArrayList;


import java.util.List;

public class Cart {
    private Restaurant restaurant;
    private List<Food> foodItems;

    public Cart()
    {
        restaurant = null;
        foodItems = new ArrayList<>();
    }

    public void addItem(Food food)
    {
        if (restaurant==null)
        {
            System.out.println("Select the restaurant first!");
            return;
        }
        foodItems.add(food);
    }

    public double getTotalCost()
    {
        Double total = 0.0;
        for (Food food: foodItems)
        {
            total += food.getPrice();
        }
        return total;
    }

    public void clearCart()
    {
        foodItems.clear();
        restaurant = null;
    }

    

    /**
     * @return Restaurant return the restaurant
     */
    public Restaurant getRestaurant() {
        return restaurant;
    }

    /**
     * @param restaurant the restaurant to set
     */
    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    /**
     * @return List<Food> return the foodItems
     */
    public List<Food> getFoodItems() {
        return foodItems;
    }

    /**
     * @param foodItems the foodItems to set
     */
    public void setFoodItems(List<Food> foodItems) {
        this.foodItems = foodItems;
    }

}
