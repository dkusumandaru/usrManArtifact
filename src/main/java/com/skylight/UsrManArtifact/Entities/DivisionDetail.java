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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "division_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DivisionDetail.findAll", query = "SELECT d FROM DivisionDetail d")
    , @NamedQuery(name = "DivisionDetail.findByDivisionDetailId", query = "SELECT d FROM DivisionDetail d WHERE d.divisionDetailId = :divisionDetailId")
    , @NamedQuery(name = "DivisionDetail.findByDivisionDetailName", query = "SELECT d FROM DivisionDetail d WHERE d.divisionDetailName = :divisionDetailName")
    , @NamedQuery(name = "DivisionDetail.findByDivisionDetailLevel", query = "SELECT d FROM DivisionDetail d WHERE d.divisionDetailLevel = :divisionDetailLevel")
    , @NamedQuery(name = "DivisionDetail.findByDivisionDetailActive", query = "SELECT d FROM DivisionDetail d WHERE d.divisionDetailActive = :divisionDetailActive")})
public class DivisionDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "division_detail_id")
    private String divisionDetailId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 225)
    @Column(name = "division_detail_name")
    private String divisionDetailName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "division_detail_level")
    private int divisionDetailLevel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "division_detail_active")
    private String divisionDetailActive;
    @JoinColumn(name = "division_id", referencedColumnName = "division_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Division divisionId;
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Role roleId;

    public DivisionDetail() {
    }

    public DivisionDetail(String divisionDetailId) {
        this.divisionDetailId = divisionDetailId;
    }

    public DivisionDetail(String divisionDetailId, String divisionDetailName, int divisionDetailLevel, String divisionDetailActive) {
        this.divisionDetailId = divisionDetailId;
        this.divisionDetailName = divisionDetailName;
        this.divisionDetailLevel = divisionDetailLevel;
        this.divisionDetailActive = divisionDetailActive;
    }

    public String getDivisionDetailId() {
        return divisionDetailId;
    }

    public void setDivisionDetailId(String divisionDetailId) {
        this.divisionDetailId = divisionDetailId;
    }

    public String getDivisionDetailName() {
        return divisionDetailName;
    }

    public void setDivisionDetailName(String divisionDetailName) {
        this.divisionDetailName = divisionDetailName;
    }

    public int getDivisionDetailLevel() {
        return divisionDetailLevel;
    }

    public void setDivisionDetailLevel(int divisionDetailLevel) {
        this.divisionDetailLevel = divisionDetailLevel;
    }

    public String getDivisionDetailActive() {
        return divisionDetailActive;
    }

    public void setDivisionDetailActive(String divisionDetailActive) {
        this.divisionDetailActive = divisionDetailActive;
    }

    public Division getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Division divisionId) {
        this.divisionId = divisionId;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (divisionDetailId != null ? divisionDetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DivisionDetail)) {
            return false;
        }
        DivisionDetail other = (DivisionDetail) object;
        if ((this.divisionDetailId == null && other.divisionDetailId != null) || (this.divisionDetailId != null && !this.divisionDetailId.equals(other.divisionDetailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.skylight.UsrManArtifact.Entities.DivisionDetail[ divisionDetailId=" + divisionDetailId + " ]";
    }
    
}
