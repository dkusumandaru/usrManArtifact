/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skylight.UsrManArtifact.Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dragon
 */
@Entity
@Table(name = "user_division_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserDivisionDetail.findAll", query = "SELECT u FROM UserDivisionDetail u")
    , @NamedQuery(name = "UserDivisionDetail.findByUserDivisionDetailId", query = "SELECT u FROM UserDivisionDetail u WHERE u.userDivisionDetailId = :userDivisionDetailId")
    , @NamedQuery(name = "UserDivisionDetail.findByDivisionDetailId", query = "SELECT u FROM UserDivisionDetail u WHERE u.divisionDetailId = :divisionDetailId")
    , @NamedQuery(name = "UserDivisionDetail.findByUserId", query = "SELECT u FROM UserDivisionDetail u WHERE u.userId = :userId")})
public class UserDivisionDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "user_division_detail_id")
    private String userDivisionDetailId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "division_detail_id")
    private String divisionDetailId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "user_id")
    private String userId;

    public UserDivisionDetail() {
    }

    public UserDivisionDetail(String userDivisionDetailId) {
        this.userDivisionDetailId = userDivisionDetailId;
    }

    public UserDivisionDetail(String userDivisionDetailId, String divisionDetailId, String userId) {
        this.userDivisionDetailId = userDivisionDetailId;
        this.divisionDetailId = divisionDetailId;
        this.userId = userId;
    }

    public String getUserDivisionDetailId() {
        return userDivisionDetailId;
    }

    public void setUserDivisionDetailId(String userDivisionDetailId) {
        this.userDivisionDetailId = userDivisionDetailId;
    }

    public String getDivisionDetailId() {
        return divisionDetailId;
    }

    public void setDivisionDetailId(String divisionDetailId) {
        this.divisionDetailId = divisionDetailId;
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
        hash += (userDivisionDetailId != null ? userDivisionDetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserDivisionDetail)) {
            return false;
        }
        UserDivisionDetail other = (UserDivisionDetail) object;
        if ((this.userDivisionDetailId == null && other.userDivisionDetailId != null) || (this.userDivisionDetailId != null && !this.userDivisionDetailId.equals(other.userDivisionDetailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.skylight.UsrManArtifact.Entities.UserDivisionDetail[ userDivisionDetailId=" + userDivisionDetailId + " ]";
    }
    
}
