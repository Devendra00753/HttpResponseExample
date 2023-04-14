package com.springboot.httpResponse.Service;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

@Service
public  class TimeStamp {
		OffsetDateTime offsetDateTime = OffsetDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
		public String timeStamp = offsetDateTime.format(formatter);

	
}
