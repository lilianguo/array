/**
 * 7. Reverse Integer Medium
 *
 * <p>Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the
 * value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 *
 * <p>Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 *
 * <p>Example 1:
 *
 * <p>Input: x = 123 Output: 321
 *
 * <p>Example 2:
 *
 * <p>Input: x = -123 Output: -321
 *
 * <p>Example 3:
 *
 * <p>Input: x = 120 Output: 21
 *
 * <p>Constraints:
 *
 * <p>-231 <= x <= 231 - 1
 */
class Solution {

  /**
   * Approach 1: Pop and Push Digits & Check before Overflow
   * Time Complexity: O(log⁡(x)). There are roughly log⁡10(x) digits in x.
   * Space Complexity: O(1)
   * @param x
   * @return
   */
  public int reverse(int x) {
    if (x == 0) return x;
    int res = 0;
    boolean pos = x > 0 ? true : false;
    int C = Integer.MAX_VALUE / 10;
    int R = Integer.MAX_VALUE % 10;
    x = Math.abs(x);
    while(x > 0) {
      int rem = x % 10;
      x = x / 10;
      if (res > C || (rem > R && res == C)) {
        return 0;
      } else {
        res = 10 * res + rem;
      }
    }
    return pos == true ? res : res * -1;
  }
}