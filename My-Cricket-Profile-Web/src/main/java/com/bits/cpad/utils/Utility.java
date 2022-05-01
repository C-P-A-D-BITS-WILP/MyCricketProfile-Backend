package com.bits.cpad.utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;

public class Utility {

	public static Integer getAge(Date dob) {
		LocalDate curDate = LocalDate.now();
		try {
			if ((dob != null) && (curDate != null)) {
				return Period.between(convertToLocalDate(dob), curDate).getYears();
			} else {
				return 0;
			}
		} catch (Exception e) {
			return 0;
		}
	}

	public static LocalDate convertToLocalDate(Date dateToConvert) {
		return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public static String generateHashValue(int len) {
		String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		return "#" + sb.toString();
	}
}
