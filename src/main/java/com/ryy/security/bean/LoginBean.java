package com.ryy.security.bean;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.imageio.ImageIO;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.ryy.giftlist.bean.GiftlistBean;
import com.ryy.giftlist.facade.GiftlistFacade;
import com.ryy.giftlist.model.dto.GiftlistDTO;
import com.ryy.giftlist.model.entities.Giftlist;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
//import jakarta.annotation.ManagedBean;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Named
@ViewScoped
//@RequestScoped
public class LoginBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String code;

    private static final String VALID_CODE = "12345"; // Codigo valido
    
    @Inject
    private GiftlistFacade facade;
    
    @Inject
    private GiftlistBean imagen;
    
    private GiftlistDTO giftlistDTO;
    
    private List<GiftlistDTO> lstDTO;
    
    private String testVar = ";";
    private byte[] xxx;
    
    @PostConstruct
    public void init() {
    	giftlistDTO = new GiftlistDTO();
    	lstDTO = facade.getAllList();
    	xxx = testVar.getBytes();
    }
    
    public void handleFileUpload(FileUploadEvent event) {
    	if(event.getFile() != null) {
    		
    		// Seteando el contenido del archivo en el DTO
    		if(giftlistDTO == null) {
    			giftlistDTO = new GiftlistDTO();
    		}
    		giftlistDTO.setGiftImage(event.getFile().getContent());
    		
    		FacesMessage message = new FacesMessage("Mensaje Exitoso", 
    				event.getFile().getFileName() + " ha sido cargado exitosamente.");
            FacesContext.getCurrentInstance().addMessage(null, message);	
    	}else {
    		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
    				"Mensaje de Error", "No se pudo cargar el archivo");
            FacesContext.getCurrentInstance().addMessage(null, message);
    	}
        
    }
    
    public void registro() {
    	giftlistDTO.setRegisterIp(getClientIp());
    	facade.registro(giftlistDTO);
    }
    
    /**
     * metodo para obtener la IP del cliente
     * @return
     */
	public String getClientIp() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().
				getExternalContext().getRequest();
		return request.getRemoteAddr();
	}

    public void login() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (VALID_CODE.equals(this.code)) {
            // Crear sesion y guardar el estado de autenticacion
            HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
            session.setAttribute("isLoggedIn", true);

            try {
                // Redirigir a la pagina protegida por el filtro
                context.getExternalContext().redirect("pages/giftlistPg.xhtml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // Mostrar mensaje de error si el codigo es incorrecto
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                      "Codigo incorrecto", 
                                                      "Por favor ingrese un codigo valido."));
        }
    }
    
    
    public StreamedContent getGraphicText2() {
    	StreamedContent x=null;
    	byte[] contenido = null;
    	for(GiftlistDTO gl:lstDTO) {
    		System.out.println("::: Retornando imagen");
    		x= gl.getImageStream();
    		contenido = gl.getGiftImage();
    		break;
    	}
    	return imagen.getGraphicData(contenido);
    }
    
    
    public StreamedContent getGraphicText() {
        try {
            return DefaultStreamedContent.builder()
                    .contentType("image/png")
                    .stream(() -> {
                        try {
                            BufferedImage bufferedImg = new BufferedImage(100, 25, BufferedImage.TYPE_INT_RGB);
                            Graphics2D g2 = bufferedImg.createGraphics();
                            g2.drawString("This is a yext", 0, 10);
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

    
    
    // METODOS GETTER y Setter
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

	public GiftlistDTO getGiftlistDTO() {
		return giftlistDTO;
	}

	public void setGiftlistDTO(GiftlistDTO giftlistDTO) {
		this.giftlistDTO = giftlistDTO;
	}

	public List<GiftlistDTO> getLstDTO() {
		return lstDTO;
	}

	public void setLstDTO(List<GiftlistDTO> lstDTO) {
		this.lstDTO = lstDTO;
	}

	public String getTestVar() {
		return testVar;
	}

	public void setTestVar(String testVar) {
		this.testVar = testVar;
	}
	
	
    
    

}
