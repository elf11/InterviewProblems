import java.util.*;

/*
 * need to check 2 properties, if the max value - min value is equal
 * to the ending index minus starting index or not, and if the subarray
 * contains duplicates; we use a hash set for every subarray and if we
 * find an element that already has an element in the hash set we
 * don't consider the subarray O(n^2) as previously, considering
 * that add() and contains() take O(1)
 */

class ContiguousElemsDuplicates {


static int findLength(int[] arr) {
	int n = arr.length;
	int max_len = 1;


	for (int i = 0; i < n -1; i++) {
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(arr[i]);

		int mn = arr[i], mx = arr[i];

		for (int j = i+1; j < n; j++) {
			if (set.contains(arr[j])) {
				break;
			}

			set.add(arr[j]);
			mn = Math.min(mn, arr[j]);
			mx = Math.max(mx, arr[j]);

			if ((mx - mn) == (j-i)) {
				max_len = Math.max(max_len, mx - mn +1);
			}
		}
	}

	return max_len;
}

public static void main(String[] args) {

	int arr[] =  {10, 12, 12, 10, 10, 11, 12, 13, 14, 10};
       System.out.println("Length of the longest contiguous subarray is " +
                           findLength(arr));

}

}
