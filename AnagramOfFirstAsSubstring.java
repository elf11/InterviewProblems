/* Given two strings a and b, find whether any anagram of string a is a sub-string of string b. For eg:
if a = xyz and b = afdgzyxksldfm then the program should return true.
 * Keep map of characters in array1 and keep checking if array2 has these characters.
* main string : a b a c a b b and looking for a a b b c when 3rd a is encountered
* we move index to second a and start from there.
 *
 */

import java.util.*;

public class AnagramOfFirstAsSubstring {

	public boolean isSubstring(char[] str1, char[] str2) {

		int index = 0;
		int curLen = 0;
		Map<Character, Integer> count = new HashMap<Character, Integer>();
		for (int i = 0; i < str1.length; i++) {
			if (count.containsKey(str1[i])) {
				int c = count.get(str1[i]);
				count.put(str1[i], c + 1);
			} else {
				count.put(str1[i], 1);
			}
		}
		
		Map<Character, Integer> curCount = new HashMap<Character, Integer>();
		Map<Character, Integer> pos = new HashMap<Character, Integer>();

		while (index < str2.length) {
			// check if the current count of the char "a" in
			// the second/longer string is bigger than the count of the same character in the anagram
			// if yes, then we update the position from where we check the bigger string
			if (containsAndUpdate(curCount, count, str2[index], pos, index)) {
				index++;
				curLen++;
			} else {
				Integer p = pos.get(str2[index]);
				if (p != null) {
					curLen = index - p;
					index = p;
				} else {
					index++;
				}

				curCount.clear();
				pos.clear();
			}

			if (curLen == str1.length)
				return true;
		}

		return false;
	}

	private boolean containsAndUpdate(Map<Character, Integer> curCount, Map<Character, Integer> count, Character ch, Map<Character, Integer> pos, int index) {

	if (count.containsKey(ch)) {
		if (curCount.containsKey(ch)) {
			if (curCount.get(ch) < count.get(ch)) {
				if (curCount.get(ch) == 1)
					pos.put(ch, index);
			
				curCount.put(ch, curCount.get(ch) + 1);
				return true;
			}
		} else {
			curCount.put(ch, 1);
			pos.put(ch, index);
			return true;
		}
	}

	return false;

}
	public static void main(String args[]){
		char str1[] = "aaabccde".toCharArray();
		char str2[] = "tbcdaacaaecbd".toCharArray();
		AnagramOfFirstAsSubstring ana = new AnagramOfFirstAsSubstring();
		System.out.println(ana.isSubstring(str1, str2));
	}
}
