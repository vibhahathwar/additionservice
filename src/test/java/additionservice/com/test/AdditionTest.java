package additionservice.com.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import additionservice.com.error.CustomCalculatorException;
import additionservice.com.service.CalculatorService;

public class AdditionTest {

	private Logger logger = LoggerFactory.getLogger(AdditionTest.class);
	
	@InjectMocks
	private CalculatorService calculatorService;	
	
		
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void addNumberTest() {
		logger.info("test sum of list of numbers");
		List<String> numbers = new ArrayList<String>();
		numbers.add("1");
		numbers.add("5");	
		double result = calculatorService.addition(numbers);
		assertEquals(6, result, 0);			
	}
	
	@Test
	public void add_numbers_test1() {
		logger.info("test sum of list of numbers");
		List<String> numbers = new ArrayList<String>();
		numbers.add("1.0");
		numbers.add("-10.8");	
		double result = calculatorService.addition(numbers);
		assertEquals(-9.8, result, 0);			
	}
	
	@Test
	public void add_numbers_test2() {
		logger.info("test sum of list of numbers");
		List<String> numbers = new ArrayList<String>();
		numbers.add("0");
		numbers.add("-0");	
		double result = calculatorService.addition(numbers);
		assertEquals(-0, result, 0);			
	}
	
	@Test
	public void add_numbers_test3() {
		logger.info("test sum of list of numbers");
		List<String> numbers = new ArrayList<String>();
		numbers.add("13124.12");
		numbers.add("5678");
		numbers.add("100.78");
		numbers.add("200");
		double result = calculatorService.addition(numbers);
		assertEquals(19102.9, result, 0);			
	}
	
		
	@Test(expected = CustomCalculatorException.class)
	public void checkforNumberFormatException() {
		List<String> numbers = new ArrayList<String>();
		numbers.add("f");
		numbers.add("g");
		calculatorService.addition(numbers);
	}
	
	@Test(expected = CustomCalculatorException.class)
	public void emptyListcheck() {
		List<String> numbers = new ArrayList<String>();
		calculatorService.addition(numbers);
	}
	
}
