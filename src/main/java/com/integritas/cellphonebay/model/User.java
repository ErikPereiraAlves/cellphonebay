package com.integritas.cellphonebay.model;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;


@Entity
@Table(name="User")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long userId;

    @Column (name = "user_name")
    private String userName;

    @Column (name = "user_logon")
    private String userLogon;

    @Column (name = "user_password")
    private String userPassword;

    @Column (name="created")
    private java.sql.Date created;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLogon() {
        return userLogon;
    }

    public void setUserLogon(String userLogon) {
        this.userLogon = userLogon;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
