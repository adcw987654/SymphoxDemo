package com.example.demo.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.StringUtils;

public class DateUtil {

	public static final DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	public static String formatDateTime(LocalDateTime time) {
		if (time == null) {
			return "";
		}
		return format1.format(time);
	}

	public static LocalDateTime parseDateTime(String timeStr) {
		if (StringUtils.isBlank(timeStr)) {
			return null;
		}
		return LocalDateTime.parse(timeStr, format1);
	}

}
