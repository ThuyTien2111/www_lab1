package vn.edu.iuh.fit.repositories;

import vn.edu.iuh.fit.db.Connect;
import vn.edu.iuh.fit.entities.Account;
import vn.edu.iuh.fit.entities.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountReponsitories {
    public boolean addAccount(Account account) throws SQLException, ClassNotFoundException {
        Connection connection;
        connection = Connect.getInstance().getConnection();

        try {
            String sql = "INSERT INTO account VALUES (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, account.getAccountId());
            preparedStatement.setString(2, account.getFullName());
            preparedStatement.setString(3, account.getPassword());
            preparedStatement.setString(4, account.getEmail());
            preparedStatement.setString(5, account.getPhone());
            preparedStatement.setByte(6, account.getStatus());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateAccount(Account account) throws SQLException, ClassNotFoundException {
        Connection connection;
        connection = Connect.getInstance().getConnection();
        try {
            String sql = "UPDATE account SET full_name = ?, password = ?, email = ?, phone = ?, status = ? "
                    + "WHERE account_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, account.getFullName());
            preparedStatement.setString(2, account.getPassword());
            preparedStatement.setString(3, account.getEmail());
            preparedStatement.setString(4, account.getPhone());
            preparedStatement.setByte(5, account.getStatus());
            preparedStatement.setString(6, account.getAccountId());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean deleteAccount(String accountId) throws SQLException, ClassNotFoundException {
        Connection connection;
        connection = Connect.getInstance().getConnection();
        try {
            String sql = "DELETE FROM account WHERE account_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, accountId);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Account findAccountById(String accountId) throws SQLException, ClassNotFoundException {
        Connection connection;
        connection = Connect.getInstance().getConnection();
        Account account = new Account();
        String sql = "SELECT * FROM account WHERE account_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, accountId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            // Tạo một đối tượng Account từ kết quả truy vấn
            account.setAccountId(resultSet.getString("account_id"));
            account.setFullName(resultSet.getString("full_name"));
            account.setPassword(resultSet.getString("password"));
            account.setEmail(resultSet.getString("email"));
            account.setPhone(resultSet.getString("phone"));
            account.setStatus(resultSet.getByte("status"));
        }
        return account;

    }

    public int login(String accountId, String password) throws SQLException, ClassNotFoundException {
        Connection connection;
        connection = Connect.getInstance().getConnection();
        LogResponsitories logResponsitories= new LogResponsitories();
        try {
            String sql = "SELECT account_id, password FROM account WHERE account_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, accountId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String dbPassword = resultSet.getString("password");
                if (dbPassword.equals(password)) {
                    logResponsitories.logAction(accountId, "Log In");
                    // Mật khẩu khớp, đăng nhập thành công
                    return 1;
                } else {
                    // Mật khẩu không khớp
                    return 2;
                }
            } else {
                // Tài khoản không tồn tại
                return 3;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1; // Xảy ra lỗi trong quá trình kiểm tra đăng nhập
        }


    }
    public void logLogout(String accountId) throws SQLException, ClassNotFoundException {
        LogResponsitories logResponsitories= new LogResponsitories();
        logResponsitories.logAction(accountId, "Logout");
    }
    public List<Account> findAll() throws SQLException, ClassNotFoundException {
        Connection connection;
        connection = Connect.getInstance().getConnection();
        List<Account> accountList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM account";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Account account = new Account();
                account.setAccountId(resultSet.getString("account_id"));
                account.setFullName(resultSet.getString("full_name"));
                account.setPassword(resultSet.getString("password"));
                account.setEmail(resultSet.getString("email"));
                account.setPhone(resultSet.getString("phone"));
                account.setStatus(resultSet.getByte("status"));
                accountList.add(account);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return accountList;


    }


    public List<Account> getAccountsForRoles(String roleId) throws SQLException, ClassNotFoundException {
        Connection connection;
        connection = Connect.getInstance().getConnection();
        List<Account> accounts = new ArrayList<>();
        try {
            String sql = "SELECT account.* FROM account \n" +
                    "INNER JOIN grant_access ON account.account_id = grant_access.account_id\n" +
                    "WHERE grant_access.role_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, roleId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Account account = new Account();
                account.setAccountId(resultSet.getString("account_id"));
                account.setFullName(resultSet.getString("full_name"));
                account.setPassword(resultSet.getString("password"));
                account.setEmail(resultSet.getString("email"));
                account.setPhone(resultSet.getString("phone"));
                account.setStatus(resultSet.getByte("status"));
                accounts.add(account);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return accounts;
    }


    }
