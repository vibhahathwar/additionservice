package additionservice.com.error;

public class CustomCalculatorException extends RuntimeException{

	/**
	 * Customised Exception Handling
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	
	public CustomCalculatorException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	

}
