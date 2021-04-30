/*

5. Longest Palindromic Substring
Medium

Given a string s, find the longest palindromic substring in s. 
You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example 2:

Input: "cbbd"
Output: "bb"


*/
class LongestPalindromicSubstring {

    // dp: time O(n^2)
    //     space O(n^2)
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int n = s.length();
        boolean[][] isPalindromic = new boolean[n][n];
        int longest  = 1, start = 0;

        // check if there's a valid palindrome substring of length 2
        // initialize the dp matrix isPalindromic with substring of length 1 and 2
        for (int end = 0; end < n; end++) {
            isPalindromic[i][i] = true;
            if (i < n - 1 && s.charAt(i) == s.charAt(i + 1)){
                isPalindromic[i][i+1] = true;
                longest = 2;
                start = i;
            }
        }

        // from right to left, check every start index with substring of length >= 2
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                isPalindromic[i][j] = isPalindromic[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                if (isPalindromic[i][j] && j - i + 1 > longest) {
                    longest = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + longest);
    }

    // center expand: using every index as center(odd length palin) or start of center(even length palin) and search for maxi
    // time O(n^2)
    // space O(1)
    public String longestPalindromeII(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int n = s.length();
        int longest = 1, start = 0;
        for (int i = 0; i < n; i++) {
            // odd length palin
            int len1 = expand(s, i, i);
            // even length palin
            int len2 = expand(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > longest) {
                longest = len;
                // (len - 1) / 2 because center could be two identical character 
                start = i - (len - 1) / 2;
            }
        }
        return s.substring(start, longest + start);
    }
    
    private int expand(String s, int left, int right) {
        int len = 1;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            len = Math.max(len, right - left + 1);
            left--;
            right++;
        }
        return len;
    }
}