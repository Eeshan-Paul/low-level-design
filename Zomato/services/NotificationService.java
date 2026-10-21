package services;

import models.Food;
import models.Order;

public class NotificationService {

    public void Notify(Order order)
    {
        System.out.println("Notification: new " + order.getType() + " order placed!");
        System.out.println("-------------------------------------------------------");
        System.out.println("Order Id :" + order.getOrderId());
        System.out.println("Name: " + order.getUser().getName());
        System.out.println("From restaurant: "+order.getRestaurant());
        System.out.println("Items ordered: ");
        System.out.println("-------------------------------------------------------");
        for (Food food : order.getFoodItems())
        {
            System.out.println(" - "+ food.getName() +"    "+ food.getPrice());
        }
        System.out.println("Total: Rs " + order.getTotal());
        System.out.println("Scheduled for: " + order.getScheduled());
        System.out.println("Payment Done");
        System.out.println("-------------------------------------------------------");

    }
}
