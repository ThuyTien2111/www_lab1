package vn.edu.iuh.fit.repositories;

import vn.edu.iuh.fit.db.Connect;
import vn.edu.iuh.fit.entities.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountReponsitories {
    public boolean addAccount(Account account) throws SQLException, ClassNotFoundException {
        Connection connection;
        connection = Connect.getInstance().getConnection();

        try{
            String sql = "INSERT INTO account VALUES (?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, account.getAccountId());
        preparedStatement.setString(2, account.getFullName());
        preparedStatement.setString(3, account.getPassword());
        preparedStatement.setString(4, account.getEmail());
        preparedStatement.setString(5, account.getPhone());
        preparedStatement.setByte(6, account.getStatus());
        preparedStatement.executeUpdate();

        int rowsAffected = preparedStatement.executeUpdate();
        return rowsAffected > 0;

        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateAccount(Account account) throws SQLException, ClassNotFoundException {
        Connection connection;
        connection = Connect.getInstance().getConnection();
        try{
            String sql = "UPDATE account SET full_name = ?, password = ?, email = ?, phone = ?, status = ? "
                    + "WHERE account_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, account.getFullName());
            preparedStatement.setString(2, account.getPassword());
            preparedStatement.setString(3, account.getEmail());
            preparedStatement.setString(4, account.getPhone());
            preparedStatement.setByte(5, account.getStatus());
            preparedStatement.setString(6, account.getAccountId());
            preparedStatement.executeUpdate();

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        }catch (SQLException e){
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
            preparedStatement.executeUpdate();

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


    }
