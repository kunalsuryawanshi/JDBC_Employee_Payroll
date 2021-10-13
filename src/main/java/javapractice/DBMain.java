/*
 * @author: KUNAL SURYAWANSHI
 */
package javapractice;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

public class DBMain {
    static String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service";
    static String userName = "root";
    static String password = "1234";

    /*
     * Purpose : To create employee payroll service database connectivity
     */
    public static void main(String[] args) {
        Connection connection;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded..!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        listDrivers();

        try {
            System.out.println("Connecting to database:" + jdbcURL);
            connection = DriverManager.getConnection(jdbcURL, userName, password);
            System.out.println("Connection Successful..!" + connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /*
     * Purpose : To check all the drivers registered with jdbc driver
     */
    private static void listDrivers() {
        Enumeration<Driver> driverList = DriverManager.getDrivers();
        while (driverList.hasMoreElements()) {
            Driver driverClass = driverList.nextElement();
            System.out.println("  " + driverClass.getClass().getName());
        }
    }

}
