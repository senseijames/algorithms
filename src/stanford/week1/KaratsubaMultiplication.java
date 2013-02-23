package stanford.week1;

public class KaratsubaMultiplication
{
	public KaratsubaMultiplication() { }
	
	public static double multiply (long one, long two, int n)
	{
		if (n == 1) return one * two;
		
		/*
		 * 	x = ab, y = cd (both n/2 digits long)
		 * 	x = 10 ^ n/2 (a) + b
		 * 	y = 10 ^ n/2 (c) + d
		 * 	xy = 10 ^ n (ac) + 10 ^ n/2 (ad + bc) + bd
		 */
		
		// ab * cd...
		long a = get_half_digit (one, 1);
		long b = get_half_digit (one, 2);
		long c = get_half_digit (two, 1);
		long d = get_half_digit (two, 2);
		
		// 1. Recursively compute ac
		double ac = multiply (a, c, n/2);
		// 2. Recursively compute bd
		double bd = multiply (b, d, n/2);
		// 3. Recursively compute (a + b)(c + d) = ac + ad + bc + bd
		// Note we need to calculate this here cause it's either n/2 or n/2 + 1 digits ;-)
		int num_digits = Math.max(String.valueOf (a + b).length(), String.valueOf (c + d).length());
		double three = multiply (a + b, c + d, num_digits);
		
		// Gauss' trick: 3 - 1 - 2 = ad + bc
		return Math.pow(10, n) * ac + Math.pow(10, n/2) * (three - ac - bd) + bd;
	}
	
	protected static byte get_half_digit (long value, int half)
	{
		String value_string = String.valueOf (value);
		int half_length = value_string.length() / 2;
		value_string = value_string.substring (half_length * (half - 1), half_length * half); 
		return Byte.parseByte(value_string);
	}
}
