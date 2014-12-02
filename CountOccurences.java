/* Count the number of occurences in a sorted array
 * O(nlogn)
 * 1. use binary search to get the index of first occurence of x in arr-> i
 * 2. use binary search to get the index of last occurence of x in arr -> j
 * 3. return (j-i+1)
 *
 */

import java.util.*;

public class CountOccurences {


static int count(int[] arr, int x) {

	int i, j;

	int n = arr.length;

	i = first(arr, 0, n-1, x);

	if (i == -1)
		return -1;

	j = last(arr, i, n-1, x);

	return (j-i+1);
}

static int first(int[] arr, int low, int high, int x) {

	int n = arr.length;

	if (high >= low) {
		int mid = low + (high-low) / 2;

		if ((mid == 0 || x > arr[mid-1]) && arr[mid]==x)
			return mid;
		else if (x > arr[mid])
			return first(arr, mid + 1, high, x);
		else
			return first(arr, low, mid - 1, x); 
	}

	return -1;
}

static int last(int[] arr, int low, int high, int x) {

	int n = arr.length;

	if (high >= low) {
		int mid = low + (high-low) / 2;

		if ((mid == n - 1 || x < arr[mid+1]) && arr[mid]==x)
			return mid;
		else if (x < arr[mid])
			return last(arr, low, mid - 1, x);
		else
			return last(arr, mid + 1, high, x); 
	}

	return -1;
}

public static void main(String[] args) {

	int[] arr = {1, 2, 2, 3, 3, 3, 3};
	int x = 3;
	int c = count(arr, x);
	System.out.println(x + " occurs " + c + " times");
}

}
