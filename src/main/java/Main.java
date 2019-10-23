import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws Exception {

        Log logger;
        ReadCsv myCsvReader;
        WriteToCsv myCsvWriter;
        DataBaseCSV dataBaseCSV;

        //Create all classes
        File configFile = new File("config.properties");
        try {
            FileReader reader = new FileReader(configFile);
            Properties props = new Properties();
            props.load(reader);

            logger = new Log(props.getProperty("logFile"));
            myCsvReader = new ReadCsv(props.getProperty("csvToReadFile"));
            myCsvWriter = new WriteToCsv(props.getProperty("csvToWriteFile"));
            dataBaseCSV = new DataBaseCSV(props.getProperty("dbFile"));

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
            reader.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
