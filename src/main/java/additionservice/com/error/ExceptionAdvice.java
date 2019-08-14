package additionservice.com.error;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
/*
 * Handle exception in application
 */
@ControllerAdvice
public class ExceptionAdvice{
	
	@ResponseBody
	@ExceptionHandler(CustomCalculatorException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	ErrorMessage errorMessage(CustomCalculatorException ex) {
		ErrorMessage error = new ErrorMessage();
		error.setErrorMessage(ex.getErrorMessage());
		return error;
	}	
}
