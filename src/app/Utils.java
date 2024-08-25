/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

/**
 *
 * @author yanni
 */
public class Utils {
    public static String toPhraseCase(String word){
        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    }
    public static String convertSqlTypeToLaravelType(String sqlType) {
        switch (sqlType.toUpperCase()) {
            case "VARCHAR":
            case "CHAR":
            case "TEXT":
            case "TINYTEXT":
            case "MEDIUMTEXT":
            case "LONGTEXT":
                return "string";
            case "INT":
            case "INTEGER":
            case "TINYINT":
            case "SMALLINT":
            case "MEDIUMINT":
            case "BIGINT":
                return "integer";
            case "FLOAT":
            case "DOUBLE":
            case "DECIMAL":
                return "float";
            case "DATE":
                return "date";
            case "DATETIME":
            case "TIMESTAMP":
                return "datetime";
            case "TIME":
                return "time";
            case "BOOLEAN":
            case "BIT":
                return "boolean";
            case "BLOB":
            case "TINYBLOB":
            case "MEDIUMBLOB":
            case "LONGBLOB":
                return "binary";
            default:
                return "string"; // Default to string if type is unknown
        }
    }
}
