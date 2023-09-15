package vn.edu.iuh.fit.repositories;

import vn.edu.iuh.fit.db.Connect;
import vn.edu.iuh.fit.entities.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountReponsitories {
    public boolean addAccount(Account account) throws SQLException, ClassNotFoundException {
        Connection connection;
        connection = Connect.getInstance().getConnection();
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
    }

}
