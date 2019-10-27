public class EmptyQueueException extends Exception {
    private String message;

    public EmptyQueueException() {
       this.message = ("The queue is empty. Cannot perform requested action");
    }

    @Override
    public String getMessage() {
        return message;
    }
}
