package com.ryy.giftlist.model.mapper;

//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import com.ryy.giftlist.model.dto.GiftlistDTO;
//import com.ryy.giftlist.model.dto.GiftlistGuestDTO;
//import com.ryy.giftlist.model.dto.GuestDTO;
//import com.ryy.giftlist.model.entities.Giftlist;
//import com.ryy.giftlist.model.entities.GiftlistGuest;
//import com.ryy.giftlist.model.entities.Guest;

public class GiftlistMapperImplAux /*implements GiftlistMapper*/ {
	/*@Override
	public GiftlistDTO toDTO(Giftlist entity) {
		if (entity == null) {
			return null;
		}

		GiftlistDTO giftlistDTO = new GiftlistDTO();

		giftlistDTO.setIdGiftlistPk(entity.getIdGiftlistPk());
		byte[] giftImage = entity.getGiftImage();
		if (giftImage != null) {
			giftlistDTO.setGiftImage(Arrays.copyOf(giftImage, giftImage.length));
		}
		giftlistDTO.setName(entity.getName());
		giftlistDTO.setDescription(entity.getDescription());
		giftlistDTO.setStateGift(entity.getStateGift());
		giftlistDTO.setRegisterDate(entity.getRegisterDate());
		giftlistDTO.setRegisterIp(entity.getRegisterIp());
		giftlistDTO.setRegisterUser(entity.getRegisterUser());
		giftlistDTO.setLastModifyDate(entity.getLastModifyDate());
		giftlistDTO.setLastModifyIp(entity.getLastModifyIp());
		giftlistDTO.setLastModifyUser(entity.getLastModifyUser());
		giftlistDTO.setGiftlistGuestList(giftlistGuestListToGiftlistGuestDTOList(entity.getGiftlistGuestList()));

		return giftlistDTO;
	}

	@Override
	public Giftlist toEntity(GiftlistDTO dto) {
		if (dto == null) {
			return null;
		}

		Giftlist giftlist = new Giftlist();

		giftlist.setIdGiftlistPk(dto.getIdGiftlistPk());
		byte[] giftImage = dto.getGiftImage();
		if (giftImage != null) {
			giftlist.setGiftImage(Arrays.copyOf(giftImage, giftImage.length));
		}
		giftlist.setName(dto.getName());
		giftlist.setDescription(dto.getDescription());
		giftlist.setStateGift(dto.getStateGift());
		giftlist.setRegisterDate(dto.getRegisterDate());
		giftlist.setRegisterIp(dto.getRegisterIp());
		giftlist.setRegisterUser(dto.getRegisterUser());
		giftlist.setLastModifyDate(dto.getLastModifyDate());
		giftlist.setLastModifyIp(dto.getLastModifyIp());
		giftlist.setLastModifyUser(dto.getLastModifyUser());
		giftlist.setGiftlistGuestList(giftlistGuestDTOListToGiftlistGuestList(dto.getGiftlistGuestList()));

		return giftlist;
	}

	protected GuestDTO guestToGuestDTO(Guest guest) {
		if (guest == null) {
			return null;
		}

		GuestDTO guestDTO = new GuestDTO();

		guestDTO.setIdGuestPk(guest.getIdGuestPk());
		guestDTO.setIdGuestCatFk(guest.getIdGuestCatFk());
		guestDTO.setGuestCode(guest.getGuestCode());
		guestDTO.setFullname(guest.getFullname());
		guestDTO.setStateGuest(guest.getStateGuest());
		guestDTO.setNumberOfCompanions(guest.getNumberOfCompanions());
		guestDTO.setObservations(guest.getObservations());
		guestDTO.setRegisterDate(guest.getRegisterDate());
		guestDTO.setRegisterIp(guest.getRegisterIp());
		guestDTO.setRegisterUser(guest.getRegisterUser());
		guestDTO.setLastModifyDate(guest.getLastModifyDate());
		guestDTO.setLastModifyIp(guest.getLastModifyIp());
		guestDTO.setLastModifyUser(guest.getLastModifyUser());
		guestDTO.setGiftlistGuestList(giftlistGuestListToGiftlistGuestDTOList(guest.getGiftlistGuestList()));

		return guestDTO;
	}

	protected GiftlistGuestDTO giftlistGuestToGiftlistGuestDTO(GiftlistGuest giftlistGuest) {
		if (giftlistGuest == null) {
			return null;
		}

		GiftlistGuestDTO giftlistGuestDTO = new GiftlistGuestDTO();

		giftlistGuestDTO.setIdGiftlistGuestPk(giftlistGuest.getIdGiftlistGuestPk());
		giftlistGuestDTO.setStateGiftlistGuest(giftlistGuest.getStateGiftlistGuest());
		giftlistGuestDTO.setRegisterDate(giftlistGuest.getRegisterDate());
		giftlistGuestDTO.setRegisterIp(giftlistGuest.getRegisterIp());
		giftlistGuestDTO.setRegisterUser(giftlistGuest.getRegisterUser());
		giftlistGuestDTO.setLastModifyDate(giftlistGuest.getLastModifyDate());
		giftlistGuestDTO.setLastModifyIp(giftlistGuest.getLastModifyIp());
		giftlistGuestDTO.setLastModifyUser(giftlistGuest.getLastModifyUser());
		giftlistGuestDTO.setIdGiftlistFk(toDTO(giftlistGuest.getIdGiftlistFk()));
		giftlistGuestDTO.setIdGuestFk(guestToGuestDTO(giftlistGuest.getIdGuestFk()));

		return giftlistGuestDTO;
	}

	protected List<GiftlistGuestDTO> giftlistGuestListToGiftlistGuestDTOList(List<GiftlistGuest> list) {
		if (list == null) {
			return null;
		}

		List<GiftlistGuestDTO> list1 = new ArrayList<GiftlistGuestDTO>(list.size());
		for (GiftlistGuest giftlistGuest : list) {
			list1.add(giftlistGuestToGiftlistGuestDTO(giftlistGuest));
		}

		return list1;
	}

	protected Guest guestDTOToGuest(GuestDTO guestDTO) {
		if (guestDTO == null) {
			return null;
		}

		Guest guest = new Guest();

		guest.setIdGuestPk(guestDTO.getIdGuestPk());
		guest.setIdGuestCatFk(guestDTO.getIdGuestCatFk());
		guest.setGuestCode(guestDTO.getGuestCode());
		guest.setFullname(guestDTO.getFullname());
		guest.setStateGuest(guestDTO.getStateGuest());
		guest.setNumberOfCompanions(guestDTO.getNumberOfCompanions());
		guest.setObservations(guestDTO.getObservations());
		guest.setRegisterDate(guestDTO.getRegisterDate());
		guest.setRegisterIp(guestDTO.getRegisterIp());
		guest.setRegisterUser(guestDTO.getRegisterUser());
		guest.setLastModifyDate(guestDTO.getLastModifyDate());
		guest.setLastModifyIp(guestDTO.getLastModifyIp());
		guest.setLastModifyUser(guestDTO.getLastModifyUser());
		guest.setGiftlistGuestList(giftlistGuestDTOListToGiftlistGuestList(guestDTO.getGiftlistGuestList()));

		return guest;
	}

	protected GiftlistGuest giftlistGuestDTOToGiftlistGuest(GiftlistGuestDTO giftlistGuestDTO) {
		if (giftlistGuestDTO == null) {
			return null;
		}

		GiftlistGuest giftlistGuest = new GiftlistGuest();

		giftlistGuest.setIdGiftlistGuestPk(giftlistGuestDTO.getIdGiftlistGuestPk());
		giftlistGuest.setStateGiftlistGuest(giftlistGuestDTO.getStateGiftlistGuest());
		giftlistGuest.setRegisterDate(giftlistGuestDTO.getRegisterDate());
		giftlistGuest.setRegisterIp(giftlistGuestDTO.getRegisterIp());
		giftlistGuest.setRegisterUser(giftlistGuestDTO.getRegisterUser());
		giftlistGuest.setLastModifyDate(giftlistGuestDTO.getLastModifyDate());
		giftlistGuest.setLastModifyIp(giftlistGuestDTO.getLastModifyIp());
		giftlistGuest.setLastModifyUser(giftlistGuestDTO.getLastModifyUser());
		giftlistGuest.setIdGiftlistFk(toEntity(giftlistGuestDTO.getIdGiftlistFk()));
		giftlistGuest.setIdGuestFk(guestDTOToGuest(giftlistGuestDTO.getIdGuestFk()));

		return giftlistGuest;
	}

	protected List<GiftlistGuest> giftlistGuestDTOListToGiftlistGuestList(List<GiftlistGuestDTO> list) {
		if (list == null) {
			return null;
		}

		List<GiftlistGuest> list1 = new ArrayList<GiftlistGuest>(list.size());
		for (GiftlistGuestDTO giftlistGuestDTO : list) {
			list1.add(giftlistGuestDTOToGiftlistGuest(giftlistGuestDTO));
		}

		return list1;
	}
	*/
}
