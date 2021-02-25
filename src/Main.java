
public class Main {

	public static void main(String[] args) {
		
		long z = 1L;
		long a = 1l;
		long b = (long) 1;
		
		double c = 1d;
		double d = (double) 1;
		
		Double e = 1d;
		Double f = (double)1;
		
		char x = '\u0000';
		char y = 0;
		
		if (a == b && a == z ) {
			System.out.println("these longs are equal");
		} else {
			System.out.println("these longs are NOT equal");
		}
		
		if (c == d) {
			System.out.println("these doubles are equal");
		} else {
			System.out.println("these doubles are NOT equal");
		}
		
		if (e.equals(f)) {
			System.out.println("these Doubles are equal");
		} else {
			System.out.println("these Doubles are NOT equal");
		}
		
		System.out.println(">>>"+ x + "<<<");
		System.out.println(">>>"+ y + "<<<");
		
		if (x == y) {
			System.out.println("these chars are equal");
		} else {
			System.out.println("these chars are NOT equal");
		}
	}

}
