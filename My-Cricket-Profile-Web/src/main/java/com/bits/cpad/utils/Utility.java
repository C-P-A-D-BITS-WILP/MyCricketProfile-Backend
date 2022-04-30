package com.bits.cpad.utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Utility {

	public static Integer getAge(Date dob) {
		LocalDate curDate = LocalDate.now();
		if ((dob != null) && (curDate != null)) {
			return Period.between(convertToLocalDate(dob), curDate).getYears();
		} else {
			return 0;
		}
	}

	public static LocalDate convertToLocalDate(Date dateToConvert) {
		return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
}
