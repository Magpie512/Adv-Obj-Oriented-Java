import java.io.FileWriter;
import java.io.IOException;

public class FileLogger extends BaseLogger {

    @Override
    public void onAlert(String message) {
        try (FileWriter writer = new FileWriter("alerts.log", true)) {
            writer.write(formatMessage(message) + "\n");
        } catch (IOException e) {
            System.err.println("FileLogger failed to write: " + e.getMessage());
        }
    }
}