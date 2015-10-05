import java.sql.*;

/**
 * Created by jamal on 03/10/15.
 */
public class MataKuliah {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/planktondb";
    static final String USER = "root";
    static final String PASS = "7";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connected database successfully...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/plantondb", "root", "7");
            System.out.println("Inserting records into the table...");
            stmt = conn.createStatement();

            //Insert

            /*String sql = "INSERT INTO matakuliah " + "VALUES (1239, 'Basis Data', 3)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO matakuliah " + "VALUES (3248, 'PAM', 3)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO matakuliah " + "VALUES(2432, 'Pemogramam Mobile', 3)";
            stmt.executeUpdate(sql);*/

            //Update

            /*String sql = "UPDATE matakuliah " + "SET nama_kul = 'Studi Islam' WHERE kode_kul in (1)";
            stmt.executeUpdate(sql);*/

            //Delete

            String sql = "DELETE FROM matakuliah " + "WHERE kode_kul = 3241";
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
