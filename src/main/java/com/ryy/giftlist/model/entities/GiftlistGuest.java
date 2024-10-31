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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author dnrol
 */
@Entity
@Table(name = "giftlist_guest")
@NamedQueries({
    @NamedQuery(name = "GiftlistGuest.findAll", query = "SELECT g FROM GiftlistGuest g"),
    @NamedQuery(name = "GiftlistGuest.findByIdGiftlistGuestPk", query = "SELECT g FROM GiftlistGuest g WHERE g.idGiftlistGuestPk = :idGiftlistGuestPk"),
    @NamedQuery(name = "GiftlistGuest.findByStateGiftlistGuest", query = "SELECT g FROM GiftlistGuest g WHERE g.stateGiftlistGuest = :stateGiftlistGuest"),
    @NamedQuery(name = "GiftlistGuest.findByRegisterDate", query = "SELECT g FROM GiftlistGuest g WHERE g.registerDate = :registerDate"),
    @NamedQuery(name = "GiftlistGuest.findByRegisterIp", query = "SELECT g FROM GiftlistGuest g WHERE g.registerIp = :registerIp"),
    @NamedQuery(name = "GiftlistGuest.findByRegisterUser", query = "SELECT g FROM GiftlistGuest g WHERE g.registerUser = :registerUser"),
    @NamedQuery(name = "GiftlistGuest.findByLastModifyDate", query = "SELECT g FROM GiftlistGuest g WHERE g.lastModifyDate = :lastModifyDate"),
    @NamedQuery(name = "GiftlistGuest.findByLastModifyIp", query = "SELECT g FROM GiftlistGuest g WHERE g.lastModifyIp = :lastModifyIp"),
    @NamedQuery(name = "GiftlistGuest.findByLastModifyUser", query = "SELECT g FROM GiftlistGuest g WHERE g.lastModifyUser = :lastModifyUser")})
public class GiftlistGuest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_giftlist_guest")
    @SequenceGenerator(name = "seq_giftlist_guest", sequenceName = "seq_giftlist_guest", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "id_giftlist_guest_pk")
    private Integer idGiftlistGuestPk;
    @Column(name = "state_giftlist_guest")
    private Integer stateGiftlistGuest;
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
    @JoinColumn(name = "id_giftlist_fk", referencedColumnName = "id_giftlist_pk")
    @ManyToOne(fetch = FetchType.LAZY)
    private Giftlist idGiftlistFk;
    @JoinColumn(name = "id_guest_fk", referencedColumnName = "id_guest_pk")
    @ManyToOne(fetch = FetchType.LAZY)
    private Guest idGuestFk;

    public GiftlistGuest() {
    }

    public GiftlistGuest(Integer idGiftlistGuestPk) {
        this.idGiftlistGuestPk = idGiftlistGuestPk;
    }

    public Integer getIdGiftlistGuestPk() {
        return idGiftlistGuestPk;
    }

    public void setIdGiftlistGuestPk(Integer idGiftlistGuestPk) {
        this.idGiftlistGuestPk = idGiftlistGuestPk;
    }

    public Integer getStateGiftlistGuest() {
        return stateGiftlistGuest;
    }

    public void setStateGiftlistGuest(Integer stateGiftlistGuest) {
        this.stateGiftlistGuest = stateGiftlistGuest;
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

    public Giftlist getIdGiftlistFk() {
        return idGiftlistFk;
    }

    public void setIdGiftlistFk(Giftlist idGiftlistFk) {
        this.idGiftlistFk = idGiftlistFk;
    }

    public Guest getIdGuestFk() {
        return idGuestFk;
    }

    public void setIdGuestFk(Guest idGuestFk) {
        this.idGuestFk = idGuestFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGiftlistGuestPk != null ? idGiftlistGuestPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GiftlistGuest)) {
            return false;
        }
        GiftlistGuest other = (GiftlistGuest) object;
        if ((this.idGiftlistGuestPk == null && other.idGiftlistGuestPk != null) || (this.idGiftlistGuestPk != null && !this.idGiftlistGuestPk.equals(other.idGiftlistGuestPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ryy.giftlist.model.entities.GiftlistGuest[ idGiftlistGuestPk=" + idGiftlistGuestPk + " ]";
    }
    
}
