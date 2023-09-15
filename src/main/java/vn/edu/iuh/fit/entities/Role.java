package vn.edu.iuh.fit.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "role")
public class Role {
    @Id
    @Column(name = "role_id", nullable = false)
    private String roleId;
    @Column(name = "role_name", nullable = false)
    private String roleName;
    @Column(name = "description")
    private String description;
    @Column(name = "status", nullable = false)
    private byte status;
    // Constructors, getters, and setters here...

    // Constructors
    public Role() {
    }

    public Role(String roleId, String roleName, String description, byte status) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.description = description;
        this.status = status;
    }

    // Getters and setters
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }
}
