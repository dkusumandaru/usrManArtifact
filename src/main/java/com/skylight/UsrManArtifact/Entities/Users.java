/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skylight.UsrManArtifact.Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dragon
 */
@Entity
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")
    , @NamedQuery(name = "Users.findByUserId", query = "SELECT u FROM Users u WHERE u.userId = :userId")
    , @NamedQuery(name = "Users.findByUserName", query = "SELECT u FROM Users u WHERE u.userName = :userName")
    , @NamedQuery(name = "Users.findByUserFirstName", query = "SELECT u FROM Users u WHERE u.userFirstName = :userFirstName")
    , @NamedQuery(name = "Users.findByUserMiddleName", query = "SELECT u FROM Users u WHERE u.userMiddleName = :userMiddleName")
    , @NamedQuery(name = "Users.findByUserLastName", query = "SELECT u FROM Users u WHERE u.userLastName = :userLastName")
    , @NamedQuery(name = "Users.findByUserGender", query = "SELECT u FROM Users u WHERE u.userGender = :userGender")
    , @NamedQuery(name = "Users.findByUserBirthDay", query = "SELECT u FROM Users u WHERE u.userBirthDay = :userBirthDay")
    , @NamedQuery(name = "Users.findByUserAddress", query = "SELECT u FROM Users u WHERE u.userAddress = :userAddress")
    , @NamedQuery(name = "Users.findByUserPhone", query = "SELECT u FROM Users u WHERE u.userPhone = :userPhone")
    , @NamedQuery(name = "Users.findByUserEmail", query = "SELECT u FROM Users u WHERE u.userEmail = :userEmail")
    , @NamedQuery(name = "Users.findByUserPassword", query = "SELECT u FROM Users u WHERE u.userPassword = :userPassword")
    , @NamedQuery(name = "Users.findByUserCreate", query = "SELECT u FROM Users u WHERE u.userCreate = :userCreate")
    , @NamedQuery(name = "Users.findByUserUpdate", query = "SELECT u FROM Users u WHERE u.userUpdate = :userUpdate")
    , @NamedQuery(name = "Users.findByUserActive", query = "SELECT u FROM Users u WHERE u.userActive = :userActive")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "user_id")
    private String userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "user_name")
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "user_first_name")
    private String userFirstName;
    @Size(max = 255)
    @Column(name = "user_middle_name")
    private String userMiddleName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "user_last_name")
    private String userLastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "user_gender")
    private String userGender;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_birth_day")
    @Temporal(TemporalType.DATE)
    private Date userBirthDay;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "user_address")
    private String userAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "user_phone")
    private String userPhone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "user_email")
    private String userEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "user_password")
    private String userPassword;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_create")
    @Temporal(TemporalType.TIMESTAMP)
    private Date userCreate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date userUpdate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "user_active")
    private String userActive;

    public Users() {
    }

    public Users(String userId) {
        this.userId = userId;
    }

    public Users(String userId, String userName, String userFirstName, String userLastName, String userGender, Date userBirthDay, String userAddress, String userPhone, String userEmail, String userPassword, Date userCreate, Date userUpdate, String userActive) {
        this.userId = userId;
        this.userName = userName;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userGender = userGender;
        this.userBirthDay = userBirthDay;
        this.userAddress = userAddress;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userCreate = userCreate;
        this.userUpdate = userUpdate;
        this.userActive = userActive;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserMiddleName() {
        return userMiddleName;
    }

    public void setUserMiddleName(String userMiddleName) {
        this.userMiddleName = userMiddleName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public Date getUserBirthDay() {
        return userBirthDay;
    }

    public void setUserBirthDay(Date userBirthDay) {
        this.userBirthDay = userBirthDay;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Date getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(Date userCreate) {
        this.userCreate = userCreate;
    }

    public Date getUserUpdate() {
        return userUpdate;
    }

    public void setUserUpdate(Date userUpdate) {
        this.userUpdate = userUpdate;
    }

    public String getUserActive() {
        return userActive;
    }

    public void setUserActive(String userActive) {
        this.userActive = userActive;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.skylight.UsrManArtifact.Entities.Users[ userId=" + userId + " ]";
    }
    
}
