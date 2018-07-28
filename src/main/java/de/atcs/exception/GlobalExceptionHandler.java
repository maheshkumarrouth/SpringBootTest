package de.atcs.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(AirTrafficControlException.class)
	public final ResponseEntity<String> handleRoomRateFetcherInfoException(AirTrafficControlException airTrafficControlException){
			return new ResponseEntity<>(airTrafficControlException.getErrorMsg(),airTrafficControlException.getHttpStatus());
	}
	
}
