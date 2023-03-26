package Gradingsys_test;
import  Gradingsys.Validation ;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidationTest {

	@Test
	void isAlpha_test() {
		boolean expected =true;
		assertEquals (expected,Validation.isAlpha("asrsADAD")) ;
		assertEquals (expected,Validation.isAlpha("ADADjhgh")) ;
		assertEquals (expected,Validation.isAlpha("ASDFTSJJ")) ;
		assertEquals (expected,Validation.isAlpha("vjhferdt")) ;
		assertEquals (!expected,Validation.isAlpha("aref44A")) ;
		assertEquals (!expected,Validation.isAlpha("asre@#A")) ;
		assertEquals (!expected,Validation.isAlpha("?>jgg8d")) ;
		assertEquals (!expected,Validation.isAlpha("تيستنج")) ;
 }
	
	@Test
	void isNumeric_test() {
		boolean expected =true;
		assertEquals (expected,Validation.isNumeric("125496") );
		assertEquals (expected,Validation.isNumeric("888888") );
		assertEquals (!expected,Validation.isNumeric("1@#$J") );
		assertEquals (!expected,Validation.isNumeric("196fhA") );
		assertEquals (!expected,Validation.isNumeric("NADA") );
		assertEquals (!expected,Validation.isAlpha("تيستنج")) ;
	}
	
	@Test
	void isAlphaNumeric_test() {
		boolean expected =true;
		assertEquals (expected, Validation.isAlphaNumeric("asfg13224jg") );
		assertEquals (expected, Validation.isAlphaNumeric("asfg13224SDGF") );
		assertEquals (expected, Validation.isAlphaNumeric("SFGG1524mjbjh") );
		assertEquals (expected, Validation.isAlphaNumeric("SFVFGT122124ADS") );
		assertEquals (expected, Validation.isAlphaNumeric("AVGF124jlg") );
		assertEquals (expected, Validation.isAlphaNumeric("124AFFDHjg") );
		assertEquals (!expected, Validation.isAlphaNumeric("125875584") ); //expected to not be numbers only***fault
		assertEquals (expected, Validation.isAlphaNumeric("asfgjgFVBF") );
		assertEquals (!expected, Validation.isAlphaNumeric("asf@#g124jg") );
		assertEquals (!expected, Validation.isAlphaNumeric("عين شمس") );
	}
}
