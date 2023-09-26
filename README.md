# Servlet Project WEEK 1 README

## Giới thiệu

Dự án Servlet này là một phần của ứng dụng quản lý tài khoản và quyền truy cập. Nó bao gồm nhiều package và thành phần quan trọng để quản lý tài khoản, quyền truy cập và sự kiện ghi log trong ứng dụng. Dưới đây là một tóm tắt về các package và thành phần chính trong dự án:

### Packages

1. **Entities**: Package này chứa các đối tượng cơ bản của dự án như Account, GrantAccess, Log và Role.

2. **DB**: Package này bao gồm lớp Connect, dùng để kết nối đến cơ sở dữ liệu.

3. **Repositories**: Các package con sau đây chứa các lớp Repository để thực hiện các thao tác truy vấn và cập nhật dữ liệu trong cơ sở dữ liệu:
   - **AccountRepositories**: Chứa các hàm để thêm, cập nhật, xóa tài khoản, tìm tài khoản theo ID, tìm tất cả các tài khoản, đăng nhập, đăng xuất và lấy danh sách tài khoản theo quyền.
   - **GrantAccessRepositories**: Chứa hàm để thêm quyền truy cập.
   - **LogRepositories**: Chứa hàm ghi log sự kiện.
   - **RoleRepositories**: Chứa hàm để lấy danh sách quyền cho tài khoản.

4. **Service**: Package này chứa lớp AccountService, có nhiệm vụ xử lý logic liên quan đến tài khoản.

5. **Controllers**: Chứa các Servlets, trong đó có LoginServlet để xử lý yêu cầu đăng nhập.

6. **Demo**: Chứa một tệp demo để kiểm tra và thử nghiệm các lớp Repository.

## Hướng dẫn cài đặt và chạy

Dự án này được xây dựng bằng Java Servlets và sử dụng cơ sở dữ liệu để lưu trữ thông tin tài khoản, quyền truy cập và log. Để cài đặt và chạy dự án, bạn cần thực hiện các bước sau:

1. **Cài đặt môi trường**: Đảm bảo rằng bạn đã cài đặt Java Development Kit (JDK) và một máy chủ servlet như Apache Tomcat.

2. **Tạo cơ sở dữ liệu**: Thiết lập cơ sở dữ liệu MySQL (Bằng HeidiSQL hoặc MSSQL) và chỉnh sửa cấu hình kết nối trong lớp Connect trong package DB.

3. **Import dự án**: Import dự án vào môi trường phát triển của bạn (Eclipse, IntelliJ, NetBeans, vv.).

4. **Cấu hình máy chủ servlet**: Thêm dự án vào máy chủ servlet của bạn (ví dụ: Apache Tomcat).

5. **Chạy ứng dụng**: Khởi động máy chủ servlet và truy cập ứng dụng qua trình duyệt web bằng địa chỉ URL tương ứng (ví dụ: http://localhost:8080/lab1/).

6. **Thử nghiệm Demo**: Thực hiện các thao tác kiểm tra bằng cách sử dụng tệp demo.

## Thư viện và công nghệ sử dụng

Dự án này sử dụng các công nghệ và thư viện sau:
- Java Servlets
- Cơ sở dữ liệu MySQL 
- [Servlet API](https://javaee.github.io/servlet-spec/)
- [JDBC](https://docs.oracle.com/en/java/javase/11/docs/api/java.sql/java/sql/package-summary.html)

## Đóng góp

Nếu bạn muốn đóng góp vào dự án hoặc báo cáo lỗi, vui lòng tạo issue hoặc gửi pull request vào [repository GitHub của dự án](https://github.com/ThuyTien2111/www_lab1.git).

## Tác giả

Dự án này được phát triển bởi [Thuy Tien] 

Cảm ơn bạn đã sử dụng dự án của tôi!
