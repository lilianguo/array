/*
125. Valid Palindrome
Easy

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
*/
class ValidPalindrome {
    public boolean isPalindrome(String s) {
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
}