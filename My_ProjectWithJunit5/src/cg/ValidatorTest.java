package cg;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {
	
	@ParameterizedTest
	@ValueSource(strings= {"racecar","radar","nitin","naman"})
	void test3(String data) {
		Validator ob=new Validator();
		//sertTrue(ob.validateNo(null));
		System.out.println("Test is palindrome with value "+data);
		assertTrue(ob.isPalindrome(data));
	}
	
	
	@ParameterizedTest
	@CsvSource({"4,5","10,20","100,50"})
	void test4(int a, int b)
	{
		calculator ob=new calculator();
		System.out.println("test add with values a= "+a+"'b=+b");
		assertTrue(ob.add(a, b)>0);
	}
	
	@ParameterizedTest
	@MethodSource("testaddwithoutput")
	void withMethodSource(int a,int b,int op) {
		calculator ob=new calculator();
		System.out.println("test add with values a= "+a+"b="+b+" output"+op);
		assertEquals(op,ob.add(a, b));
	}
	private static Stream<Arguments> testaddwithoutput(){
		return Stream.of(
				Arguments.of(4,5,9),
				Arguments.of(100,500,600));
				
	}
	
	@ParameterizedTest
	@EnumSource(Size.class)
	void withAllEnumValues(Size size) {
		System.out.println("Test Enum value "+size);
		Validator ob=new Validator();
		assertEquals(size.getMl(),ob.getSizeinMl(size));
	}
  /*  
	@Test
	void test1() {
		Validator ob=new Validator();
		String data="100";
		Assumptions.assumeTrue(data!=null);
		System.out.println("assertTrue");
		assertTrue(ob.validateNo(data));
	    
		System.out.println("assertFalse");
		data="abc";
		assertFalse(ob.validateNo(data));
	}
	
	@Test
	void test2() {
		Validator ob=new Validator();
		//sertTrue(ob.validateNo(null));
		assertThrows(NullPointerException.class,()->ob.validateNo(null));
	}
	
/*	
 //()->ob.validateNo(Null)
   class_implements Executable
	{
		public boolean execute()
		{
			return ob.validateNo(null);
		}
	}*/
}
