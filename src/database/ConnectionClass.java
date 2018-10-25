package database;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import java.io.*;

public class ConnectionClass {
    private Connection conn;
    private String url;
    private String password;
    private String user;
    private Statement statement;

    public ConnectionClass() {
        conn = null;
        url = "jdbc:mysql://localhost/vat_database?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        user = "root";
        password = "";
        statement = null;
    }

    public String getUrl() {
        return this.url;
    }
    public String getUser(){
        return this.user;
    }
    public String getPassword() {
        return this.password;
    }

    public boolean getConnection() {
        boolean result = false;
        if (conn == null) {
            try {

                // Try to create a connection with the library database
                conn = DriverManager.getConnection(this.url, this.user, this.password);

                if (conn != null) {
                    statement = conn.createStatement();
                }
                result = true;
            } catch (SQLException e) {
                System.out.println(e);
                result = false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // A connection was already initalized.
            result = true;
        }
        return result;

        /*try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //.newInstance();
            //this.con = DriverManager.getConnection(this.url, this.user, this.password);
        } catch(Exception e){
            e.printStackTrace();
            System.out.println(e);
        }*/
    }

    public boolean connectionIsOpen() {
        boolean open = false;
        if(conn != null && statement != null) {
            try{
                open = !conn.isClosed() && !statement.isClosed();
            } catch(SQLException e){
                System.out.println(e);
                open = false;
            }
        }
        return open;
    }

    public void closeConnection() {
        try{
            statement.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ResultSet executeSQLSelectStatement(String query){
        ResultSet resultSet =  null;
        if(query != null & connectionIsOpen()){
            try{
                resultSet = statement.executeQuery(query);
            } catch(SQLException e){
                System.out.println(e);
                resultSet = null;
            }
        }
        return  resultSet;
    }
}