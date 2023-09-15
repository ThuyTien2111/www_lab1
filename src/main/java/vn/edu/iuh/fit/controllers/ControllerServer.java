package vn.edu.iuh.fit.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;

@WebServlet(urlPatterns = "/ControllerServer" )
public class ControllerServer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if ("insertLog".equals(action)) {
            // Thêm một bản ghi vào bảng 'log'
            String logData = req.getParameter("logData");
            insertLog(logData);
        } else if ("updateRole".equals(action)) {
            // Cập nhật một bản ghi trong bảng 'role'
            int roleId = Integer.parseInt(req.getParameter("roleId"));
            String roleName = req.getParameter("roleName");
            updateRole(roleId, roleName);
        } else if ("deleteAccount".equals(action)) {
            // Xóa một bản ghi trong bảng 'account'
            int accountId = Integer.parseInt(req.getParameter("accountId"));
            deleteAccount(accountId);
        }

        // Gửi phản hồi về client hoặc chuyển hướng
        resp.getWriter().write("Thao tác thành công!");


    }
    private void insertLog(String logData) {
        try (Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/mydb?createDatabaseIfNotExist=true",
                "root", "sapass")) {
            String sql = "INSERT INTO log (log_data) VALUES (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, logData);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    // Phương thức cập nhật một bản ghi trong bảng 'role'
    private void updateRole(int roleId, String roleName) {
        try (Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/mydb?createDatabaseIfNotExist=true",
                "root", "sapass")) {
            String sql = "UPDATE role SET role_name = ? WHERE role_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, roleName);
            preparedStatement.setInt(2, roleId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void deleteAccount(int accountId) {
        try (Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/mydb?createDatabaseIfNotExist=true",
                "root", "sapass")) {
            String sql = "DELETE FROM account WHERE account_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, accountId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);

    }
}
