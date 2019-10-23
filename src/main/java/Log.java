import java.io.IOException;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class Log {
    private String logFile;
    private Logger logger;
    private FileHandler fileHandler;

    public Log(String logFile) throws IOException {
        this.logFile = logFile;
        this.fileHandler = new FileHandler(logFile, true);
        this.logger = Logger.getLogger("MyLog");
        this.logger.addHandler(fileHandler);

    }

    public void info(String msg) {
        logger.info(msg);
    }

    /**
     * Logs to a text file details about Data received from csv
     * @param dataReceived
     * @param validRows
     * @param invalidRows
     */
    public void logCsvResults(List<String[]> dataReceived, List<String[]> validRows, List<String[]> invalidRows) {
        logger.info("Data received: " + dataReceived.size() + " rows\n" +
                "Valid Rows: " + validRows.size() + " rows\n" +
                "Invalid Rows: " + invalidRows.size() + " rows");
    }


}