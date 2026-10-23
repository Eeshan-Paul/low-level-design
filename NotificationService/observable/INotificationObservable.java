package observable;

import exception.CustomException;
import observer.IObserver;

public interface INotificationObservable {
    public void addObservers(IObserver observer);
    public void removeObservers(IObserver observer) throws CustomException;
    public void notifyObservers();
}
