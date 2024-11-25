package com.ryy.security.bean;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.imageio.ImageIO;

import org.primefaces.PrimeFaces;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.ryy.giftlist.bean.GiftlistBean;
import com.ryy.giftlist.enums.StateGiftListEnum;
import com.ryy.giftlist.facade.GiftlistFacade;
import com.ryy.giftlist.model.dto.GiftlistDTO;
import com.ryy.giftlist.model.entities.Giftlist;
import com.ryy.giftlist.utils.Validations;

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

@Named("loginBean")
@ViewScoped
//@RequestScoped
public class LoginBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String code;

	private static final String VALID_CODE = "110824"; // Codigo valido

	@Inject
	private GiftlistFacade facade;

	@Inject
	private GiftlistBean imagen;

	private GiftlistDTO giftlistDTO;

	private List<GiftlistDTO> lstDTO;

	private boolean accessToPrivileges;
	private boolean buildImagen;

	@PostConstruct
	public void init() {
		giftlistDTO = new GiftlistDTO();
		lstDTO = facade.getAllList();

		accessToPrivileges = false;
		
		if(Validations.validateIsNotNull(giftlistDTO.getImageStream())) {
			giftlistDTO.setImageStream(getGraphicText());
		}
		
		buildImagen = false;
	}

	public void handleFileUpload(FileUploadEvent event) {
		if (event.getFile() != null) {

			// Seteando el contenido del archivo en el DTO
			if (giftlistDTO == null) {
				giftlistDTO = new GiftlistDTO();
			}
			giftlistDTO.setGiftImage(event.getFile().getContent());

			FacesMessage message = new FacesMessage("Mensaje Exitoso",
					event.getFile().getFileName() + " ha sido cargado exitosamente.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mensaje de Error",
					"No se pudo cargar el archivo");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}

	}

	public void cleanFormRegister() {
		giftlistDTO = new GiftlistDTO();
	}

	public void registro() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			giftlistDTO.setRegisterIp(getClientIp());
			facade.registro(giftlistDTO);
			
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro Exitoso",
					"Regalo registrado con exito"));
		} catch (Exception e) {
			e.printStackTrace();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
					"Se ha producido un error al intentar registrar el regalo"));
		}
		giftlistDTO = new GiftlistDTO();
		lstDTO = facade.getAllList();
	}
	
	public void capturarDatosDeFila(GiftlistDTO dto) {
		giftlistDTO =  (GiftlistDTO) dto.clone();
	}
	
	public void antesDeReservar(GiftlistDTO dto) {
		buildImagen = false;
		// Validando el estado del regalo
		if(Validations.validateIsNotNull(dto) 
				&& Validations.validateIsNotNull(dto.getStateGift())) {
			if(dto.getStateGift().equals(StateGiftListEnum.RESERVADO.getCode())) {
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Accion No permitida",
						"Solo puede reservar los regalos que esten en estado: 'DISPONIBLE'"));
			}else {
				capturarDatosDeFila(dto);
				buildImagen = true;
				PrimeFaces.current().executeScript("PF('dlgReservar').show();");
			}
		}
	}
	
	public void modificar() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			giftlistDTO.setLastModifyIp(getClientIp());
			facade.modificar(giftlistDTO);
			
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Modificacion Exitosa",
					"Regalo modificado con exito"));
		} catch (Exception e) {
			e.printStackTrace();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
					"Se ha producido un error al intentar modificar el regalo"));
		}
		lstDTO = facade.getAllList();
		giftlistDTO = new GiftlistDTO();
	}
	
	public void reservar() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			giftlistDTO.setLastModifyIp(getClientIp());
			giftlistDTO.setStateGift(StateGiftListEnum.RESERVADO.getCode());
			facade.modificar(giftlistDTO);
			
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Reserva Exitosa",
					"Regalo reservado con exito"));
		} catch (Exception e) {
			e.printStackTrace();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
					"Se ha producido un error al intentar reservar el regalo"));
		}
		lstDTO = facade.getAllList();
		giftlistDTO = new GiftlistDTO();
		buildImagen = false;
	}
	
	public void eliminar(GiftlistDTO dto) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			facade.eliminar(dto);
			
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminacion Exitosa",
					"Regalo eliminado con exito"));
		} catch (Exception e) {
			e.printStackTrace();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
					"Se ha producido un error al intentar eliminar el regalo"));
		}
		lstDTO = facade.getAllList();
	}

	/**
	 * metodo para obtener la IP del cliente
	 * 
	 * @return
	 */
	public String getClientIp() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		return request.getRemoteAddr();
	}

	public void preparedToAccessCode() {
		this.code = null;
	}

	public void loginAction() {
		// si el codigo de acceso es valido se muestran ciertos botones de
		// administracion
		accessToPrivileges = false;
		FacesContext context = FacesContext.getCurrentInstance();
		if (VALID_CODE.equals(this.code)) {
			accessToPrivileges = true;
			
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Acceso Permitido",
					"Codigo ingresado correcto"));
			// PrimeFaces.current().executeScript("PF('dlgLogin').hide();");
		} else {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Codigo incorrecto",
					"Por favor ingrese un codigo valido."));
		}
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
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Codigo incorrecto",
					"Por favor ingrese un codigo valido."));
		}
	}

	public StreamedContent getGraphicText2() {
		StreamedContent x = null;
		byte[] contenido = null;
		for (GiftlistDTO gl : lstDTO) {
			System.out.println("::: Retornando imagen");
			x = gl.getImageStream();
			contenido = gl.getGiftImage();
			break;
		}
		return imagen.getGraphicData(contenido);
	}

	public StreamedContent getGraphicText() {
		try {
			return DefaultStreamedContent.builder().contentType("image/png").stream(() -> {
				try {
					BufferedImage bufferedImg = new BufferedImage(100, 25, BufferedImage.TYPE_INT_RGB);
					Graphics2D g2 = bufferedImg.createGraphics();
					g2.drawString("This is a yext", 0, 10);
					ByteArrayOutputStream os = new ByteArrayOutputStream();
					ImageIO.write(bufferedImg, "png", os);
					return new ByteArrayInputStream(os.toByteArray());
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
			}).build();
		} catch (Exception e) {
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

	public boolean isAccessToPrivileges() {
		return accessToPrivileges;
	}

	public void setAccessToPrivileges(boolean accessToPrivileges) {
		this.accessToPrivileges = accessToPrivileges;
	}

	public boolean isBuildImagen() {
		return buildImagen;
	}

	public void setBuildImagen(boolean buildImagen) {
		this.buildImagen = buildImagen;
	}
	
	

}
