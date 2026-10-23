import decorator.BoldDec;
import decorator.INotificationDecorator;
import decorator.SignatureDec;
import notification.INotification;
import notification.Notification;
import observable.NotificationObservable;
import observer.Logger;
import observer.NotificationEngine;
import service.NotificationService;
import strategies.EmailNotificationStrategy;
import strategies.SMSNotificationStrategy;

public class NotificationController {

    public static void main(String args[])
    {
        NotificationService notificationService = NotificationService.getInstance();

        NotificationObservable notificationObservable = notificationService.getObservable();

        Logger logger = new Logger(notificationObservable);

        NotificationEngine notificationEngine = new NotificationEngine(notificationObservable);

        notificationEngine.addNotificationStrategy(new EmailNotificationStrategy("eeshan.paul@gmail.com"));
        notificationEngine.addNotificationStrategy(new SMSNotificationStrategy("9465348428"));

        notificationObservable.addObservers(logger);
        notificationObservable.addObservers(notificationEngine);

        INotification notification = new Notification("This is a simple notification for testing.");

        // decorate the notification
        notification = new BoldDec(notification);
        notification = new SignatureDec(notification, "Eeshan");

        notificationService.sendNotification(notification);
    
    }
}
