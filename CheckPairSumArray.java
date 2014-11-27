/* Given an array a[] and a number x, check for pair in a[] such that the sum of the pair is x
 * Sol1: sort the array in increasing order O(logn) for MergeSort/HeapSort; initialize leftIndex = 0; rightIndex = arr.length - 1; loop while leftIndex < rightIndex; check if(arr[leftIndex] + arr[rightIndex] == sum) return 1; check if(a[leftIndex] + arr[rightIndex] < sum) then leftIndex++; else rightIndex --; return 0;
 * Sol2: if we know the range of the numbers; then we use another array of size range; and check if range[x - a[i]] is set, if it's set then we have a pair; otherwise we set it
 *
 *
 */

public class CheckPairSumArray {

public boolean checkPairSum(int[] arr, int sum, int range) {

	int n = arr.length;
	int[] rangeArr = new int[range];
	int temp;

	for (int i = 0; i < n; i++) {
		temp = sum - arr[i];		
		if (temp >= 0 && rangeArr[temp] == 1)
			return true;
		else
			rangeArr[arr[i]] = 1;
	}
	return false;
}

public static void main(String[] args) {

	int arr[] = {1, 4, 45, 6, 10, 8};
	CheckPairSumArray cpsa = new CheckPairSumArray();
	int sum = 25;

	boolean res = cpsa.checkPairSum(arr, sum, 10000);

	if (res)
		System.out.println("Yes");
	else
		System.out.println("No");

}

}
