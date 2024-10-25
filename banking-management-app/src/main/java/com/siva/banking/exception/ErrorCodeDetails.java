package com.siva.banking.exception;

import java.time.LocalDateTime;


public record ErrorCodeDetails(LocalDateTime time,
		String message,
		String details,
		String errorCode) {

}
