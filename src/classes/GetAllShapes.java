package classes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.awt.*;
import java.sql.*;
import java.util.Properties;

import Shape.Shape;

import database.ConnectionClass;

public class GetAllShapes {

    private Connection conn;
    ConnectionClass ConData = new ConnectionClass();
    public ObservableList<Shape> getAllShapes() {
        ObservableList<Shape> list = FXCollections.observableArrayList();
        try{
            ConnectionClass connection = new ConnectionClass();
            if(connection.getConnection()) {
                ResultSet resultSet = connection.executeSQLSelectStatement("SELECT * FROM vat");
                while(resultSet.next()){
                    Shape tempRes = convertRowToShape(resultSet);
                    list.add(tempRes);
                }
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        return list;
    }

    private Shape convertRowToShape(ResultSet resultSet) throws SQLException{
        int id = resultSet.getInt("Id");
        String shapeName = resultSet.getString("ShapeName");
        double length = resultSet.getDouble("Length");
        double width = resultSet.getDouble("Width");
        double height = resultSet.getDouble("Height");
        double ray = resultSet.getDouble("Ray");
        Shape tempRes = new Shape(id, shapeName, length, width, height, ray);
        return  tempRes;
    }

    public boolean connect() {
        boolean result = false;
        if(conn == null){
            try{
                String url = ConData.getUrl();
                String user = ConData.getUser();
                String password = ConData.getPassword();
                conn = DriverManager.getConnection(url, user, password);
                result = true;
            } catch(Exception e){
                System.out.println(e);
            }
        } else{
            result = true;
        }
        return result;
    }

    public boolean addToDatabase(Shape shape) throws  SQLException {
        boolean result = false;
        PreparedStatement myStatement = null;
        try {
            if(connect()){
                myStatement = conn.prepareStatement("INSERT INTO vat (ShapeName, Length, Width, Height, Ray) VALUES (?, ?, ?, ?, ?)");
                myStatement.setString(1, shape.getShapeName());
                myStatement.setDouble(2, shape.getLength());
                myStatement.setDouble(3, shape.getWidth());
                myStatement.setDouble(4, shape.getHeight());
                myStatement.setDouble(5, shape.getRay());
                myStatement.executeUpdate();
                result = true;
            }
        } catch (Exception e){
            result = false;
            System.out.println(e);
        } finally {
            if(myStatement != null){
                conn.close();
                myStatement.close();
            }
        }
        return true;
    }
    public boolean deleteInDatabase(Shape shape) throws  SQLException{
        boolean result = false;
        PreparedStatement myStatement = null;
        try{
            if(connect()) {
                myStatement = conn.prepareStatement("DELETE FROM vat WHERE Id=?");
                myStatement.setInt(1, shape.getId());
                myStatement.executeUpdate();
                result = true;
            }
        } catch (Exception e) {
            result = false;
            System.out.println(e);
        } finally {
             if(myStatement != null){
                 conn.close();
                 myStatement.close();
             }
        }
        return result;
    }
}
