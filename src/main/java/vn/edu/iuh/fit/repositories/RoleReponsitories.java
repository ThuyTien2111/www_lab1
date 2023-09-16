package vn.edu.iuh.fit.repositories;

import vn.edu.iuh.fit.db.Connect;
import vn.edu.iuh.fit.entities.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleReponsitories {
    public List<Role> getRolesForAccount(String accountId) throws SQLException, ClassNotFoundException {
        Connection connection;
        connection = Connect.getInstance().getConnection();
        List<Role> roles = new ArrayList<>();
        try {
            String sql = "SELECT role.* FROM role \n" +
                    "INNER JOIN grant_access ON role.role_id = grant_access.role_id\n" +
                    "WHERE grant_access.account_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, accountId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Role role = new Role();
                role.setRoleId(resultSet.getString("role_id"));
                role.setRoleName(resultSet.getString("role_name"));
                role.setDescription(resultSet.getString("description"));
                role.setStatus(resultSet.getByte("status"));
                roles.add(role);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return roles;
    }
}
