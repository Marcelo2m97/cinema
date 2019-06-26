package com.uca.capas.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class EntityUtils {
	
	public static String activoToString(boolean activo) {
		if (activo) {
			return "Activo";
		}
		return "Inactivo";
	}
	
	public static String dateToString(Calendar date) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String dateString = sdf.format(date.getTime());
		return dateString;
	}
}
