import java.util.*;

public class AlternatingArray {

public static void rightRotate(int[] arr, int outofplace, int cur) {

	int tmp = arr[cur];
	for (int i = cur; i > outofplace; i--)
		arr[i] = arr[i-1];
	arr[outofplace] = tmp;
}

public static void rearrange(int[] arr) {

	int n = arr.length;
	int outofplace = -1;

	for (int index = 0; index < n; index++) {

		if (outofplace >= 0) {
		// find the item which must be moved into the out-of-place
                // entry if out-of-place entry is positive and current
                // entry is negative OR if out-of-place entry is negative
                // and current entry is negative then right rotate
                //
                // [...-3, -4, -5, 6...] -->   [...6, -3, -4, -5...]
                //      ^                          ^
                //      |                          |
                //     outofplace      -->      outofplace
                //
			if (((arr[index] >= 0) && (arr[outofplace] <0)) ||
				((arr[index] < 0) && (arr[outofplace] >= 0))) {

			rightRotate(arr, outofplace, index);

			// the new out-of-place entry is now 2 steps ahead
			if (index - outofplace > 2)
				outofplace = outofplace + 2;
			else
				outofplace = -1;
		}

		}


	// if no entry has been flagged out of place
	if (outofplace == -1) {

	//check if current entry is outofplace
		if (((arr[index] >= 0) && (!(index & 0x01))) ||
		((arr[index] < 0) && (index & 0x01)))
			outofplace = index;
	}

	}

}

public static void main(String[] args) {
	int[] arr = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
	for (int i = 0; i < arr.length; i++)
		System.out.print(i + " ");

	System.out.println();

	rearrange(arr);

	for (int i = 0; i < arr.length; i++)
		System.out.print(i + " ");

	System.out.println();
}


}
