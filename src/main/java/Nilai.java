import java.sql.*;

/**
 * Created by jamal on 03/10/15.
 */
public class Nilai {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/planktondb";
    static final String USER = "root";
    static final String PASS = "7";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Register Class Success");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/plantondb", "root", "7");
            stmt = conn.createStatement();

            //Insert

            /*String sql = "INSERT INTO nilai " + "VALUES (8, 5555, 'Basis Data', 'B')";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO nilai " + "VALUES (2, 5556, 'PAM', 'A')";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO nilai " + "VALUES(6, 5557, 'Pemogramam Mobile', 'A')";
            stmt.executeUpdate(sql);*/

            //Update

            /*String sql = "UPDATE nilai " + "SET nilai = 'A' WHERE id in (1)";
            stmt.executeUpdate(sql);*/

            //Delete

            String sql = "DELETE FROM nilai " + "WHERE id = 8";
            stmt.executeUpdate(sql);

        }
        catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        }
        catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    conn.close();
            }
            catch (SQLException se) {}// do nothing
            try {
                if (conn != null)
                    conn.close();
            }
            catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Success");

    }
}