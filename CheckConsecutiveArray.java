/* Checkif elements in array are consecutive O(n)
 * check if max - min + 1 = n (nr of elements)
 * check if all elements are distinct
 */

public class CheckConsecutiveArray {


public int max(int[] arr) {
	int max = Integer.MIN_VALUE;
	for (int i = 0; i < arr.length; i++)
		if (max < arr[i])
			max = arr[i];
	return max;
}

public int min(int[] arr) {
	int min = Integer.MAX_VALUE;
	for (int i = 0; i < arr.length; i++)
		if (min > arr[i])
			min = arr[i];

	return min;
}

public boolean checkConsecutive(int[] arr) {

	// we use a visite array of length n; where we check if we
	// have seen the value previously

	int n = arr.length;

	int minV = min(arr);
	int maxV = max(arr);

	if (maxV - minV + 1 != n)
		return false;
	else {
		int[] visited = new int[n];
		for (int i = 0; i < n; i++) {
			if (visited[arr[i] - minV] == 1)
				return false;
			else
				visited[arr[i] - minV] = 1;
		}
	}

	return true;
}

public static void main(String[] args) {

	int[] arr = {5, 2, 3, 5, 4};

	CheckConsecutiveArray ca = new CheckConsecutiveArray();

	boolean cons = ca.checkConsecutive(arr);

	if (cons)
		System.out.println("Yes");
	else
		System.out.println("No");

}

}
