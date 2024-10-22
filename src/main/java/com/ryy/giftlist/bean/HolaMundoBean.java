package com.ryy.giftlist.bean;

import java.io.Serializable;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class HolaMundoBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String mensaje = "¡Hola desde JSF!";

	public HolaMundoBean() {
		
	}
	
	@PostConstruct
	public void init() {
		System.out.println("::: contruyecto la clase");
		
//		try {
//			Application app = (Application) FactoryFinder.getFactory(FactoryFinder.APPLICATION_FACTORY);
//	        System.out.println("JSF Version: " + app.getClass().getPackage().getImplementationVersion());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
	}

	public String getMensaje() {
		return mensaje;
	}

	public void saludar() {
		mensaje = "¡Hola Mundo, este es un mensaje generado con JSF!";
	}
}
