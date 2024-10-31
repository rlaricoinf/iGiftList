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
import jakarta.persistence.Lob;
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
@Table(name = "giftlist")
@NamedQueries({
    @NamedQuery(name = "Giftlist.findAll", query = "SELECT g FROM Giftlist g"),
    @NamedQuery(name = "Giftlist.findByIdGiftlistPk", query = "SELECT g FROM Giftlist g WHERE g.idGiftlistPk = :idGiftlistPk"),
    @NamedQuery(name = "Giftlist.findByName", query = "SELECT g FROM Giftlist g WHERE g.name = :name"),
    @NamedQuery(name = "Giftlist.findByDescription", query = "SELECT g FROM Giftlist g WHERE g.description = :description"),
    @NamedQuery(name = "Giftlist.findByStateGift", query = "SELECT g FROM Giftlist g WHERE g.stateGift = :stateGift"),
    @NamedQuery(name = "Giftlist.findByRegisterDate", query = "SELECT g FROM Giftlist g WHERE g.registerDate = :registerDate"),
    @NamedQuery(name = "Giftlist.findByRegisterIp", query = "SELECT g FROM Giftlist g WHERE g.registerIp = :registerIp"),
    @NamedQuery(name = "Giftlist.findByRegisterUser", query = "SELECT g FROM Giftlist g WHERE g.registerUser = :registerUser"),
    @NamedQuery(name = "Giftlist.findByLastModifyDate", query = "SELECT g FROM Giftlist g WHERE g.lastModifyDate = :lastModifyDate"),
    @NamedQuery(name = "Giftlist.findByLastModifyIp", query = "SELECT g FROM Giftlist g WHERE g.lastModifyIp = :lastModifyIp"),
    @NamedQuery(name = "Giftlist.findByLastModifyUser", query = "SELECT g FROM Giftlist g WHERE g.lastModifyUser = :lastModifyUser")})
public class Giftlist implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_giftlist")
    @SequenceGenerator(name = "seq_giftlist", sequenceName = "seq_giftlist", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "id_giftlist_pk")
    private Integer idGiftlistPk;
    @Lob
    @Column(name = "gift_image")
    private byte[] giftImage;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "state_gift")
    private Integer stateGift;
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
    @Size(max = 2147483647)
    @Column(name = "last_modify_ip")
    private String lastModifyIp;
    @Size(max = 2147483647)
    @Column(name = "last_modify_user")
    private String lastModifyUser;
    @OneToMany(mappedBy = "idGiftlistFk", fetch = FetchType.LAZY)
    private List<GiftlistGuest> giftlistGuestList;

    public Giftlist() {
    }

    public Giftlist(Integer idGiftlistPk) {
        this.idGiftlistPk = idGiftlistPk;
    }

    public Integer getIdGiftlistPk() {
        return idGiftlistPk;
    }

    public void setIdGiftlistPk(Integer idGiftlistPk) {
        this.idGiftlistPk = idGiftlistPk;
    }

    public byte[] getGiftImage() {
        return giftImage;
    }

    public void setGiftImage(byte[] giftImage) {
        this.giftImage = giftImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStateGift() {
        return stateGift;
    }

    public void setStateGift(Integer stateGift) {
        this.stateGift = stateGift;
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
        hash += (idGiftlistPk != null ? idGiftlistPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Giftlist)) {
            return false;
        }
        Giftlist other = (Giftlist) object;
        if ((this.idGiftlistPk == null && other.idGiftlistPk != null) || (this.idGiftlistPk != null && !this.idGiftlistPk.equals(other.idGiftlistPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ryy.giftlist.model.entities.Giftlist[ idGiftlistPk=" + idGiftlistPk + " ]";
    }
    
}
