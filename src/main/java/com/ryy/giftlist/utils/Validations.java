package com.ryy.giftlist.utils;

import java.util.List;

public class Validations {
	
	
	public static boolean validateLstIsNullOrEmpty(List<?> list) {
		return list == null || list.isEmpty();
	}
	
	public static boolean validateLstIsNotNullAndNotEmpty(List<?> list) {
		return !validateLstIsNullOrEmpty(list);
	}
}
