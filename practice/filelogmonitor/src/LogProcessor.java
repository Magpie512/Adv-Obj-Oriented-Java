// specific commenting

import java.io.IOException; // File exception
import java.nio.file.Files; // File operations
import java.nio.file.Path; // File path

public class LogProcessor {

    private LogPublisher publisher;

    public LogProcessor(LogPublisher publisher){
        this.publisher = publisher; 
    }
    
    public void process(String filePath) throws IOException{
        Path path = Paths.get(filePath);
        Files.lines(path)
            .forEach(line -> publisher.publish(line));
    }
}