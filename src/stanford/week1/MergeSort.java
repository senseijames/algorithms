package stanford.week1;

import java.util.Arrays;

public class MergeSort
{
	public MergeSort() { }

	public static int[] sort (int[] unsorted_list)
	{
		// Base cases / exit conditions
		if (unsorted_list.length < 2) return unsorted_list;
		
		// Divide and conquer - divide the list in half and recurse!
		// Combine subproblems' solutions - merge!
		return merge (sort (Arrays.copyOfRange(unsorted_list, 0, unsorted_list.length / 2)),
					  sort (Arrays.copyOfRange(unsorted_list, unsorted_list.length / 2, unsorted_list.length)));
		// Note that range in Arrays.copyOfRange is (inclusive, exclusive), so (0, 3) will return 
		// only an array of three items [0, 1, 2].
	}
	
	// Parallel pointers walk and merge baby!!
	public static int[] merge (int[] one, int[] two)
	{
		int[] merged_list = new int[one.length + two.length];
		for (int k = 0, i = 0, j = 0; k < merged_list.length; k++) {
			// Make sure we don't overrun either of the input arrays.
			if (i == one.length) {
				merged_list[k] = two[j++];
				continue;
			}
			else if (j == two.length) {
				merged_list[k] = one[i++];
				continue;
			}
			
			// Run the merge per SOP.
			merged_list[k] = (one[i] < two[j]) ? one[i++] : two[j++];
			/*
			if (one[i] < two[j]) {
				merged_list[k] = one[i++];
			}
			else {
				merged_list[k] = two[j++];
			}
			*/
		}
		
		return merged_list;
	}
}
