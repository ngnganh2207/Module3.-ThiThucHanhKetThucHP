package controllers;

import models.Product;
import services.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/product"})
public class ProductServlet extends HttpServlet {
    ProductService productService= new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        RequestDispatcher requestDispatcher;
        if(action==null){
            action="";
        }
        switch (action){
            case "create":
                requestDispatcher= req.getRequestDispatcher("/views/addNewProduct.jsp");
                requestDispatcher.forward(req,resp);
                break;
            case "edit":
                int indexEdit=Integer.parseInt(req.getParameter("index"));
                req.setAttribute("product",productService.listProduct.get(indexEdit));
                requestDispatcher= req.getRequestDispatcher("/views/editProduct.jsp");
                requestDispatcher.forward(req,resp);
                break;
            case "delete":
                int id= Integer.parseInt(req.getParameter("id"));
                productService.delete(id);
                resp.sendRedirect("/product");
                break;
            case "search":

                break;
            default:
                req.setAttribute("listProduct", productService.listProduct);
                requestDispatcher=req.getRequestDispatcher("views/showProduct.jsp");
                requestDispatcher.forward(req,resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        RequestDispatcher requestDispatcher;
        if(action==null){
            action="";
        }
//int id,String productName,double price,int quantity, String color, String description, String category
        int id= Integer.parseInt(req.getParameter("id"));
        String productName=req.getParameter("productname");
        double price= Double.parseDouble(req.getParameter("price"));
        int quantity= Integer.parseInt(req.getParameter("quantity"));
        String color= req.getParameter("color");
        String description= req.getParameter("description");
        String category= req.getParameter("category");
        Product product= new Product(id,productName,price,quantity,color,description,category);
        switch (action){
            case "create":
                productService.save(product);
                resp.sendRedirect("/product");
                break;
            case "edit":
                productService.editProduct(product);
                resp.sendRedirect("/product");
                break;
            case "delete":
                break;
            case "search":
                String nameFind= req.getParameter("name");
                req.setAttribute("findProduct",productService.findByName(nameFind));
                requestDispatcher=req.getRequestDispatcher("/views/searchProduct.jsp");
                requestDispatcher.forward(req,resp);
            default:

        }
    }
}
