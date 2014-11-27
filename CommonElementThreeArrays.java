/* Find common element in 3 sorted arrays (sorted in increasing order)
 * we run a loop and traverse the 3 arrays, x in arr1, y in arr2, z in arr3
 * if x == y == z then return one of them and move forward in all arrays
 * if x < y then move ahead in arr1, x cannot be common element
 * if y < z then move ahead in arr2, y cannot be common element
 * else x> y and y > z then we move ahead in arr3
 * Complexity O(n1 + n2 + n3) and no extra space
 */

import java.util.*;

public class CommonElementThreeArrays {

static void findCommon(int[] arr1, int[] arr2, int[] arr3) {

	int n1 = arr1.length;
	int n2 = arr2.length;
	int n3 = arr3.length;

	int i = 0, j = 0, k = 0;

	while (i < n1 && j < n2 && k < n3) {

		if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
			System.out.print(arr1[i] + " ");
			i++; j++; k++;
		} else if (arr1[i] < arr2[j]) {
			i++;
		} else if (arr2[j] < arr3[k]) {
			j++;
		} else
			k++;

	}

}

public static void main(String[] args) {

	int[] arr1 = {1, 5, 10, 20, 40, 80};
	int[] arr2 = {6, 7, 20, 80, 100};
	int[] arr3 = {3, 4, 15, 20, 30, 70, 80, 120};

	System.out.println("Common elements are : ");
	findCommon(arr1, arr2, arr3);

}


}
