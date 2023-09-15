package vn.edu.iuh.fit;

import vn.edu.iuh.fit.entities.Account;
import vn.edu.iuh.fit.repositories.AccountReponsitories;

import java.sql.SQLException;

public class demo {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        AccountReponsitories accountReponsitories=new AccountReponsitories();
        System.out.println(accountReponsitories.findAccountById("met").toString());
    }
}
