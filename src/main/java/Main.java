import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by jamal on 05/10/15.
 */
public class Main {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/plantondb";

    static final String USER = "root";
    static final String PASS = "7";

    public static void main(String[] args) {

        Connection conn = null;
        java.sql.Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Connected database successfully...");

            //View Join
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String query ="SELECT student.id, student.name, nilai.kode_kul, nilai.nama_kul, nilai.nilai" + " FROM student, nilai" + " WHERE student.id = nilai.id";
            ResultSet rs = stmt.executeQuery(query);
            System.out.println();
            System.out.println("ID,Nama, Kode Kululiah, Nama Kuliah, Nilai :");
            while (rs.next()) {
                String idmhs = rs.getString("id");
                String name = rs.getString("name");
                String kdkul = rs.getString("kode_kul");
                String namkul = rs.getString("nama_kul");
                String nlai = rs.getString("nilai");
                System.out.println(idmhs + "  " + name + "   " + kdkul + "  " + namkul + "  "+nlai);

            }
            System.out.println();
        } catch (ClassNotFoundException e) {
            System.err.println("Join Failed : "+e.getMessage());
        } catch (SQLException e) {
            System.err.println("Connection Failed : " + e.getMessage() + " " +e.getSQLState());
        } catch (Exception e) {
            System.err.println("Unknown Exception : "+e.getMessage());
        } finally{
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }
}
