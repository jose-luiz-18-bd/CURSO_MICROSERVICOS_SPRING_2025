package br.com.zeluiz_dev.exception;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) {
}
