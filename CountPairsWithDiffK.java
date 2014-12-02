

// it can be also be solved with binary search in O(nlogn)
/* BinarySearch solution
1) Initialize count as 0
2) Sort all numbers in increasing order.
3) Remove duplicates from array.
4) Do following for each element arr[i]
   a) Binary Search for arr[i] + k in subarray from i+1 to n-1.
   b) If arr[i] + k found, increment count. 
5) Return count. 
*/


// this is a solution in O(n) average time
// we might have duplicates, but we need to count the pairs only once
import java.util.*;

public class CountPairsWithDiffK {

	public int countPairsWithDiffK(int[] arr, int k) {

		int count = 0;

		Set<Integer> hm = new HashSet<Integer>();

		for (int i = 0; i < arr.length; i++) {
			if (!hm.contains(arr[i]))
				hm.add(arr[i]);	
		}

		//Iterator it = hm.iterator();

		//while (it.hasNext()) {
		//	Object val = it.next();
		//	System.out.print(val + " ");
		//}

		for (int i = 0; i < arr.length; i++) {
			if (hm.contains(arr[i] - k))
				count++;
			

			if (hm.contains(arr[i] + k))
				count++;

			hm.remove(arr[i]);
		}

		return count;
	}


	public static void main(String[] args) {
		CountPairsWithDiffK cp = new CountPairsWithDiffK();
		int[] arr = {8, 12, 16, 4, 0, 20};
		System.out.println(cp.countPairsWithDiffK(arr, 4));
	}


}
