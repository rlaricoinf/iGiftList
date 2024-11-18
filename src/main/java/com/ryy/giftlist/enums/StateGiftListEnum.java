package com.ryy.giftlist.enums;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum StateGiftListEnum {
	
	REGISTRADO(1, "REGISTRADO"), 
	RECHAZADO(2, "RECHAZADO"), 
	DISPONIBLE(3, "DISPONIBLE"), 
	RESERVADO(4, "RESERVADO");

	private Integer code;
	private String value;

	public static final List<StateGiftListEnum> list = new ArrayList<StateGiftListEnum>();
	public static final Map<Integer, StateGiftListEnum> lookup = new HashMap<Integer, StateGiftListEnum>();

	static {
		for (StateGiftListEnum type : EnumSet.allOf(StateGiftListEnum.class)) {
			list.add(type);
			lookup.put(type.getCode(), type);
		}
	}

	private StateGiftListEnum(Integer code, String value) {
		this.code = code;
		this.value = value;
	}

	public Integer getCode() {
		return code;
	}

	public String getValue() {
		return value;
	}
	
	public static StateGiftListEnum get(Integer code) {
		return lookup.get(code);
	}

}
