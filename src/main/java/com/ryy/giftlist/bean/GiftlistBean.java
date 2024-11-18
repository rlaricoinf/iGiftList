package com.ryy.giftlist.bean;

import java.io.ByteArrayInputStream;
import java.io.Serializable;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.ryy.giftlist.model.dto.GiftlistDTO;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class GiftlistBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public StreamedContent getGraphicData(byte[] imageData) {
        return DefaultStreamedContent.builder()
                .stream(() -> new ByteArrayInputStream(imageData))
                .contentType("image/png")
                .build();
    }
	
	

}
