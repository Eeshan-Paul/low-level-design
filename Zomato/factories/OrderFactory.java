package factories;

import java.util.List;

import models.*;
import strategies.PaymentStrategy;

public interface OrderFactory {
    public Order createOrder(User user,Cart cart,Restaurant restaurant,List<Food> foodItems,PaymentStrategy paymentStrategy,String orderType);
    
}
