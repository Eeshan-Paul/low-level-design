package factories;

import java.util.List;

import models.Cart;
import models.DeliveryOrder;
import models.Food;
import models.Order;
import models.PickupOrder;
import models.Restaurant;
import models.User;
import strategies.PaymentStrategy;

public class SchedulerOrderFactory implements OrderFactory{

    private String scheduleTime;

    public SchedulerOrderFactory(String scheduledTime)
    {
        this.scheduleTime = scheduledTime;
    }

    @Override
    public Order createOrder(User user, Cart cart, Restaurant restaurant, List<Food> foodItems,
            PaymentStrategy paymentStrategy, String orderType) {
        Order order = null;
        if (orderType == "Delivery")
        {
            DeliveryOrder deliveryOrder = new DeliveryOrder();
            deliveryOrder.setAddress(user.getAddress());
            order = deliveryOrder;
        }
        else 
        {
            PickupOrder pickupOrder = new PickupOrder();
            pickupOrder.setResAddress(restaurant.getAddress());
            order = pickupOrder;
        }
        order.setUser(user);
        order.setPaymentStrategy(paymentStrategy);
        order.setRestaurant(restaurant);
        order.setScheduled(scheduleTime);
        order.setFoodItems(foodItems);
        order.setTotal(cart.getTotalCost());
        return order;
    }

}
