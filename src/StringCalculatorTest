package calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {
	private StringCalculator cal;
	
	@Before
	public void setup() {
		cal = new StringCalculator();
		System.out.println("before");
	}
	
	@Test
	public void testNullCase() {
		assertEquals(0, cal.add(null));
	}
	
	@Test
	public void testEmptyCase() {
		assertEquals(0, cal.add(""));
	}
	
	@Test
	public void testDelimiterCase() {
		assertEquals(3, cal.add("1,2"));
		assertEquals(6, cal.add("1,2,3"));
		assertEquals(6, cal.add("1,2:3"));
	}
	
	@Test
	public void testCustomDelimiterCase() {
		assertEquals(6, cal.add("//;\n1;2;3"));
	}
	
	@Test(expected=RuntimeException.class)
	public void testNegativeCase() throws Exception {
		cal.add("-1,2:3");
		cal.add("1,-2:3");
		cal.add("1,2:-3");
		cal.add("//;\n-1;2;3");
	}
	
}
