<%--
  Created by IntelliJ IDEA.
  User: Thinkpad
  Date: 05/08/2021
  Time: 1:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Thông Tin Sản Phẩm</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<div>
<h5><a href="/product?action=create" style="color: white; border: maroon;background-color: cornflowerblue" > + Add new product</a></h5>
   <form action="/product?action=search" method="post">
       <input type="text" name="search" placeholder="Nhap Ten Can Tim"><button type="submit">Search</button>
    </form>
</div>
<table class="table table-dark">
    <thread>
        <tr style="background-color: blue">
<%--int id,String productName,double price,int quantity, String color, String description, String category--%>
            <th>Id</th>
            <th>ProductName</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Color</th>
            <th>Description</th>
            <th>Category</th>
            <th>EDIT</th>
            <th>DELETE</th>
        </tr>
    </thread>
    <c:forEach items="${listProduct}" var="product" varStatus="loop">
        <tr>
            <td>${product.id}</td>
            <td>${product.productName}</td>
            <td>${product.price}</td>
            <td>${product.quantity}</td>
            <td>${product.color}</td>
            <td>${product.description}</td>
            <td>${product.category}</td>
            <td><a href="/product?action=edit&index=${loop.index}">Edit</a></td>
            <td><a href="/product?action=delete&id=${product.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

