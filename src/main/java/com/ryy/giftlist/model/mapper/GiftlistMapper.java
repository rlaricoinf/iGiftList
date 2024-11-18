package com.ryy.giftlist.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.ryy.giftlist.model.dto.GiftlistDTO;
import com.ryy.giftlist.model.entities.Giftlist;

@Mapper
public interface GiftlistMapper {
	GiftlistMapper INSTANCE = Mappers.getMapper(GiftlistMapper.class);
	
	GiftlistDTO toDTO(Giftlist entity);
	Giftlist toEntity(GiftlistDTO dto);
}
