package stanford.week2;

import java.util.Arrays;

import stanford.utils.StanfordUtils;

public class ProgramQuickSort
{
	public static void main (String[] args)
	{
//		run_simple_test ();
//		run_rigorous_test ();
		
//		run_simple_partition_test ();
//		run_rigorous_partition_test ();

//		run_test_middle_index ();
		
		run_question ("one", QuickSort.PivotStrategy.FIRST);
		run_question ("two", QuickSort.PivotStrategy.LAST);
		run_question ("three", QuickSort.PivotStrategy.MEDIAN);
	}

	public static void run_question (String name, QuickSort.PivotStrategy pivot_strategy)
	{
		System.out.println ("\nRunning QuickSort for problem " + name + "...");

		QuickSort.pivot_strategy = pivot_strategy;
		int[] array = StanfordUtils.get_array_from_file ("input_files/QuickSort.txt");
		QuickSort.sort(array);

		System.out.println ("Array length: " + array.length + ", is sorted: " + is_sorted (array));		
	}
	
	
	
	/* * * * * * * * * Run test cases * * * * * * * * * * */

	public static void run_benchmark_sorts (QuickSort.PivotStrategy pivot_strategy)
	{
		System.out.println("\nRunning benchmark for pivot strategy " + pivot_strategy);
		QuickSort.pivot_strategy = pivot_strategy;
		
		run_single_sort (new int[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
		run_single_sort (new int[]{ 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 });
		
		int[] one_hundred = new int[100];
		for (int i = 1; i <= 100; i++) {
			one_hundred[i - 1] = i;
		}
		run_single_sort (one_hundred);
		
		for (int i = 100; i > 0; i--) {
			one_hundred[100 - i] = i;
		}
		run_single_sort (one_hundred);
		
		run_single_sort (new int[]{ 2, 8, 9, 3, 7, 5, 10, 1, 6, 4 });
		
		run_single_sort (StanfordUtils.get_array_from_file("IntegerArray.txt"));
		
//		run_single_sort (new int[]{ 1, 11, 5, 15, 2, 999, 3, 2, 98, 765, 8, 14, 15, 16, 88, 145, 100, 12, 9, 99, 77, 0 });
	}

	public static void run_rigorous_partition_test ()
	{
		test_single_partition (get_random_array (10));
		test_single_partition (get_random_array (100));
		test_single_partition (get_random_array (1000));
		test_single_partition (get_random_array (10000));
	}
	
	
	public static void run_simple_partition_test ()
	{
		test_single_partition (new int[]{ 5, 9, 8, 7, 6, 4, 10, 3, 1, 2 });
		test_single_partition (new int[]{ 4, 7, 3, 2 });
		test_single_partition (new int[]{ 10, 15, 2 });
		test_single_partition (new int[]{ 1, 2, 3 });
		test_single_partition (new int[]{ 3, 2, 1 });
		test_single_partition (new int[]{ 3, 2 });
		test_single_partition (new int[]{ 2, 3 });
	}
	
	public static void test_single_partition (int[] array)
	{
		int pivot_index = QuickSort.partition (array, 0, array.length - 1);
		boolean is_correct = test_partition (array, pivot_index);
		System.out.println ("\nPartition is correct is: " + is_correct);
		System.out.println ("After partition around " + array[pivot_index] + " array is:");
		StanfordUtils.print_array (array);
		
	}
	
	public static void run_simple_test ()
	{
		System.out.println("Running simple test...");
//		run_single_sort (new int[]{ 3, 4, 2, 1 });
//		run_single_sort (new int[]{ 3, 4, 2 });
		run_single_sort (new int[]{ 10, 9, 8, 7, 6, 4, 5, 3, 1, 2 });
		run_single_sort (new int[]{ 20, 13, 15, 9, 8, 7, 6, 4, 5, 3, 1, 2 });
	}
	
	public static void run_single_sort (int[] array)
	{
		System.out.println ("\nSorting array of size: " + array.length);
//		StanfordUtils.print_array (array);
		QuickSort.sort (array);
		System.out.println ("Is sorted returns: " + is_sorted(array));// + " After sort:");
//		StanfordUtils.print_array (array);
	}
	
	public static void run_rigorous_test ()
	{
		run_single_sort (get_random_array (100));
		run_single_sort (get_random_array (1000));
		run_single_sort (get_random_array (10000));
		run_single_sort (get_random_array (100000));
	}
	
	public static void run_test_middle_index ()
	{
		System.out.println ("Testing middle index...");
		for (int i = 0; i < 20; i++) {
			System.out.println(i + ": " + QuickSort.get_middle_index(i));
		}
	}
	
	public static boolean test_partition (int[] array, int pivot_index)
	{
		int pivot = array[pivot_index];
		for (int i = 0; i < array.length; i++) {
			if (i < pivot_index && array[i] > pivot) return false; // Elements before the pivot should be less than it.
			if (i > pivot_index && array[i] < pivot) return false; // Elements after the pivot should be greater than it.
		}
		return true;
	}

	/* * * * * * * * * Test helpers / utils * * * * * * * * * * */
	
	public static int[] get_random_array (int size)
	{
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = (int) (Math.random() * size); 
		}
		return array;
	}
	
	public static boolean is_sorted (int[] array)
	{
		int[] array_copy = Arrays.copyOf(array, array.length);
		Arrays.sort(array_copy);
		for (int i = 0; i < array_copy.length; i++) {
			if (array_copy[i] != array[i]) return false;
		}
		return true;
	}
	
}
