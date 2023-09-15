package vn.edu.iuh.fit.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table (name = "account")
public class Account {
  @Id
  @Column(name = "account_id", nullable = false)
  private String accountId;
  @Column(name = "full_name", nullable = false)
  private String fullName;
  @Column(name = "password", nullable = false)
  private String password;
  @Column(name = "email")
  private String email;
  @Column(name = "phone")
  private String phone;
  @Column(name = "status", nullable = false, columnDefinition = "tinyint(4) default 1")
  private byte status;
  // Constructors, getters, and setters here...

  // Constructors
  public Account() {
  }

  public Account(String accountId, String fullName, String password, String email, String phone, byte status) {
    this.accountId = accountId;
    this.fullName = fullName;
    this.password = password;
    this.email = email;
    this.phone = phone;
    this.status = status;
  }

  // Getters and setters
  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public byte getStatus() {
    return status;
  }

  public void setStatus(byte status) {
    this.status = status;
  }
}

