<%--
  Created by IntelliJ IDEA.
  User: Thinkpad
  Date: 05/08/2021
  Time: 8:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/product?action=edit" method="post">
    <div class="container">
        <h2>Edit Account</h2>
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
<%--------------------------------------------%>
                <td><input type="text" name="id" value="${product.id}" readonly></td>
                <td><input type="text" name="productname" value="${product.productName}"></td>
                <td><input type="text" name="price" value="${product.price}"></td>
                <td><input type="text" name="quantity" value="${product.quantity}"></td>
                <td><input type="text" name="color" value="${product.color}"></td>
                <td><input type="text" name="description" value="${product.description}"></td>
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
                    <button type="submit" style="color: aquamarine">Edit Product</button>
                </td>
            </tr>
        </table>
    </div>
</form>
</body>
</html>
