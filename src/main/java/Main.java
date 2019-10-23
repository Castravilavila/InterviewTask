import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        Log logger = new Log(DefVariables.LOG_FILE);
        ReadCsv myCsvReader = new ReadCsv(DefVariables.CSV_FILE_TO_READ);
        WriteToCsv myCsvWriter = new WriteToCsv(DefVariables.CSV_FILE_TO_WRITE);
        DataBaseCSV dataBaseCSV = new DataBaseCSV(DefVariables.DB_FILE);

        ArrayList<String[]> fullListOfRecords = myCsvReader.parseCsv();
        myCsvReader.sortValidAndInvalidRows(fullListOfRecords);
        myCsvWriter.writeArrayToFile(myCsvReader.getInvalidRows());

        dataBaseCSV.insertListInSqlTable(myCsvReader.getValidRows());

        logger.logCsvResults(fullListOfRecords,myCsvReader.getValidRows(),myCsvReader.getInvalidRows());

    }
}
