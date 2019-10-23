import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {

        //Create all classes
        Log logger = new Log(DefVariables.LOG_FILE);
        ReadCsv myCsvReader = new ReadCsv(DefVariables.CSV_FILE_TO_READ);
        WriteToCsv myCsvWriter = new WriteToCsv(DefVariables.CSV_FILE_TO_WRITE);
        DataBaseCSV dataBaseCSV = new DataBaseCSV(DefVariables.DB_FILE);

        //Created arraylist that will store the csv data
        ArrayList<String[]> fullListOfRecords = myCsvReader.parseCsv();

        //filtered the valid and the invalid data
        myCsvReader.sortValidAndInvalidRows(fullListOfRecords);

        //write the invalid data to a csv file
        myCsvWriter.writeArrayToFile(myCsvReader.getInvalidRows());

        //insert to a db the valid data
        dataBaseCSV.insertListInSqlTable(myCsvReader.getValidRows());

        //log the result to a log file
        logger.logCsvResults(fullListOfRecords,myCsvReader.getValidRows(),myCsvReader.getInvalidRows());

    }
}
