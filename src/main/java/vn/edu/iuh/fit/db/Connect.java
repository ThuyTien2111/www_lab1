package vn.edu.iuh.fit.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    private Connection connection;
    private static Connect instance = null;

    public Connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.mariadb.jdbc.Driver");
        String url = "jdbc:mariadb://localhost:3306/mydb?createDatabaseIfNotExist=true";
        connection = DriverManager.getConnection(url, "root", "sapass");
    }

    public Connection getConnection() {
        return connection;
    }

    public static Connect getInstance() throws SQLException, ClassNotFoundException {
        if(instance==null)
            instance = new Connect();
        return instance;
    }
}
