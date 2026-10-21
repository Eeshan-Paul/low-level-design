import managers.OrderManager;
import managers.RestaurantManager;
import services.NotificationService;
import models.*;
import strategies.*;
import factories.*;


import java.util.List;


public class zomato {
	private final RestaurantManager restaurantManager;
	private final OrderManager orderManager;
	private final NotificationService notificationService;

	public zomato() {
		restaurantManager = RestaurantManager.getInstance();
		orderManager = OrderManager.getInstance();
		notificationService = new NotificationService();
	}

	public void addRestaurant(Restaurant restaurant) {
		restaurantManager.addRestaurant(restaurant);
	}

	public List<Restaurant> searchRestaurants(String location) {
		return restaurantManager.searchByLoc(location);
	}

	public void addToCart(User user, Restaurant restaurant, Food food) {
		Cart cart = user.getCart();
		if (cart.getRestaurant() == null) {
			cart.setRestaurant(restaurant);
		} else if (cart.getRestaurant().getRestaurantId() != restaurant.getRestaurantId()) {
			throw new IllegalArgumentException("A cart can only contain items from one restaurant.");
		}
		cart.addItem(food);
	}

	public Order placeOrder(User user, OrderFactory orderFactory, PaymentStrategy paymentStrategy, String orderType) {
		Cart cart = user.getCart();
		if (cart.getRestaurant() == null || cart.getFoodItems().isEmpty()) {
			throw new IllegalStateException("Select a restaurant and add items before checkout.");
		}

		Order order = orderFactory.createOrder(user, cart, cart.getRestaurant(), cart.getFoodItems(), paymentStrategy,
				orderType);
		if (!order.processPayment()) {
			return null;
		}

		orderManager.addOrder(order);
		notificationService.Notify(order);
		cart.clearCart();
		return order;
	}

	public static void main(String[] args) {
		zomato app = new zomato();
		Restaurant restaurant = new Restaurant("Central Kitchen", "Downtown");
		Food food = new Food("Veggie Bowl", 249.0);
		restaurant.setMenu(List.of(food));
		app.addRestaurant(restaurant);

		User user = new User("Avery", "Downtown");
		List<Restaurant> nearbyRestaurants = app.searchRestaurants("Downtown");
		if (nearbyRestaurants.isEmpty()) {
			return;
		}

		app.addToCart(user, nearbyRestaurants.get(0), food);
		app.placeOrder(user, new NowOrderFactory(), new UpiPaymentStrategy("demo-account"), "Delivery");
	}
}
