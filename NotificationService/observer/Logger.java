package observer;

import observable.NotificationObservable;

public class Logger implements IObserver{
    NotificationObservable notificationObservable;

    public Logger(NotificationObservable notificationObservable)
    {
        this.notificationObservable = notificationObservable;
    }


    @Override
    public void update() {
        System.out.println("Logging : "+ notificationObservable.getNotificationContent());
    }

}
