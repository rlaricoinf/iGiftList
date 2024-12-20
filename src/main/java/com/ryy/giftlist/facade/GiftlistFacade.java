package com.ryy.giftlist.facade;

import java.util.List;

import com.ryy.giftlist.model.dto.GiftlistDTO;
import com.ryy.giftlist.service.GiftlistService;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GiftlistFacade {

	@Inject
	GiftlistService service;
	
	public void registro(GiftlistDTO dto) {
		service.registo(dto);
	}
	
	public void modificar(GiftlistDTO dto) {
		service.modificar(dto);
	}
	
	public void eliminar(GiftlistDTO dto) {
		service.eliminar(dto);
	}
	
	public List<GiftlistDTO> getAllList() {
		return service.getAllList();
	}
}
