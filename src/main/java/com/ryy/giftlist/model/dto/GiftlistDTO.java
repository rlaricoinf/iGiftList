/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ryy.giftlist.model.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.primefaces.model.StreamedContent;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 *
 * @author dnrol
 */
public class GiftlistDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idGiftlistPk;
    private byte[] giftImage;
    private String name;
    private String description;
    private Integer stateGift;
    @Temporal(TemporalType.TIMESTAMP)
    private Date registerDate;
    private String registerIp;
    private String registerUser;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifyDate;
    @Column(name = "last_modify_ip")
    private String lastModifyIp;
    @Column(name = "last_modify_user")
    private String lastModifyUser;
    private List<GiftlistGuestDTO> giftlistGuestList;
    
    
    private StreamedContent imageStream;

    public GiftlistDTO() {
    }

    public GiftlistDTO(Integer idGiftlistPk) {
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

    public List<GiftlistGuestDTO> getGiftlistGuestList() {
        return giftlistGuestList;
    }

    public void setGiftlistGuestList(List<GiftlistGuestDTO> giftlistGuestList) {
        this.giftlistGuestList = giftlistGuestList;
    }

	public StreamedContent getImageStream() {
		return imageStream;
	}

	public void setImageStream(StreamedContent imageStream) {
		this.imageStream = imageStream;
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
        if (!(object instanceof GiftlistDTO)) {
            return false;
        }
        GiftlistDTO other = (GiftlistDTO) object;
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
