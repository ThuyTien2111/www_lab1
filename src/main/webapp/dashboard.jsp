<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 9/10/2023
  Time: 11:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <!-- Thêm liên kết đến Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h1>Danh Sách Người Dùng</h1>
    <!-- Nút Thêm Người Dùng -->
    <a href="AddUserServlet" class="btn btn-primary mb-3">Thêm Người Dùng</a>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Họ và Tên</th>
            <th>Email</th>
            <th>Status</th>
        </tr>
        </thead>
        <tbody>
        <!-- Lặp qua danh sách người dùng và hiển thị thông tin -->
        <c:forEach var="user" items="${userList}">
            <tr>
                <td>${user.id}</td>
                <td>${user.fullName}</td>
                <td>${user.email}</td>
                <td>
                    <!-- Nút Xóa Người Dùng -->
                    <a href="DeleteUserServlet?id=${user.id}" class="btn btn-danger btn-sm">Xóa</a>
                    <!-- Nút Sửa Người Dùng -->
                    <a href="EditUserServlet?id=${user.id}" class="btn btn-warning btn-sm">Sửa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<!-- Thêm liên kết đến Bootstrap JavaScript và jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

