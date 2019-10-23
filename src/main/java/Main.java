import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        ReadCsv myCsvReader = new ReadCsv(DefVariables.CSV_FILE_TO_READ);
        WriteToCsv myCsvWriter = new WriteToCsv(DefVariables.CSV_FILE_TO_WRITE);

        ArrayList<String[]> fullListOfRecords = myCsvReader.parseCsv();
        myCsvWriter.writeArrayToFile(fullListOfRecords);


    }
}
