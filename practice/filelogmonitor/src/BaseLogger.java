import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class BaseLogger implements LogListener {
    // Shared Utility - both subclasses will use
    protected String formatMessage(String message){
        String timestamp = LocalDateTime.now()
            .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return "[" + timestamp + "] " + message;
    }

    //still abstract - subclasses must provide their own implementations
    @Override
    public abstract void onAlert(String message);
}