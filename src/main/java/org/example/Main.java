import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:h2:~/testdb", "sa", "");
            System.out.println("✅ CONEXIÓN EXITOSA A H2");
            System.out.println("📦 Driver: " + conn.getMetaData().getDriverName());
            System.out.println("🗄️  URL: " + conn.getMetaData().getURL());
            conn.close();
        } catch (Exception e) {
            System.out.println("❌ ERROR: " + e.getMessage());
            e.printStackTrace();
        }
    }
}