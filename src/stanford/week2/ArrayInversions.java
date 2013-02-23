package stanford.week2;

import java.util.Arrays;

public class ArrayInversions
{
	public static long count (int[] array)
	{
		return sort_and_count (array).count;
	}
	
	protected static ArrayCountPair sort_and_count (int[] array)
	{
		// Base cases / exit condition.
		if (array.length == 1) return new ArrayCountPair(array, 0);
		
		// Divide and conquer.
		ArrayCountPair first_half = sort_and_count (Arrays.copyOfRange(array, 0, array.length / 2));
		ArrayCountPair second_half = sort_and_count (Arrays.copyOfRange(array, array.length / 2,  array.length));
		ArrayCountPair split = merge_and_count_split (first_half.array, second_half.array);

		// Combine.
		return new ArrayCountPair(split.array, first_half.count + second_half.count + split.count);
	}

	protected static ArrayCountPair merge_and_count_split (int[] one, int[] two)
	{
		int[] return_array = new int[one.length + two.length];
		long num_inversions = 0;
		
		for (int i = 0, j = 0, k = 0; k < return_array.length; k++) {
			if (i == one.length) {
				return_array[k] = two[j++];
				continue;
			}
			else if (j == two.length) {
				return_array[k] = one[i++];
				continue;
			}
			
			if (one[i] < two[j]) {
				return_array[k] = one[i++];
			}
			else {
				return_array[k] = two[j++];
				num_inversions += one.length - i;
			}
		}
		
		return new ArrayCountPair (return_array, num_inversions);
	}
	
	// Recall that "long" is an 8 byte integer.
	public static long count_brute_force (int[] array)
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
}

class ArrayCountPair
{
	public int[] array;
	public long count;
	
	public ArrayCountPair (int[] array, long count)
	{
		this.array = array;
		this.count = count;
	}
}
