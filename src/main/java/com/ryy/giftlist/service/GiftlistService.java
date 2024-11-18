package com.ryy.giftlist.service;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.ryy.giftlist.enums.StateGiftListEnum;
import com.ryy.giftlist.model.dto.GiftlistDTO;
import com.ryy.giftlist.model.entities.Giftlist;
import com.ryy.giftlist.model.mapper.GiftlistMapper;
import com.ryy.giftlist.utils.Validations;

import jakarta.ejb.Stateless;
import jakarta.persistence.Query;

@Stateless
public class GiftlistService extends CrudDaoService {

	public void registo(GiftlistDTO dto) {
		// conversion de DTO a Entity
		Giftlist entity = GiftlistMapper.INSTANCE.toEntity(dto);
		
		//entity.setGiftImage(dto.getGiftImage());
		
		// Pistas de auditoria
		entity.setStateGift(StateGiftListEnum.REGISTRADO.getCode());
		entity.setRegisterDate(new Date());
		
		insert(entity);
	}
	
	public List<GiftlistDTO> getAllList(){

		StringBuilder sd=new StringBuilder();
		sd.append(" select gl");
		sd.append(" from Giftlist gl");
		sd.append(" order by gl.idGiftlistPk asc ");
		
		try {
			Query q = em.createQuery(sd.toString());
			List<Giftlist> lstEntity = q.getResultList();
			if(Validations.validateLstIsNotNullAndNotEmpty(lstEntity)) {
				List<GiftlistDTO> lst = new ArrayList<>();
				GiftlistDTO dto;
				for(Giftlist entity:lstEntity) {
					dto = GiftlistMapper.INSTANCE.toDTO(entity);
					
					byte[] imagenByte = dto.getGiftImage();
					
					StreamedContent imageStream = DefaultStreamedContent.builder()
		                    .stream(() -> new ByteArrayInputStream(imagenByte))
		                    .contentType("image/png") 
		                    .name("myImageRlm.png") 
		                    .build();
					
					dto.setImageStream(imageStream);
					
					
//					dto.setImagenBase64(getImageBase64(dto.getGiftImage()));
//					if(dto.getImagenBase64()!=null) {
//						System.out.println("::: "+dto.getImagenBase64());
//					}
					
					lst.add(dto);
				}
				return lst;
			}
		} catch (Exception e) {
			//e.getMessage()
		}
		
		return null;
	}
	
	public StreamedContent getGraphicText() {
        try {
            return DefaultStreamedContent.builder()
                    .contentType("image/png")
                    .stream(() -> {
                        try {
                            BufferedImage bufferedImg = new BufferedImage(100, 25, BufferedImage.TYPE_INT_RGB);
                            Graphics2D g2 = bufferedImg.createGraphics();
                            g2.drawString("This is a text", 0, 10);
                            ByteArrayOutputStream os = new ByteArrayOutputStream();
                            ImageIO.write(bufferedImg, "png", os);
                            return new ByteArrayInputStream(os.toByteArray());
                        }
                        catch (Exception e) {
                            e.printStackTrace();
                            return null;
                        }
                    })
                    .build();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	
	public String getImageBase64(byte[] imageData) {
        if (imageData != null) {
            return "data:image/png;base64," + Base64.getEncoder().encodeToString(imageData);
        }
        return null; // Si no hay datos de imagen
    }
	
}
