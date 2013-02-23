package stanford.week1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;

//import java.util.ArrayList;

public class Program {

	public Program () {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main (String[] args) {
		test_run ();
	}
	
	// System.arraycopy(src, srcPos, dest, destPos, length)	
	public static void test_run ()
	{
		System.out.println("hello James");
		
		Program program = new Program();
		
//		int[] array = new int[2];
		program.problem_one ("input_files/IntegerArray2.txt");
//		int[] array_two = new int[]{ 0, 5, 10, 15, 20 };
//		program.problem_one (array_two);
	}

	// file one - 2407905288
	public void problem_one (String text_file)
	{
		int[] array = get_array_from_file (text_file);
//		System.out.println("Length: " + array.length);
//		System.out.print(array);
		
		int[] test_array = new int[]{ 1, 3, 5, 2, 4, 6 };
		long inversions = num_array_inversions_brute_force (array);
System.out.println ("Calculating inversions...");		
		System.out.println("Answer is: " + inversions);
System.out.println ("done");		
	}
	
	public static long num_array_inversions_brute_force (int[] array)
	{
		long count = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (i < j && array[i] > array[j]) {
					++count;
				}
			}
		}
		
		return count;
	}
	
	public static int[] get_array_from_file (String filename)
	{
		int[] return_array = new int[100000];
		
		try {
			// Open the file
			FileInputStream fstream = new FileInputStream (filename);
			// Buffered Reader that shit
			BufferedReader br = new BufferedReader(new FileReader(filename));
			
			// Add to an Array
			int i = 0;
			String line;
			while ((line = br.readLine()) != null) {
				return_array[i++] = Integer.valueOf(line);			
			}
			
			br.close();
			
//			return return_array;
		}
		catch (Exception e) {
			System.out.println(e);
		}
		finally {
			return return_array;
		}
	}
	
	public static void print_array (int[] array)
	{
		System.out.println("");
		for (int i = 0; i < array.length; i++) {
			System.out.println(i + ": " + array[i]);
		}		
	}
}
