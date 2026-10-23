package service;
import java.util.ArrayList;
import java.util.List;

import exception.CustomException;
import notification.INotification;
import observable.NotificationObservable;

public class NotificationService {

    private NotificationObservable notificationObservable;
    private static NotificationService notificationService;
    private List<INotification> notifications;

    private NotificationService()
    {
        notificationObservable = new NotificationObservable();
    }   

    public static NotificationService getInstance()
    {
        if (notificationService == null)
        {
            notificationService = new NotificationService();
        }
        return notificationService;
    }

    public NotificationObservable getObservable()
    {
        return notificationObservable;
    }

    public void sendNotification(INotification notification)
    {
        if (notifications==null) notifications = new ArrayList<>();
        notifications.add(notification);
        notificationObservable.setNotification(notification);
    }


    public List<INotification> getAllNotification()
    {
        if (notifications==null)
        {
            throw new CustomException("No notification is present.")
        }
        return notifications;
    }
}
