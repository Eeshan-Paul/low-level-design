package observer;

import java.util.ArrayList;
import java.util.List;

import exception.CustomException;
import observable.NotificationObservable;
import strategies.INotificationStrategy;

public class NotificationEngine implements IObserver{

    private NotificationObservable notificationObservable;
    private List<INotificationStrategy> notificationStrategies;

    public NotificationEngine(NotificationObservable notificationObservable)
    {
        this.notificationObservable = notificationObservable;
    }

    public void addNotificationStrategy(INotificationStrategy notificationStrategy)
    {
        if (notificationStrategies==null)
        {
            notificationStrategies = new ArrayList<>();
        }
        notificationStrategies.add(notificationStrategy);
    }

    @Override
    public void update() {
        notificationStrategies.forEach(notificationStrategy -> {
            try {
                notificationStrategy.sendNotification(notificationObservable.getNotificationContent());
            } catch (CustomException e) {
                System.out.println(e.getMessage());
            }
        });
    }

    

}
