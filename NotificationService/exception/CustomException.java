package exception;

public class CustomException extends Exception{

    private String message;

    public CustomException(String message)
    {
        super(message);
        this.message = message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

}
