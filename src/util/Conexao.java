package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Miquéias
 */
public class Conexao {
    
    private static final String hostLocation = Tools.getConfig().getProperty("prop.connection.host");
    private static final String db_driver = Tools.getConfig().getProperty("prop.connection."+hostLocation+".driver");
    private static final String db_username = Tools.getConfig().getProperty("prop.connection."+hostLocation+".user");
    private static final String db_password = Tools.getConfig().getProperty("prop.connection."+hostLocation+".password");
    private static final String db_host = Tools.getConfig().getProperty("prop.connection."+hostLocation+".host");
    private static final String db_porta = Tools.getConfig().getProperty("prop.connection."+hostLocation+".port");

    private static final String db_url = "jdbc:sqlserver://" + db_host + ":" + db_porta + ";databaseName=Oxetil_Oficial";
    private static Connection connection = null;

    public Conexao() {
        Conexao.getConnection();
    }

    public static Connection getConnection() {
        try {
            Class.forName(db_driver);
            connection = DriverManager.getConnection(db_url, db_username, db_password);
        } catch (ClassNotFoundException cnfex) {
            System.err.println("Falha ao ler o driver JDBC.\n" + cnfex.getMessage());
        } catch (SQLException sqlex) {
            System.out.println("Impossível conectar com a base de dados.\n" + sqlex.getMessage());
        } catch (Exception ex) {
            System.out.println("Outro erro.\n" + ex.getMessage());
        }

        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
            connection = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getHost() {
        return db_host;
    }

}
