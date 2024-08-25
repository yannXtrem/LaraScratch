/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funcoptions;
import app.Attribute;
import app.Model;
import app.Utils;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author yanni
 */
public class DatabaseConnection {
    private static String dbms;
    private static String name;
    private static String port;
    private static String host;
    private static String user;
    private static String password;
    private static boolean connected = false;
    private static String url;
    public static boolean isConnected(){
        return connected;
    }

    public static void init(String dbms, String user, String host, String port, String password, String name) {
        DatabaseConnection.dbms = dbms;
        DatabaseConnection.user = user;
        DatabaseConnection.host = host;
        DatabaseConnection.port = port;
        DatabaseConnection.password = password;
        DatabaseConnection.name = name;
    }
    public static String testServerConnection(){
        try{
            switch (dbms) {
                case "sqlite":
                    // Test SQLite connection
                    Class.forName("org.sqlite.JDBC");
                    return testConnection("jdbc:sqlite:"+name, "", "");
                case "sqlserver":
                    // Test SQL Server connection
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    return testConnection("jdbc:sqlserver://"+host+":"+port+";", user, password);
                default:
                    // Test MySQL and  PostgreSQL connection
                    if("mysql".equals(dbms)){
                        Class.forName("com.mysql.cj.jdbc.Driver");
                    } else {
                        Class.forName("org.postgresql.Driver");
                    }
                    return testConnection("jdbc:"+dbms+"://"+host+":"+port+"/", user, password);
            }
        }   catch (ClassNotFoundException ex) {
            //Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            return "Error with " + DatabaseConnection.class.getName() + "\nDriver not found : " + ex.getMessage();
        }
    }
    public static String testDatabaseConnection() {
        try{
            switch (dbms) {
                case "sqlite":
                    // Test SQLite connection
                    Class.forName("org.sqlite.JDBC");
                    return testConnection("jdbc:sqlite:"+name, "", "");
                case "sqlserver":
                    // Test SQL Server connection
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    return testConnection("jdbc:sqlserver://"+host+":"+port+";databaseName="+name, user, password);
                default:
                    // Test MySQL and  PostgreSQL connection
                    if("mysql".equals(dbms)){
                        Class.forName("com.mysql.cj.jdbc.Driver");
                    } else {
                        Class.forName("org.postgresql.Driver");
                    }
                    return testConnection("jdbc:"+dbms+"://"+host+":"+port+"/"+name, user, password);
            }
        }   
        catch (ClassNotFoundException ex) {
            //Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            return "Error with " + DatabaseConnection.class.getName() + "\nDriver not found : " + ex.getMessage();
        }
    }
    private static String testConnection(String url, String user, String password) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            if (connection != null) {
                connected = true;
                DatabaseConnection.url = url;
                return "Connected successfully to : " + url;
            } else {
                connected = false;
                return "Failed to connect to : " + url;
            }
        } catch (SQLException e) {
            return "An error occurred while connecting to : " + url + "\nError : "+ e.getSQLState() + "\nDescr : " + e.getMessage();
        }
    }
    public static List<Model> importDatabaseMetadata() {
        List<Model> tablesList = new ArrayList<>();
        try (Connection connectionInstance = DriverManager.getConnection(url, user, password)){
            DatabaseMetaData metaData = connectionInstance.getMetaData();
            ResultSet tables = metaData.getTables(null, null, "%", new String[]{"TABLE"});
            while (tables.next()) {
                String tableName = tables.getString("TABLE_NAME");
                //System.out.println("Table: " + tableName);
                Model table = new Model(Utils.toPhraseCase(tableName));
                //Import Table Attributes
                ResultSet columns = metaData.getColumns(null, null, tableName, "%");
                while (columns.next()) {
                    String columnName = columns.getString("COLUMN_NAME");
                    String columnType = columns.getString("TYPE_NAME");
                    //int columnSize = columns.getInt("COLUMN_SIZE");
                    Attribute column = new Attribute(columnName.toLowerCase(), Utils.convertSqlTypeToLaravelType(columnType));
                    table.addModelAttribute(column);
                    //System.out.println("\tColumn: " + columnName + " - Type: " + columnType + " - Size: " + columnSize);
                }
                //Import Table Relations
                ResultSet foreignKeys = metaData.getImportedKeys(null, null, tableName);
                while (foreignKeys.next()) {
                    //String fkTableName = foreignKeys.getString("FKTABLE_NAME");
                    String fkColumnName = foreignKeys.getString("FKCOLUMN_NAME");
                    String pkTableName = foreignKeys.getString("PKTABLE_NAME");
                    String pkColumnName = foreignKeys.getString("PKCOLUMN_NAME");
                    table.getModelAttributes().forEach((Attribute a) -> {
                        if(a.getName().equals(fkColumnName)){
                            a.setIsReference(true);
                            a.setRefModelName(Utils.toPhraseCase(pkTableName));
                            a.setRefModelAttribute(pkColumnName.toLowerCase());
                        }
                    });
                    //System.out.println("\tForeign Key: " + fkColumnName + " in " + fkTableName + " references " + pkColumnName + " in " + pkTableName);
                }
                tablesList.add(table);
            }   
        } 
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tablesList;
    }
}
