<%--
  Created by IntelliJ IDEA.
  User: Thinkpad
  Date: 05/08/2021
  Time: 1:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Create Account</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<form action="/product?action=create" method="post">
    <div class="container">
        <h2>Thêm Mới Sản Phẩm</h2>
        <table class="table table-dark">
            <thead>
            <tr>
                <th>Id</th>
                <th>ProductName</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Color</th>
                <th>Description</th>
                <th>Category</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><input type="text" name="id" placeholder="Nhap ID"></td>
                <td><input type="text" name="productname" placeholder="Nhap ProductName"></td>
                <td><input type="text" name="price" placeholder="Nhap Price"></td>
                <td><input type="text" name="quantity" placeholder="Nhap Quantity"></td>
                <td><input type="text" name="color" placeholder="Nhap Color"></td>
                <td><input type="text" name="description" placeholder="Nhap Description"></td>
                <td>
                    <select type="text" name="category">
                        <option value="phone">Phone</option>
                        <option value="television">Television</option>
                        <option value="computer">Computer</option>
                        <option value="tulanh">Tu Lanh</option>
                        <option value="maygiat">May Giat</option>
                        <option value="conditionair">ConditionAir</option>
                    </select>
                </td>
            </tr>

            </tbody>
            <tr>
                <td>
                    <button type="submit" style="color: aquamarine">Thêm Mới Sản Phẩm</button>
                </td>
            </tr>
        </table>
    </div>
</form>
</body>
