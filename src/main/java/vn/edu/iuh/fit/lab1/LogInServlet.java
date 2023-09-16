package vn.edu.iuh.fit.lab1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "login" , value = "/login")
public class LogInServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy dữ liệu từ form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Thực hiện xác thực người dùng ở đây (ví dụ: so sánh với cơ sở dữ liệu)
        boolean isAuthenticated = authenticate(username, password);

        if (isAuthenticated) {
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

    // Hàm xác thực người dùng (được giả định)
    private boolean authenticate(String username, String password) {
        // Thực hiện xác thực người dùng ở đây (ví dụ: so sánh với cơ sở dữ liệu)
        // Trong ví dụ này, bạn có thể tạo một hàm xác thực đơn giản và trả về true nếu tên người dùng và mật khẩu hợp lệ.
        // Trong thực tế, bạn nên thay thế hàm này bằng xác thực thực tế (ví dụ: sử dụng cơ sở dữ liệu).
        return "tien".equals(username) && "123".equals(password);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
