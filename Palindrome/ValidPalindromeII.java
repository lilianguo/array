/*
680. Valid Palindrome II
Easy

965

67

Favorite

Share
Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True
Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
*/
class ValidPalindromeII {
    // TLE n^2
    public boolean validPalindrome(String s) { 
        if (s == null || s.length() < 3) {
            return true;
        }
        for (int i = 0; i <= s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(s.substring(0, i));
            if (i != s.length()) {
                sb.append(s.substring(i + 1));
            }
            //System.out.println(sb.toString());
            if (isPalindrome( sb.toString())) {
                return true;
            }
        }
        return false;
    }
    private boolean isPalindrome(String s) {
        if(s == null || s.length() == 1) {
            return true;
        }
        int left = 0, right = s.length() - 1;
        while(left < right) {
            char l = s.charAt(left);
            char r = s.charAt(right);

            if (!isAlpha(l) && !isNumber(l)) {
                left++;
                continue;
            }
            if (!isAlpha(r) && !isNumber(r)){
                right--;
                continue;
            }
            l = isAlpha(l) ? Character.toLowerCase(l) : l;
            r = isAlpha(r) ? Character.toLowerCase(r) : r;
            if (l == r) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }
    private boolean isAlpha(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    // Greedy:
    public boolean validPalindromeII(String s) { 
        if (s == null || s.length() < 3) {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                int j = s.length() - 1 - i;
                return (isValid(s, i + 1, j)) || (isValid(s, i, j - 1));
            }
        }
        return true;
    }

    private boolean isValid(String s, int start, int end) {
        while(start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}