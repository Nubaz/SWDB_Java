package sys.jdbc;

import java.sql.SQLException;
import java.sql.Statement;

public class UpdateDB {
    private static UpdateDB udb = null;
    private final DBConn dbconn = DBConn.getInstance();

    private UpdateDB() {
    }

    public static UpdateDB getInstance() {
        if(udb == null)
            udb = new UpdateDB();
        return udb;
    }

    public void update(String cls, String field, String value, String pk) {
        if(dbconn.getConn() != null) {
            try {
                Statement stmt = dbconn.getConn().createStatement();
                stmt.execute("UPDATE " + cls + " SET " +
                        field + "=" + value +
                        " WHERE Name=" + "\"" + pk + "\"");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
