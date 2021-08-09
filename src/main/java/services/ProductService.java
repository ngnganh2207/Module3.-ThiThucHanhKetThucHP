package services;

import down.CRUDProduct;
import models.Product;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProductService {
    public static ArrayList<Product> listProduct= new ArrayList<>();
    public ProductService(){
        try {
            listProduct= CRUDProduct.showProduct();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void save(Product product){
        try {
            CRUDProduct.saveProduct(product);
            listProduct = CRUDProduct.showProduct();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void editProduct(Product product){
        try {
            CRUDProduct.editProduct(product);
            listProduct= CRUDProduct.showProduct();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int id){
        try {
            CRUDProduct.deleteProduct(id);
            listProduct= CRUDProduct.showProduct();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Product findByName(String name){
        for (Product product: listProduct ) {
            if(product.getProductName().contains(name)){
                return product;
            }
        }
        return null;
    }
}
