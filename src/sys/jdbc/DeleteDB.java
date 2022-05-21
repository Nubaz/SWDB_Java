package sys.jdbc;

import enums.StarWarsEra;

import java.sql.SQLException;
import java.sql.Statement;

public class DeleteDB {
    private static DeleteDB ddb = null;
    private final DBConn dbconn = DBConn.getInstance();

    public DeleteDB() {
    }

    public static DeleteDB getInstance() {
        if(ddb == null)
            ddb = new DeleteDB();
        return ddb;
    }

    public void delete(String cls, String pk) {
        if(dbconn.getConn() != null) {
            try {
                Statement stmt = dbconn.getConn().createStatement();
                stmt.execute("DELETE FROM " + cls +
                        " WHERE Name=" + "\"" + pk + "\"");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
