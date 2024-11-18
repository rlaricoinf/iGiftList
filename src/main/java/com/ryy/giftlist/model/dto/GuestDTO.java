/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ryy.giftlist.model.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 *
 * @author dnrol
 */
public class GuestDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idGuestPk;
    private Integer idGuestCatFk;
    private Integer guestCode;
    private String fullname;
    private Integer stateGuest;
    private Integer numberOfCompanions;
    private String observations;
    @Temporal(TemporalType.TIMESTAMP)
    private Date registerDate;
    private String registerIp;
    private String registerUser;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifyDate;
    private String lastModifyIp;
    private String lastModifyUser;
    private List<GiftlistGuestDTO> giftlistGuestList;

    public GuestDTO() {
    }

    public GuestDTO(Integer idGuestPk) {
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

    public List<GiftlistGuestDTO> getGiftlistGuestList() {
        return giftlistGuestList;
    }

    public void setGiftlistGuestList(List<GiftlistGuestDTO> giftlistGuestList) {
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
        if (!(object instanceof GuestDTO)) {
            return false;
        }
        GuestDTO other = (GuestDTO) object;
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
