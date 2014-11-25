import java.util.*;

/*
1 2 3 4 -> 1234
  9 8 0 -> 980
  2 1 4 c = 1
*/


class ArrayAddition {

	public int[] addArrays(int[] arr1, int[] arr2) {

		int size1 = arr1.length - 1;
		int size2 = arr2.length - 1;
		int len = Math.max(size1, size2);
		int[] res = new int[len];
		int c = 0;
		int r = 0;
			

		while (size1 >= 0 && size2 >= 0) {
			//System.out.println("len " + len + " size1 " + size1 + " size2 " + size2);
			r = arr1[size1--] + arr2[size2--] + c;
			c = r / 10;
			res[len--] = r % 10;
		}

		while (size1 >= 0) {
			r = arr1[size1--] + c;
			c = r / 10;
			res[len--] = r % 10;
		}

		while (size2 >= 0) {
			r = arr2[size2--] + c;
			c = r / 10;
			res[len--] = r % 10;
		}

		if (c != 0) {

			int[] newRes = new int[len + 1];
			for (int t = len; t > 0; t--)
				newRes[t] = res[t-1];

			newRes[0] = c;
			return newRes;
		}

		return res;

	}

	public static void main(String[] args) {

		int[] arr1 = {9,9,9,9,9,9,9};
		int arr2[] = {1,6,8,2,6,7};
		ArrayAddition aa = new ArrayAddition();
		int[] res = aa.addArrays(arr1, arr2);

		for (int i = 0; i < res.length; i++)
			System.out.print(res[i] + " ");
		

	}


}
