package decorator;

import notification.INotification;

public abstract class INotificationDecorator implements INotification{
    public INotification notification = null;

    public INotificationDecorator(INotification notification)
    {
        this.notification  = notification;
    }

}
