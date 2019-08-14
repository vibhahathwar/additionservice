package additionservice.com.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import additionservice.com.error.CustomCalculatorException;
import additionservice.com.model.AdditionModel;
import additionservice.com.service.CalculatorService;

/*
 * Controller to map requestAPI ("/calculator/add") 
 * */
@RestController
public class CalculatorController {
	
	private Logger logger = LoggerFactory.getLogger(CalculatorController.class);
	
	@Autowired
	CalculatorService calculatorService;	
	
	/*
	 * method will get the list of requestparam and will add the numbers and returns the sum, 
	 * if any error will throw custom exception as an error 
	 * 
	 */
	@GetMapping("/calculator/add")	
	public AdditionModel additionOfNumbers(@RequestParam("values") List<String> values) throws CustomCalculatorException {	
		logger.info("Inside Calculator controller method");
		
		AdditionModel sum = new AdditionModel();					
		sum.setSum(calculatorService.addition(values));		
		return sum;
		
	}	
	
}
