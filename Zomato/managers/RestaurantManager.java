package managers;

import java.util.ArrayList;
import java.util.List;

import models.Restaurant;

public class RestaurantManager {
    private List<Restaurant> restaurantList;
    private static RestaurantManager instance = null;

    private RestaurantManager(){
        restaurantList = new ArrayList<>();
    }
    
    public static RestaurantManager getInstance()
    {
        if (instance==null)
        {
            instance = new RestaurantManager();
        }
        return instance;
    }
    public void addRestaurant(Restaurant restaurant)
    {
        restaurantList.add(restaurant);
    }

    public List<Restaurant> searchByLoc(String address)
    {
        List<Restaurant> restaurants = new ArrayList<>();
        for (Restaurant res:restaurantList)
        {
            if (res.getAddress().toLowerCase().contains(address.toLowerCase()))
            {
                restaurants.add(res);
            }
        }
        return restaurants;
    }
}
