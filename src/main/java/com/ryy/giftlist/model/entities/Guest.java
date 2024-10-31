/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ryy.giftlist.model.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author dnrol
 */
@Entity
@Table(name = "guest")
@NamedQueries({
    @NamedQuery(name = "Guest.findAll", query = "SELECT g FROM Guest g"),
    @NamedQuery(name = "Guest.findByIdGuestPk", query = "SELECT g FROM Guest g WHERE g.idGuestPk = :idGuestPk"),
    @NamedQuery(name = "Guest.findByIdGuestCatFk", query = "SELECT g FROM Guest g WHERE g.idGuestCatFk = :idGuestCatFk"),
    @NamedQuery(name = "Guest.findByGuestCode", query = "SELECT g FROM Guest g WHERE g.guestCode = :guestCode"),
    @NamedQuery(name = "Guest.findByFullname", query = "SELECT g FROM Guest g WHERE g.fullname = :fullname"),
    @NamedQuery(name = "Guest.findByStateGuest", query = "SELECT g FROM Guest g WHERE g.stateGuest = :stateGuest"),
    @NamedQuery(name = "Guest.findByNumberOfCompanions", query = "SELECT g FROM Guest g WHERE g.numberOfCompanions = :numberOfCompanions"),
    @NamedQuery(name = "Guest.findByObservations", query = "SELECT g FROM Guest g WHERE g.observations = :observations"),
    @NamedQuery(name = "Guest.findByRegisterDate", query = "SELECT g FROM Guest g WHERE g.registerDate = :registerDate"),
    @NamedQuery(name = "Guest.findByRegisterIp", query = "SELECT g FROM Guest g WHERE g.registerIp = :registerIp"),
    @NamedQuery(name = "Guest.findByRegisterUser", query = "SELECT g FROM Guest g WHERE g.registerUser = :registerUser"),
    @NamedQuery(name = "Guest.findByLastModifyDate", query = "SELECT g FROM Guest g WHERE g.lastModifyDate = :lastModifyDate"),
    @NamedQuery(name = "Guest.findByLastModifyIp", query = "SELECT g FROM Guest g WHERE g.lastModifyIp = :lastModifyIp"),
    @NamedQuery(name = "Guest.findByLastModifyUser", query = "SELECT g FROM Guest g WHERE g.lastModifyUser = :lastModifyUser")})
public class Guest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_guest")
    @SequenceGenerator(name = "seq_guest", sequenceName = "seq_guest", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "id_guest_pk")
    private Integer idGuestPk;
    @Column(name = "id_guest_cat_fk")
    private Integer idGuestCatFk;
    @Column(name = "guest_code")
    private Integer guestCode;
    @Column(name = "fullname")
    private String fullname;
    @Column(name = "state_guest")
    private Integer stateGuest;
    @Column(name = "number_of_companions")
    private Integer numberOfCompanions;
    @Column(name = "observations")
    private String observations;
    @Column(name = "register_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registerDate;
    @Column(name = "register_ip")
    private String registerIp;
    @Column(name = "register_user")
    private String registerUser;
    @Column(name = "last_modify_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifyDate;
    @Column(name = "last_modify_ip")
    private String lastModifyIp;
    @Column(name = "last_modify_user")
    private String lastModifyUser;
    @OneToMany(mappedBy = "idGuestFk", fetch = FetchType.LAZY)
    private List<GiftlistGuest> giftlistGuestList;

    public Guest() {
    }

    public Guest(Integer idGuestPk) {
        this.idGuestPk = idGuestPk;
    }

    public Integer getIdGuestPk() {
        return idGuestPk;
    }

    public void setIdGuestPk(Integer idGuestPk) {
        this.idGuestPk = idGuestPk;
    }

    public Integer getIdGuestCatFk() {
        return idGuestCatFk;
    }

    public void setIdGuestCatFk(Integer idGuestCatFk) {
        this.idGuestCatFk = idGuestCatFk;
    }

    public Integer getGuestCode() {
        return guestCode;
    }

    public void setGuestCode(Integer guestCode) {
        this.guestCode = guestCode;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Integer getStateGuest() {
        return stateGuest;
    }

    public void setStateGuest(Integer stateGuest) {
        this.stateGuest = stateGuest;
    }

    public Integer getNumberOfCompanions() {
        return numberOfCompanions;
    }

    public void setNumberOfCompanions(Integer numberOfCompanions) {
        this.numberOfCompanions = numberOfCompanions;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getRegisterIp() {
        return registerIp;
    }

    public void setRegisterIp(String registerIp) {
        this.registerIp = registerIp;
    }

    public String getRegisterUser() {
        return registerUser;
    }

    public void setRegisterUser(String registerUser) {
        this.registerUser = registerUser;
    }

    public Date getLastModifyDate() {
        return lastModifyDate;
    }

    public void setLastModifyDate(Date lastModifyDate) {
        this.lastModifyDate = lastModifyDate;
    }

    public String getLastModifyIp() {
        return lastModifyIp;
    }

    public void setLastModifyIp(String lastModifyIp) {
        this.lastModifyIp = lastModifyIp;
    }

    public String getLastModifyUser() {
        return lastModifyUser;
    }

    public void setLastModifyUser(String lastModifyUser) {
        this.lastModifyUser = lastModifyUser;
    }

    public List<GiftlistGuest> getGiftlistGuestList() {
        return giftlistGuestList;
    }

    public void setGiftlistGuestList(List<GiftlistGuest> giftlistGuestList) {
        this.giftlistGuestList = giftlistGuestList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGuestPk != null ? idGuestPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Guest)) {
            return false;
        }
        Guest other = (Guest) object;
        if ((this.idGuestPk == null && other.idGuestPk != null) || (this.idGuestPk != null && !this.idGuestPk.equals(other.idGuestPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ryy.giftlist.model.entities.Guest[ idGuestPk=" + idGuestPk + " ]";
    }
    
}
