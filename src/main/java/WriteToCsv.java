import com.opencsv.CSVWriter;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class WriteToCsv {
    private String csvFile;
    private Writer writer;
    private CSVWriter csvWriter;

    public WriteToCsv(String csvFile) throws IOException {
        this.csvFile = csvFile;
        this.writer = Files.newBufferedWriter(Paths.get(this.csvFile));
        this.csvWriter = new CSVWriter(writer);
    }

    public String getCsvFile() {
        return csvFile;
    }

    public void setCsvFile(String csvFile) {
        this.csvFile = csvFile;
    }

    /**
     * With the help of OpenCsv Library the argument list is stored
     * to a csv file
     * @param list of String arrays
     * @throws IOException
     */
    public void writeArrayToFile(List<String[]> list) throws IOException{
        Writer writter = Files.newBufferedWriter(Paths.get(this.csvFile));
        CSVWriter csvvWriter = new CSVWriter(writter);
        csvvWriter.writeAll(list, false);
        writer.close();
    }
}
