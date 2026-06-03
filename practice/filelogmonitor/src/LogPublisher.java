import java.util.ArrayList;
import java.util.List;

public class LogPublisher {

    private List<LogListener> listeners = new ArrayList<>();
    public void addListener(LogListener listener) {
        // add listener to the list
            listeners.add(listener);
    }

    public void publish(String message) {
        // loop through listeners and call onAlert on each one'
        listeners.forEach(listener -> listener.onAlert(message));
        /* if not a lambda it would be 
        
        for (LogListener listener : listeners) {
            listener.onAlert(message);
        }
        
        */
    }
}