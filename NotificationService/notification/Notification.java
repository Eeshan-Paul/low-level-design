package notification;

public class Notification implements INotification{
    private String text;

    public Notification(String text)
    {
        this.text = text;
    }

    @Override
    public String getContent() {
        return text;
    }
    
    public void setContent(String text)
    {
        this.text = text;
    }
}
