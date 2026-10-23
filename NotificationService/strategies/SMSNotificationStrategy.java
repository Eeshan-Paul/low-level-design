package strategies;

import exception.CustomException;

public class SMSNotificationStrategy implements INotificationStrategy{

    private String phoneNumber;

    public SMSNotificationStrategy(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void sendNotification(String content) throws CustomException {
        if (phoneNumber.length()!=10)
        {
            throw new CustomException("Please provide a valid phoneNumber.");
        }
        System.out.println("Notification <" + content +"> is sent to " + phoneNumber);
    }
}
