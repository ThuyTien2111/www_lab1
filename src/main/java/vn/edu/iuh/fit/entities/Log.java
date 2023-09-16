package vn.edu.iuh.fit.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "log")
public class Log {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "account_id", nullable = false)
    private String accountId;
    @Column(name = "login_time", nullable = false, columnDefinition = "datetime default current_timestamp()")
    private LocalDate loginTime;
    @Column(name = "logout_time", nullable = false, columnDefinition = "datetime default current_timestamp()")
    private LocalDate logoutTime;
    @Column(name = "notes", length = 250, nullable = false, columnDefinition = "varchar(250) default ''")
    private String notes;

    // Constructors, getters, and setters here...

    // Constructors

    public Log() {
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", accountId='" + accountId + '\'' +
                ", loginTime=" + loginTime +
                ", logoutTime=" + logoutTime +
                ", notes='" + notes + '\'' +
                '}';
    }

    public Log(Long id, String accountId, LocalDate loginTime, LocalDate logoutTime, String notes) {
        this.id = id;
        this.accountId = accountId;
        this.loginTime = loginTime;
        this.logoutTime = logoutTime;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public LocalDate getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDate loginTime) {
        this.loginTime = loginTime;
    }

    public LocalDate getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(LocalDate logoutTime) {
        this.logoutTime = logoutTime;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}

