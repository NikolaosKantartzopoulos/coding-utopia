package problems;

import java.util.HashSet;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
// Space O(n) - Time O(n)
//Sliding Window

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0,  max = 0;
        for (int right = 0; right < s.length() ; right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            max = Math.max(max, right - left + 1);
        }
        return  max;
    }
}
