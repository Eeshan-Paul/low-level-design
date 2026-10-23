package strategies;

import exception.CustomException;

public class EmailNotificationStrategy implements INotificationStrategy{

    private String emailId;

    public EmailNotificationStrategy(String emailId)
    {
        this.emailId = emailId;
    }

    @Override
    public void sendNotification(String content) throws CustomException {
        if (!emailId.contains("@") || !emailId.contains(".com"))
        {
            throw new CustomException("Please provide a valid email address.");
        }
        System.out.println("Notification : <" + content +"> is sent to "+ emailId);
    }

}
