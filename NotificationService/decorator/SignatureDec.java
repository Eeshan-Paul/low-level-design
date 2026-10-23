package decorator;

import notification.INotification;

public class SignatureDec extends INotificationDecorator{

    private static String sign;


    public SignatureDec(INotification notification,String sign) {
        super(notification);
        SignatureDec.sign = sign;
    }

    @Override
    public String getContent() {
        return new StringBuilder().append(notification.getContent()).append(" -> ").append(sign).toString();
    }

}
