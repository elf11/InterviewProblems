/* Search in an almost sorted array; given an array that is sorted but
 * after sorting some elements are moved to either of the adjacent pos
 * e.g. arr[i] may be present at arr[i+1] or arr[i-1]
 * We can use binary search to do it in O(logn) time
 * The idea is to compare the key with middle 3 elements, if present then return the index. If not present, then compare the key with middle element to decide whether to go in left half or right half. Comparing with middle element is enough as all the elements after mid+2 must be greater than element mid and all elements before mid-2 must be smaller than mid element.
 */

import java.util.*;

class AlmostSorted {

public static int binarySearch(int[] arr, int l, int r, int x) {

	if (r >= l) {

		int mid = l + (r - l) /2;
		if (arr[mid] == x) return mid;
		if (arr[mid] > l && arr[mid-1] == x) return (mid - 1);
		if (arr[mid] < r && arr[mid+1] == x) return (mid + 1);

		if (arr[mid] > x)
			return binarySearch(arr, l, mid-2, x);

		return binarySearch(arr, mid+2, r, x);
	}
	return -1;
}

public static void main(String[] args) {

	int[] arr = {3, 2, 10, 4, 40};
	int x = 4;
	int n = arr.length;
	int res = binarySearch(arr, 0, n-1, x);
	if (res == -1)
		System.out.println("Element is not present in array");
        else
		System.out.println("Element is present at index " + res);
}

}
