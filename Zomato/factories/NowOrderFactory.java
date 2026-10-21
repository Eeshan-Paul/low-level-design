package factories;

import java.util.List;

import models.*;
import strategies.PaymentStrategy;

public class NowOrderFactory implements OrderFactory {

    @Override
    public Order createOrder(User user, Cart cart, Restaurant restaurant, List<Food> foodItems,
            PaymentStrategy paymentStrategy, String orderType) {
        Order order = null;
        if ("Delivery".equals(orderType))
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
        order.setScheduled("Now");
        order.setFoodItems(foodItems);
        order.setTotal(cart.getTotalCost());
        return order;
    }

}
