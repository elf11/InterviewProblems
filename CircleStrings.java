import java.util.*;

public class CircleStrings {

public static boolean check(String[] arr) {

	char[] alpha_start = new char[26];
	char[] alpha_end = new char[26];
	
	for (int i = 0; i < arr.length; i++) {
		if (alpha[arr[i].charAt(0)- 97] >= 0) 
			alpha_start[arr[i].charAt(0) - 97]++;
		//else
		//	alpha_start[arr[i].charAt(0) - 97]--;

		if (alpha_end[arr[i].charAt(arr[i].length() - 1) - 97] >= 0)
			alpha_end[arr[i].charAt(arr[i].length() - 1) - 97]++;

		
		//else
		//	alpha[arr[i].charAt(arr[i].length() - 1) - 97]--;
	}
	int sum = 0;
	for (int i = 0; i < alpha.length; i++) {
		sum += alpha[i];
	}

	if (sum == 0)
		return true;
	else
		return false;
}

public static void main(String[] args) {

	String[] arr = {"for", "geek", "rig", "kaf"};
	String[] arr2 =  {"aab", "bac", "aaa", "cda"};
	String[] arr3 = {"aaa"};
	String[] arr4 = {"aaa", "bbb"};
	System.out.println(check(arr4));

}

}
