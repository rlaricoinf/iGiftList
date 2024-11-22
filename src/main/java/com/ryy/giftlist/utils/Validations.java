package com.ryy.giftlist.utils;

import java.util.List;

public class Validations {

	public static boolean validateIsNull(Object o) {
		if (o == null) {
			return true;
		}
		return false;
	}

	public static boolean validateIsNotNull(Object o) {
		return !validateIsNull(o);
	}

	public static boolean validateIsEmpty(Object o) {
		String d = o.toString();
		if (d.trim().length() == 0) {
			return true;
		}
		return false;
	}

	public static boolean validateIsNotEmpty(Object o) {
		return !validateIsEmpty(o);
	}

	public static boolean validateIsNullOrEmpty(Object o) {
		return (validateIsNull(o) || validateIsEmpty(o));
	}

	public static boolean validateIsNotNullAndNotEmpty(Object o) {
		return !validateIsNullOrEmpty(o);
	}

	public static boolean validateLstIsNullOrEmpty(List<?> list) {
		return list == null || list.isEmpty();
	}

	public static boolean validateLstIsNotNullAndNotEmpty(List<?> list) {
		return !validateLstIsNullOrEmpty(list);
	}
}
