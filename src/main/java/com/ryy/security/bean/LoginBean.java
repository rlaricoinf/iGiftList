package com.ryy.security.bean;

import java.io.IOException;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
//import jakarta.annotation.ManagedBean;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpSession;

@Named
@RequestScoped
public class LoginBean {
	private String code;

    private static final String VALID_CODE = "12345"; // Código valido

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void login() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (VALID_CODE.equals(this.code)) {
            // Crear sesion y guardar el estado de autenticación
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
}
