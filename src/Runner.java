import java.util.Arrays;

import stanford.week1.KaratsubaMultiplication;
import stanford.week1.MergeSort;
import stanford.week2.ArrayInversions;

/*
 * Algorithms!!  TODO:
 * Watch: 3-4, 3-5
 * Implement: Katsuraba Multiplication, Strassen Matrix Multiplication
 */
public class Runner
{
	public Runner() { }

	public static void main (String[] args)
	{
		/*
		run_merge_sort (new int[]{ 6, 5, 4, 3, 2, 1 });
		run_merge_sort (new int[]{ 10, 9, 8, 7, 6 });
		*/
		
		/*
		// 0
		run_array_inversions (new int[] { 1, 2, 3, 4, 5 });
		// 10 choose 2 = 45
		run_array_inversions (new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 });
		// 3
		run_array_inversions (new int[] { 1, 3, 5, 2, 4, 6 });
		*/
		
		run_strassen_matrix_multiply ();
		
		run_karatsuba_multiply (2, 4, 1);
		run_karatsuba_multiply (20, 40, 2);
		run_karatsuba_multiply (1234, 5678, 4);
	}

	public static void run_karatsuba_multiply (int one, int two, int n)
	{
		System.out.println ("Running Karatsuba multiply for " + one + " and " + two);
		System.out.println ("Yields " + KaratsubaMultiplication.multiply(one, two, n) + " and actual is " + (one * two));
	}

	public static void run_merge_sort (int[] unsorted_list)
	{
		System.out.println("Running merge sort...");
		System.out.println ("Unsorted list: " + Arrays.toString(unsorted_list));
		
		int[] sorted_list = MergeSort.sort (unsorted_list);
		System.out.println ("Sorted list: " + Arrays.toString(sorted_list) + "\n");
	}
	
	public static void run_array_inversions (int[] array)
	{
		System.out.println("Counting array inversions for " + Arrays.toString(array) + "...");
		long num_inversions = ArrayInversions.count (array);
		long num_inversions_brute_force = ArrayInversions.count_brute_force(array);
		System.out.println("Counted " + num_inversions + " recursively and " + 
							num_inversions_brute_force + " by brute force");
	}
	
	public static void run_strassen_matrix_multiply ()
	{
		// Implement this shit!
	}
}
