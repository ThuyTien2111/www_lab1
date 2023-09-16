package vn.edu.iuh.fit.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Entity
@Table(name = "grant_access")
public class GrantAccess {
    @Id
    @Column(name = "role_id", nullable = false)
    private String roleId;
    @Id
    @Column(name = "account_id", nullable = false)
    private String accountId;
    @Column(name = "is_grant", nullable = false, columnDefinition = "bit(1) default b'1'")
    private boolean isGrant;
    @Column(name = "note", length = 250, columnDefinition = "varchar(250) default ''")
    private String note;
    // Constructors, getters, and setters here...

    // Constructors
    public GrantAccess() {
    }

    @Override
    public String toString() {
        return "GrantAccess{" +
                "roleId='" + roleId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", isGrant=" + isGrant +
                ", note='" + note + '\'' +
                '}';
    }

    public GrantAccess(String roleId, String accountId, boolean isGrant, String note) {
        this.roleId = roleId;
        this.accountId = accountId;
        this.isGrant = isGrant;
        this.note = note;
    }

    // Getters and setters
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public boolean isGrant() {
        return isGrant;
    }

    public void setGrant(boolean grant) {
        isGrant = grant;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}

