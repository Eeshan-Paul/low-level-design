package observable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import exception.CustomException;
import notification.INotification;
import observer.IObserver;

public class NotificationObservable implements INotificationObservable{

    private List<IObserver> observerList = null;
    private INotification currentNotification = null;

    @Override
    public void addObservers(IObserver observer) {
        if (observerList==null)
        {
            observerList = new ArrayList<>();
        }
        observerList.add(observer);
    }

    @Override
    public void removeObservers(IObserver observer) throws CustomException {
        if (!observerList.contains(observer))
        {
            throw new CustomException("Observer doesn't exist. Please give a valid observer.");
        }
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observerList.forEach(observer -> observer.update());
    }

    public void setNotification(INotification notification)
    {
        if (currentNotification==null)
        {
            currentNotification = notification;
        }
        currentNotification = notification;
        notifyObservers();
    }

    public INotification getNotification()
    {
        return currentNotification;
    }

    public String getNotificationContent()
    {
        return currentNotification.getContent();
    }

}
