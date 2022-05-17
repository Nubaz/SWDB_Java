package sys.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
    private static DBConn db_conn = null;
    static Connection conn = null;

    private DBConn() {
    }

    public static DBConn getInstance() {
        if(db_conn == null)
            db_conn = new DBConn();
        return db_conn;
    }

    public void startConn() throws SQLException, ClassNotFoundException {
        if(conn == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/swdb_java";
            String user = "root";
            String pass = "antiguas";

            conn = DriverManager.getConnection(url, user, pass);
        }
    }

    public static void closeConn() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
