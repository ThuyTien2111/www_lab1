package vn.edu.iuh.fit.repositories;

import vn.edu.iuh.fit.db.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LogResponsitories {
    public void logAction(String accountId, String action) throws SQLException, ClassNotFoundException {
        Connection connection;
        connection = Connect.getInstance().getConnection();
        try {
            String sql = "INSERT INTO log (account_id, login_time, logout_time, notes) VALUES (?, current_timestamp(), current_timestamp(), ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, accountId);
            preparedStatement.setString(2, action);
            preparedStatement.executeUpdate();

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
