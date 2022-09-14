package com.teste.sicredi.gerenciador.votos.api.exceptiohandler;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.teste.sicredi.gerenciador.votos.api.exceptiohandler.exceptions.BadRequestException;
import com.teste.sicredi.gerenciador.votos.api.exceptiohandler.exceptions.InternalServerErrorException;
import com.teste.sicredi.gerenciador.votos.api.exceptiohandler.exceptions.NotFoundException;
import com.teste.sicredi.gerenciador.votos.api.exceptiohandler.exceptions.UnauthorizedException;


@ControllerAdvice
@RestController
public class ExceptionHandler extends ResponseEntityExceptionHandler {


	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@org.springframework.web.bind.annotation.ExceptionHandler(IOException.class)
	@ResponseBody
	ApiError handleIOException(HttpServletRequest req, Exception ex) {
		return new ApiError(ex.getMessage());
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@org.springframework.web.bind.annotation.ExceptionHandler(InternalServerErrorException.class)
	@ResponseBody
	ApiError handleInternalServerErrorExcpetion(HttpServletRequest req, Exception ex) {
		return new ApiError(ex.getMessage());
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@org.springframework.web.bind.annotation.ExceptionHandler(NotFoundException.class)
	@ResponseBody
	ApiError handleNotFoundException(HttpServletRequest req, NotFoundException ex) {
		return new ApiError(ex.getMessage());
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@org.springframework.web.bind.annotation.ExceptionHandler(BadRequestException.class)
	@ResponseBody
	ApiError handleBadRequestException(HttpServletRequest req, BadRequestException ex) {
		return new ApiError(ex.getMessage());
	}
	
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@org.springframework.web.bind.annotation.ExceptionHandler(UnauthorizedException.class)
	@ResponseBody
	ApiError handleUnauthorizedException(HttpServletRequest req, UnauthorizedException ex) {
		return new ApiError(ex.getMessage());
	}

}
