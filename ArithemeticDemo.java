import java.math.BigDecimal;


public class ArithemeticDemo {
	
	public static BigDecimal addition(BigDecimal x, BigDecimal y) {

		return x.add(y);
	}
	
	public static BigDecimal subtraction(BigDecimal x, BigDecimal y) {
		return x.subtract(y);
	}
	
	public static String getName(String name) {
		return name;
	}
	
	public static void swap(String x, String y) {
		String holdX=x;
		x=y;
		y=holdX;
		
	}
}
