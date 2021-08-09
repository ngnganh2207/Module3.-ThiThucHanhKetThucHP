package down;

import models.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

public class CRUDProduct {
    static Connection connection= ConnectionCSDL.getConnection();
    public static ArrayList<Product> showProduct() throws SQLException{
        String sqlSelect="select * from sanpham";
        Statement statement= connection.createStatement();
        ResultSet resultSet=statement.executeQuery(sqlSelect);
        ArrayList<Product> listProduct= new ArrayList<>();
        while (resultSet.next()){
//int id,String productName,double price,int quantity, String color, String description, String category
            int id=resultSet.getInt("id");
            String productname= resultSet.getString("productname");
            double price= resultSet.getDouble("price");
            int quantity= resultSet.getInt("quantity");
            String color= resultSet.getString("color");
            String description= resultSet.getString("description");
            String category= resultSet.getString("category");

            listProduct.add( new Product(id,productname,price,quantity,color,description,category));
        }
        return listProduct;
    }

    public static void saveProduct(Product product) throws SQLException {
        String sqlSave= "insert into sanpham value (?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement= connection.prepareStatement(sqlSave);
//int id,String productName,double price,int quantity, String color, String description, String category
        preparedStatement.setInt(1,product.getId());
        preparedStatement.setString(2,product.getProductName());
        preparedStatement.setDouble(3,product.getPrice());
        preparedStatement.setInt(4,product.getQuantity());
        preparedStatement.setString(5,product.getColor());
        preparedStatement.setString(6,product.getDescription());
        preparedStatement.setString(7,product.getCategory());
        preparedStatement.execute();
    }

    public static void editProduct(Product product) throws Exception{
        String sqlEdit="update sanpham  set productname=?,price=?,quantity=?,color=?,description=?,category=? where id=?";
//int id,String productName,double price,int quantity, String color, String description, String category
        PreparedStatement preparedStatement= connection.prepareStatement(sqlEdit);
        preparedStatement.setInt(7,product.getId());
        preparedStatement.setString(1,product.getProductName());
        preparedStatement.setDouble(2,product.getPrice());
        preparedStatement.setInt(3,product.getQuantity());
        preparedStatement.setString(4,product.getColor());
        preparedStatement.setString(5,product.getDescription());
        preparedStatement.setString(6,product.getCategory());
        preparedStatement.execute();
    }

    public static void deleteProduct(int id) throws Exception{
        String sqlDelete="delete from sanpham where id=?";
        PreparedStatement preparedStatement= connection.prepareStatement(sqlDelete);
        preparedStatement.setInt(1,id);
        preparedStatement.execute();
    }
}
