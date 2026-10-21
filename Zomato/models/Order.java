package models;

import java.util.List;

import strategies.PaymentStrategy;

public abstract class Order {
    private static int counter = 0;
    private int orderId;
    private User user;
    private Restaurant restaurant;
    private List<Food> foodItems;
    private PaymentStrategy paymentStrategy;
    private Double total;
    private String scheduled = "";

    public abstract String getType();

    public Order()
    {
        user = null;
        restaurant = null;
        paymentStrategy = null;
        total = 0.0;
        orderId = ++counter;
        scheduled = "";
    }

    public boolean processPayment()
    {
        if (paymentStrategy!=null)
        {
            paymentStrategy.pay(total);
            return true;
        }
        else 
        {
            System.out.println("Please select a payment method to pay.");
            return false;
        }
    }

    /**
     * @return int return the orderId
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * @return User return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
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

    /**
     * @return PaymentStrategy return the paymentStrategy
     */
    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    /**
     * @param paymentStrategy the paymentStrategy to set
     */
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    /**
     * @return Double return the total
     */
    public Double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(Double total) {
        this.total = total;
    }

    /**
     * @return String return the scheduled
     */
    public String getScheduled() {
        return scheduled;
    }

    /**
     * @param scheduled the scheduled to set
     */
    public void setScheduled(String scheduled) {
        this.scheduled = scheduled;
    }

}
