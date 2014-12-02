import java.util.*;
/*
 * all elements are distinct, so the subarray has contiguous elements
 * iff the difference between max and min elems in subarray is equal to the
 * diff between last and first indexes of subarray
 */

class ContiguousElems {

static int max(int x, int y) {
	return (x < y) ? y : x;
}

static int min(int x, int y) {
	return (x < y) ? x : y;
}

static int findLength(int[] arr) {

	int max_len = 1;
	int n = arr.length;
	for (int i = 0; i < n - 1; i++) {
		int mn = arr[i], mx=arr[i];

		for (int j = i + 1; j < n; j++) {
			mn = min(mn, arr[j]);
			mx = max(mx, arr[j]);

			if ((mx - mn) == j - i) {
				max_len = max(max_len, mx-mn+1);
			}

		}
	}
	return max_len;
}

public static void main(String[] args) {

	int[] arr = {1, 56, 58, 57, 90, 92, 94, 93, 91, 45};
	System.out.println("Length of the longest contiguous subarray is " + findLength(arr));

}

}
