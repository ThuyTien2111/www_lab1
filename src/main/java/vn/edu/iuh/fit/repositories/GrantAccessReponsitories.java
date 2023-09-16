package vn.edu.iuh.fit.repositories;

import vn.edu.iuh.fit.db.Connect;
import vn.edu.iuh.fit.entities.Account;
import vn.edu.iuh.fit.entities.GrantAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GrantAccessReponsitories {
    public boolean addGrantAccess(GrantAccess grantAccess) throws SQLException, ClassNotFoundException {
        Connection connection;
        connection = Connect.getInstance().getConnection();

        try {
            String sql = "INSERT INTO grant_access (role_id, account_id, is_grant, note) " +
                    "VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, grantAccess.getRoleId());
            preparedStatement.setString(2, grantAccess.getAccountId());
            preparedStatement.setBoolean(3, grantAccess.isGrant());
            preparedStatement.setString(4, grantAccess.getNote());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;

        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
