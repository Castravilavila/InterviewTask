import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadCsv {
    private String csvFile;
    private List validRows;
    private List invalidRows;

    public ReadCsv(String csvFile) {
        this.csvFile = csvFile;
        this.validRows = new ArrayList<String[]>();
        this.invalidRows = new ArrayList<String[]>();
    }

    public List getValidRows() {
        return validRows;
    }

    public void setValidRows(List validRows) {
        this.validRows = validRows;
    }

    public List getInvalidRows() {
        return invalidRows;
    }

    public void setInvalidRows(List invalidRows) {
        this.invalidRows = invalidRows;
    }

    /**
     * @return ArrayList of string arrays from parsed CSV
     */
    public ArrayList<String[]> parseCsv() {

        ArrayList<String[]> finalCsvArray = new ArrayList<>();
        try (
                Reader reader = Files.newBufferedReader(Paths.get(csvFile));
                CSVReader csvReader = new CSVReader(reader);) {
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                finalCsvArray.add(nextRecord);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return finalCsvArray;
    }

    /**
     * Filters the List argument of string arrays  and fills validRows variable with all
     * arrays that dont have any empty strings and invalidRows variable with all arrays that have
     * at least one empty string
     *
     * @param list of arrays of Strings
     */
    public void sortValidAndInvalidRows(List<String[]> list) {

        boolean isInvalid = false;

        for (String[] strArr : list) {

            for (int i = 0; i < strArr.length; i++) {
                if (!strArr[i].matches(".*\\w.*")) {
                    isInvalid = true;
                    break;
                }
            }

            if (isInvalid == true) {
                invalidRows.add(strArr);
                isInvalid = false;
                continue;
            }

            validRows.add(strArr);
        }
    }
}
