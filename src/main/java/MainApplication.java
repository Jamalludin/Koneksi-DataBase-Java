import java.sql.*;

/**
 * Created by jamal on 29/09/15.
 */
public class MainApplication {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/planktondb";
    static final String USER = "root";
    static final String PASS = "7";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/plantondb", "root", "7");

            System.out.println("Connected database successfully...");
            System.out.println("Inserting records into the table...");
            stmt = conn.createStatement();

            //Insert

            /*String sql = "INSERT INTO student " + "VALUES (9, 'Zara', 'yukum jaya')";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO student " + "VALUES (10, 'Mahnaz', 'bandar jaya')";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO student " + "VALUES (11, 'Zaid', 'gunung sugih')";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO student " + "VALUES(12, 'Sumit', 'mandala')";
            stmt.executeUpdate(sql);
            */

            //Update

           /* String sql = "UPDATE student " + "SET address = 'lampung' WHERE id in (1)";
            stmt.executeUpdate(sql);
            */

            //Delete

            String sql = "DELETE FROM student " + "WHERE id = 1";
            stmt.executeUpdate(sql);


        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }

}
