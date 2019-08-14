package additionservice.com.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import additionservice.com.error.CustomCalculatorException;

/**
 * CalculatorService class implements CalculatorService interface which 
 * overrides the additioon method to calculate the sum of the integers
 *
 */

@Service
public class CalculatorService implements CalculatorServiceInterface{
		
	Logger logger = LoggerFactory.getLogger(CalculatorService.class);
	
	@Override
	public double addition(List<String> values) {
		logger.info("inside addition method of Calculator service");
		//method to validate empty list
		validateNumberForEmpty(values);
		//method to convert string to double
		List<Double> ConvertedNumbers = convertStringtoDouble(values);
		double total = 0;		
		for(Double number : ConvertedNumbers) {
			total = total + number;
		}		
		return total;
	}


	/*
	 * method to convert request param string values to double
	 * if conversion fails , it will throw error as a json format
	 * */
	public List<Double> convertStringtoDouble(List<String> values) {
		logger.info("convert list of String to Double");
		List<Double> convertedNumberList = new ArrayList<Double>();		
		try {
		for(String strValues : values) {
			Double convertedDouble = Double.valueOf(strValues); 
			convertedNumberList.add(convertedDouble);
		}
		}catch(NumberFormatException ex) {
			logger.error("unable to convert to numbers");
			throw new CustomCalculatorException("unable to convert to Numbers, enter Numbers with comma seperated");
		}catch(Exception ex) {
			throw new CustomCalculatorException("Try once again!!!");
		}
		return convertedNumberList;		
	}

	/*
	 * check the list of value is empty
	 * if empty throw exception as error in json format
	 * */
	public void validateNumberForEmpty(List<String> values) {
		logger.info("validate List for empty");
		if(values.size() == 0) {
			logger.error("Empty List");
			throw new CustomCalculatorException("Numbers are not entered");
		}	
	}
}
