package strategies;

import exception.CustomException;

public interface INotificationStrategy {
    public void sendNotification(String content) throws CustomException;
}
