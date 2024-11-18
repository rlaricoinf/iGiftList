/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ryy.giftlist.model.dto;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 *
 * @author dnrol
 */
public class GiftlistGuestDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idGiftlistGuestPk;
    private Integer stateGiftlistGuest;
    @Temporal(TemporalType.TIMESTAMP)
    private Date registerDate;
    private String registerIp;
    private String registerUser;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifyDate;
    private String lastModifyIp;
    private String lastModifyUser;
    private GiftlistDTO idGiftlistFk;
    private GuestDTO idGuestFk;

    public GiftlistGuestDTO() {
    }

    public GiftlistGuestDTO(Integer idGiftlistGuestPk) {
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

    public GiftlistDTO getIdGiftlistFk() {
        return idGiftlistFk;
    }

    public void setIdGiftlistFk(GiftlistDTO idGiftlistFk) {
        this.idGiftlistFk = idGiftlistFk;
    }

    public GuestDTO getIdGuestFk() {
        return idGuestFk;
    }

    public void setIdGuestFk(GuestDTO idGuestFk) {
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
        if (!(object instanceof GiftlistGuestDTO)) {
            return false;
        }
        GiftlistGuestDTO other = (GiftlistGuestDTO) object;
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
