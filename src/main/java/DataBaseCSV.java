import java.sql.*;
import java.util.List;

public class DataBaseCSV {
    private String sqlFile;

    public DataBaseCSV(String sqlFile) {
        this.sqlFile = sqlFile;
    }

    /**
     * This methods creats a new tablse if not present in db, clears it if it has any
     * content and inserts the argument list, it has a predefined number of 10 columns
     * @param list of String arrays
     * @throws SQLException
     */
    public void insertListInSqlTable(List<String[]> list) throws SQLException{

        String sqlCreateTable = "CREATE TABLE IF NOT EXISTS validrecords(\n"
                +" A text,"
                +" B text,"
                +" C text,"
                +" D text,"
                +" E text,"
                +" F text,"
                +" G text,"
                +" H text,"
                +" I text,"
                +" J text)";
        String sqlInsert = "INSERT INTO validrecords(A,B,C,D,E,F,G,H,I,J) VALUES(?,?,?,?,?,?,?,?,?,?)";
        String clearTable = "DELETE FROM validrecords";

        Connection conn = connect();
        Statement stmt = conn.createStatement();
        stmt.execute(sqlCreateTable);

        PreparedStatement pstmt2 = conn.prepareStatement(clearTable);
        pstmt2.executeUpdate();

        PreparedStatement pstmt = conn.prepareStatement(sqlInsert);
        for (String[] strArr:list) {

            pstmt.setString(1,strArr[0]);
            pstmt.setString(2,strArr[1]);
            pstmt.setString(3,strArr[2]);
            pstmt.setString(4,strArr[3]);
            pstmt.setString(5,strArr[4]);
            pstmt.setString(6,strArr[5]);
            pstmt.setString(7,strArr[6]);
            pstmt.setString(8,strArr[7]);
            pstmt.setString(9,strArr[8]);
            pstmt.setString(10,strArr[9]);
            pstmt.executeUpdate();
        }
        conn.close();
    }

    /**
     * Create a connection with database
     */
    private Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(this.sqlFile);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
