package vn.edu.iuh.fit;

import vn.edu.iuh.fit.entities.Account;
import vn.edu.iuh.fit.entities.GrantAccess;
import vn.edu.iuh.fit.repositories.AccountReponsitories;
import vn.edu.iuh.fit.repositories.GrantAccessReponsitories;
import vn.edu.iuh.fit.repositories.LogResponsitories;
import vn.edu.iuh.fit.repositories.RoleReponsitories;

import java.sql.SQLException;

public class demo {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        AccountReponsitories controlAcc=new AccountReponsitories();
        RoleReponsitories controlRole= new RoleReponsitories();
        GrantAccessReponsitories controlGrant= new GrantAccessReponsitories();
        LogResponsitories controlLog= new LogResponsitories();
//        System.out.println(controlAcc.findAccountById("met").toString());
//       System.out.println(controlAcc.addAccount(new Account("phuong", "Nguyen Bich Phuong", "12345", "phuong@gmail.com", "098283829", (byte)1)));
//        System.out.println(controlAcc.updateAccount(new Account("tien", "Thuy Tien", "12345", "vanbac21112k2@gmail.com", "0388495421", (byte)1)));
//        System.out.println(controlAcc.deleteAccount("tien"));
//        System.out.println(controlAcc.login("tien", "12345"));
//        controlAcc.findAll().forEach(account -> System.out.println(account.toString()));
//        controlRole.getRolesForAccount("met").forEach(role -> System.out.println(role.toString()));
//        controlAcc.getAccountsForRoles("admin").forEach(role -> System.out.println(role.toString()));
//        System.out.println(controlGrant.addGrantAccess(new GrantAccess("user", "phuong", true, "")));
        controlAcc.logLogout("tien");

    }
}
