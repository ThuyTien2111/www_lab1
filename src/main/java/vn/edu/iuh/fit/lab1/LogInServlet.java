package vn.edu.iuh.fit.lab1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.repositories.AccountReponsitories;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "login" , value = "/login")
public class LogInServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy dữ liệu từ form
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        AccountReponsitories controlAcc=new AccountReponsitories();
        // Thực hiện xác thực người dùng ở đây (ví dụ: so sánh với cơ sở dữ liệu)
        int isAuthenticated = 0;
        try {
            isAuthenticated = controlAcc.login(username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        if (isAuthenticated==1) {
            // Người dùng đã đăng nhập thành công, bạn có thể thực hiện các hành động cần thiết ở đây.
            // Ví dụ: chuyển hướng đến trang chính hoặc lưu thông tin đăng nhập vào session.

            // Chuyển hướng đến trang chính sau khi đăng nhập thành công
            response.sendRedirect("dashboard.jsp");
        } else {
            // Đăng nhập không thành công, bạn có thể hiển thị thông báo lỗi hoặc chuyển hướng đến trang đăng nhập lại.
            // Ví dụ: hiển thị thông báo lỗi
            request.setAttribute("errorMessage", "Đăng nhập không thành công. Vui lòng kiểm tra tên người dùng và mật khẩu.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
