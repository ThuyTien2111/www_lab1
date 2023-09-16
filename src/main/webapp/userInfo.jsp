<%--
  Created by IntelliJ IDEA.
  User: my
  Date: 16/09/2023
  Time: 6:45 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thông Tin Người Dùng</title>
    <!-- Thêm liên kết đến Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h1>Thông Tin Người Dùng</h1>
    <!-- Hiển thị thông tin cơ bản của người dùng -->
    <div class="card mb-3">
        <div class="card-header">
            Thông Tin Cơ Bản
        </div>
        <div class="card-body">
            <p><strong>Họ và Tên:</strong> ${user.fullName}</p>
            <p><strong>Email:</strong> ${user.email}</p>
            <p><strong>Tên Người Dùng:</strong> ${user.username}</p>
        </div>
    </div>
    <!-- Hiển thị danh sách quyền của người dùng -->
    <div class="card">
        <div class="card-header">
            Danh Sách Quyền
        </div>
        <div class="card-body">
            <ul>
                <c:forEach var="role" items="${user.roles}">
                    <li>${role.roleName}</li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>
<!-- Thêm liên kết đến Bootstrap JavaScript và jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

