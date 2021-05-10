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
@Table(name = "user_auth")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserAuth.findAll", query = "SELECT u FROM UserAuth u")
    , @NamedQuery(name = "UserAuth.findByAuthId", query = "SELECT u FROM UserAuth u WHERE u.authId = :authId")
    , @NamedQuery(name = "UserAuth.findByAuthKey", query = "SELECT u FROM UserAuth u WHERE u.authKey = :authKey")
    , @NamedQuery(name = "UserAuth.findByAuthExpr", query = "SELECT u FROM UserAuth u WHERE u.authExpr = :authExpr")
    , @NamedQuery(name = "UserAuth.findByAuthUpdate", query = "SELECT u FROM UserAuth u WHERE u.authUpdate = :authUpdate")
    , @NamedQuery(name = "UserAuth.findByUserId", query = "SELECT u FROM UserAuth u WHERE u.userId = :userId")})
public class UserAuth implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "auth_id")
    private String authId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "auth_key")
    private String authKey;
    @Basic(optional = false)
    @NotNull
    @Column(name = "auth_expr")
    @Temporal(TemporalType.TIMESTAMP)
    private Date authExpr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "auth_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date authUpdate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "user_id")
    private String userId;

    public UserAuth() {
    }

    public UserAuth(String authId) {
        this.authId = authId;
    }

    public UserAuth(String authId, String authKey, Date authExpr, Date authUpdate, String userId) {
        this.authId = authId;
        this.authKey = authKey;
        this.authExpr = authExpr;
        this.authUpdate = authUpdate;
        this.userId = userId;
    }

    public String getAuthId() {
        return authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
    }

    public String getAuthKey() {
        return authKey;
    }

    public void setAuthKey(String authKey) {
        this.authKey = authKey;
    }

    public Date getAuthExpr() {
        return authExpr;
    }

    public void setAuthExpr(Date authExpr) {
        this.authExpr = authExpr;
    }

    public Date getAuthUpdate() {
        return authUpdate;
    }

    public void setAuthUpdate(Date authUpdate) {
        this.authUpdate = authUpdate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (authId != null ? authId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserAuth)) {
            return false;
        }
        UserAuth other = (UserAuth) object;
        if ((this.authId == null && other.authId != null) || (this.authId != null && !this.authId.equals(other.authId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.skylight.UsrManArtifact.Entities.UserAuth[ authId=" + authId + " ]";
    }
    
}
