import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class TestDB {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/proy_db?useSSL=false&allowPublicKeyRetrieval=true";
            String user = "root";
            String pass = "MgliyQs1H";
            
            Connection c = DriverManager.getConnection(url, user, pass);
            System.out.println("✓ Conexión exitosa");
            
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                System.out.println("User: " + rs.getString("username") + " - Pass: " + rs.getString("password") + " - Role: " + rs.getString("role_id"));
            }
            c.close();
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
