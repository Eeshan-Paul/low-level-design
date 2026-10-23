package decorator;

import notification.INotification;

public class BoldDec extends INotificationDecorator {

    private static final String BOLD = "\u001B[1m";
    private static final String RESET = "\u001B[0m";

    public static String makeBold(String text) {
        return BOLD + text + RESET;
    }


    public BoldDec(INotification inotification) {
        super(inotification);
    }

    @Override
    public String getContent() {
        String noti = notification.getContent();
        return makeBold(noti);
    }
    
}
