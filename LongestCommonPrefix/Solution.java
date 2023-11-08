package LeetCode.LongestCommonPrefix;

import java.util.Arrays;
import java.util.Comparator;

class Solution {


    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "\"\"";
        }

        String pref = strs[0];

        for (int i=1; i<strs.length; ++i) {
            int j = 0;
            while (j < pref.length() && pref.charAt(j) == strs[i].charAt(j)) {
                ++j;
            }

            pref = pref.substring(0,j);

            if (pref.isEmpty()) {
                return "\"\"";
            }
        }
        
        return pref;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] strs = {"dog","racecar","car"};

        Arrays.sort(strs, Comparator.comparing(String::length));
        String sortedStrs = Arrays.toString(strs);
        sortedStrs = sortedStrs.substring(1, sortedStrs.length() - 1); // Remove brackets
        strs = sortedStrs.split(", ");

        // Call the longestCommonPrefix function with the sorted array
        String commonPrefix = s.longestCommonPrefix(strs);
        System.out.println(commonPrefix);
    }
}
