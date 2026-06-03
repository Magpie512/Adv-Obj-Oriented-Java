public class ConsoleLogger extends BaseLogger {
    
    @Override
    public void onAlert(String message) {
        System.out.println(formatMessage(message));
    }
}
