package stanford.week2;

//import java.text.NumberFormat;
import java.util.Arrays;

import stanford.utils.StanfordUtils;


public class QuickSort
{
	public static PivotStrategy pivot_strategy;
	public static double num_comparisons;
	
	public static enum PivotStrategy { FIRST, LAST, MEDIAN };
	
	public QuickSort () { }
	
	public static void sort (int[] array)
	{
		num_comparisons = 0;
		
		do_sort (array, 0, array.length);

		System.out.println (num_comparisons + " comparisons were made");
//		NumberFormat format = NumberFormat.getInstance();
//		System.out.println (format.format(num_comparisons) + " comparisons were made");
	}

	protected static void do_sort (int[] array, int start, int length)
	{
		if (length <= 1) {
			return;
		}
		
		num_comparisons += length - 1;
		
		int pivot = choose_pivot (array, start, length);
		StanfordUtils.array_swap (array, start, start + pivot); // Swap pivot and first element.
		int pivot_index = partition (array, start, start + length - 1);
		do_sort (array, start, pivot_index - start);
		do_sort (array, pivot_index + 1, start + length - pivot_index - 1);		
	}

	// @return a (relative) index; i.e. an index relative to the start.
	public static int choose_pivot (int[] array, int start, int length)
	{
		switch (pivot_strategy)
		{
			case FIRST:
				return 0;
			case LAST:
				return length - 1;
			case MEDIAN:
			default:
				int middle_index = get_middle_index(length);
				int[] pivot_array = new int[]{ array[start], array[start + middle_index], array[start + length - 1]};
				Arrays.sort(pivot_array);
				if (pivot_array[1] == array[start]) return 0;
				if (pivot_array[1] == array[start + middle_index]) return middle_index;
				return length - 1;				
		}
	}
	
	// Returns the (relative to the implied start) middle index of the array.
	public static int get_middle_index (int length)
	{
		return (int)Math.ceil((float)length / 2) - 1;
	}
	
	// @return - the new (absolute) index of the pivot, because it changes index during the partition operation ;-) 
	public static int partition (int[] array, int low_index, int high_index)
	{
		int pivot = array [low_index];
		int current_pivot_cursor = low_index + 1;
		
		for (int partition_divider_cursor = low_index + 1; partition_divider_cursor <= high_index; partition_divider_cursor++) {
			if (array[partition_divider_cursor] < pivot) {
				StanfordUtils.array_swap (array, partition_divider_cursor, current_pivot_cursor);
				current_pivot_cursor++;
			}
		}
		StanfordUtils.array_swap (array, low_index, current_pivot_cursor - 1);
		return current_pivot_cursor - 1;
	}
}
