package sys.jdbc;

import characters.BountyHunter;
import characters.ForceUser;
import characters.JediSith;
import characters.Smuggler;
import weapons.Blaster;
import weapons.Lightsaber;

import java.sql.SQLException;
import java.sql.Statement;

public class WriteDB {
    private static WriteDB wdb = null;
    private final DBConn dbconn = DBConn.getInstance();
    private Statement stmt = null;

    private WriteDB() {
    }

    public static WriteDB getInstance() {
        if(wdb == null)
            wdb = new WriteDB();
        return wdb;
    }

    public void blaster(Blaster b) {
        if(dbconn.getConn() != null) {
            try {
                stmt = dbconn.getConn().createStatement();
                stmt.execute("INSERT INTO Blaster VALUES(" +
                        "\"" + b.getName() + "\"" + "," +
                        "\"" + b.getType() + "\"" + "," +
                        "\"" + b.getShots() + "\"" + "," +
                        "\"" + b.getCooldown() + "\"" +
                        ")");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void lightsaber(Lightsaber l) {
        if(dbconn.getConn() != null) {
            try {
                stmt = dbconn.getConn().createStatement();
                stmt.execute("INSERT INTO Lightsaber VALUES(" +
                        "\"" + l.getColor() + "\"" + "," +
                        "\"" + l.getType() + "\"" + "," +
                        "\"" + l.getHilt() + "\"" +
                        ")");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void bhunter(BountyHunter bh) {
        if(dbconn.getConn() != null) {
            try {
                stmt = dbconn.getConn().createStatement();
                stmt.execute("INSERT INTO BountyHunter VALUES(" +
                        "\"" + bh.getName() + "\"" + "," +
                        "\"" + bh.getPlanet() + "\"" + "," +
                        bh.getBorn().getYear() + "," +
                        "\"" + bh.getBorn().getEra() + "\"" + "," +
                        bh.getContracts_done() + "," +
                        bh.getMin_credits_contract() +
                        ")");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void forceuser(ForceUser fu) {
        if(dbconn.getConn() != null) {
            try {
                stmt = dbconn.getConn().createStatement();
                stmt.execute("INSERT INTO ForceUser VALUES(" +
                        "\"" + fu.getName() + "\"" + "," +
                        "\"" + fu.getPlanet() + "\"" + "," +
                        fu.getBorn().getYear() + "," +
                        "\"" + fu.getBorn().getEra() + "\"" + "," +
                        fu.getYrs_practice() + "," +
                        fu.isPermadeath() +
                        ")");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void jedisith(JediSith js) {
        if(dbconn.getConn() != null) {
            try {
                stmt = dbconn.getConn().createStatement();
                stmt.execute("INSERT INTO JediSith VALUES(" +
                        "\"" + js.getName() + "\"" + "," +
                        "\"" + js.getPlanet() + "\"" + "," +
                        js.getBorn().getYear() + "," +
                        "\"" + js.getBorn().getEra() + "\"" + "," +
                        js.getYrs_practice() + "," +
                        js.isPermadeath() + "," +
                        "\"" + js.getType() + "\"" + "," +
                        "\"" + js.getRank() + "\"" +
                        ")");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void smuggler(Smuggler s) {
        if(dbconn.getConn() != null) {
            try {
                stmt = dbconn.getConn().createStatement();
                stmt.execute("INSERT INTO Smuggler VALUES(" +
                        "\"" + s.getName() + "\"" + "," +
                        "\"" + s.getPlanet() + "\"" + "," +
                        s.getBorn().getYear() + "," +
                        "\"" + s.getBorn().getEra() + "\"" + "," +
                        s.getShipments_nr() + "," +
                        s.getParsecs_travelled() +
                        ")");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
