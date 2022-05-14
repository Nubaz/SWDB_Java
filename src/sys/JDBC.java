package sys;

import characters.BountyHunter;
import characters.ForceUser;
import characters.JediSith;
import characters.Smuggler;
import enums.ForceUserType;
import enums.JediSithRank;
import enums.StarWarsEra;
import misc.BadRankExp;
import weapons.Blaster;
import weapons.Lightsaber;

import java.io.IOException;
import java.sql.*;

public class JDBC {
    static Connection conn = null;

    public static Connection getConn() throws SQLException, ClassNotFoundException {
        if(conn == null)
            startConn();
        return conn;
    }

    public static void startConn() throws ClassNotFoundException, SQLException {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/swdb_java";
            String user = "root";
            String pass = "antiguas";

            conn = DriverManager.getConnection(url, user, pass);
    }

    public static void closeConn() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void loadB(Service s, Statement stmt) {
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM blaster");
            while(rs.next()) {
                s.bserv.addB(
                        new Blaster(
                                rs.getString("Name"),
                                rs.getString("BType"),
                                rs.getInt("Shots"),
                                rs.getDouble("Cooldown")
                        )
                );
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadL(Service s, Statement stmt) {
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM lightsaber");
            while(rs.next()) {
                s.lserv.addL(
                        new Lightsaber(
                                rs.getString("Color"),
                                rs.getString("LType"),
                                rs.getString("Hilt")
                        )
                );
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadBH(Service s, Statement stmt) {
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM bountyhunter");
            while(rs.next()) {
                s.bhserv.addBH(
                        new BountyHunter(
                                rs.getString("Name"),
                                rs.getString("Planet"),
                                rs.getInt("Born_Year"),
                                StarWarsEra.valueOf(rs.getString("Born_Era")),
                                rs.getInt("Contracts_done"),
                                rs.getInt("Min_credits_contract")
                        )
                );
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadFU(Service s, Statement stmt) {
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM forceuser");
            while(rs.next()) {
                s.fuserv.addFU(
                        new ForceUser(
                                rs.getString("Name"),
                                rs.getString("Planet"),
                                rs.getInt("Born_Year"),
                                StarWarsEra.valueOf(rs.getString("Born_Era")),
                                rs.getInt("Yrs_practice"),
                                rs.getBoolean("Permadeath")
                        )
                );
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadJS(Service s, Statement stmt) {
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM jedisith");
            while(rs.next()) {
                s.jsserv.addJS(
                        new JediSith(
                                rs.getString("Name"),
                                rs.getString("Planet"),
                                rs.getInt("Born_Year"),
                                StarWarsEra.valueOf(rs.getString("Born_Era")),
                                rs.getInt("Yrs_practice"),
                                rs.getBoolean("Permadeath"),
                                ForceUserType.valueOf(rs.getString("JSType")),
                                JediSithRank.valueOf(rs.getString("JSRank"))
                        )
                );
            }
        } catch (SQLException | IOException | BadRankExp e) {
            e.printStackTrace();
        }
    }

    private static void loadS(Service s, Statement stmt) {
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM smuggler");
            while(rs.next()) {
                s.sserv.addS(
                        new Smuggler(
                                rs.getString("Name"),
                                rs.getString("Planet"),
                                rs.getInt("Born_Year"),
                                StarWarsEra.valueOf(rs.getString("Born_Era")),
                                rs.getInt("Shipments_nr"),
                                rs.getInt("Parsecs_travelled")
                        )
                );
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadObjects(Service s) {
        try {
            Statement stmt = conn.createStatement();

            loadB(s, stmt);
            loadL(s, stmt);
            loadBH(s, stmt);
            loadFU(s, stmt);
            loadJS(s, stmt);
            loadS(s, stmt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
