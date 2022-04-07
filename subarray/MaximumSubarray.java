/**
 * 53. Maximum Subarray Easy
 *
 * <p>Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 *
 * <p>A subarray is a contiguous part of an array.
 *
 * <p>Example 1:
 *
 * <p>Input: nums = [-2,1,-3,4,-1,2,1,-5,4] Output: 6 Explanation: [4,-1,2,1] has the largest sum =
 * 6.
 *
 * <p>Example 2:
 *
 * <p>Input: nums = [1] Output: 1
 *
 * <p>Example 3:
 *
 * <p>Input: nums = [5,4,-1,7,8] Output: 23
 *
 * <p>Constraints:
 *
 * <p>1 <= nums.length <= 105 -104 <= nums[i] <= 104
 *
 * <p>Follow up: If you have figured out the O(n) solution, try coding another solution using the
 * divide and conquer approach, which is more subtle
 *
 *
 */
class Solution {
  public int maxSubArray(int[] nums) {
    // T: O(n) S: O(1) Kadane's Algorithm
    // https://leetcode.com/problems/maximum-subarray/discuss/1595097/JAVA-or-Kadane's-Algorithm-or-Explanation-Using-Image
    int n = nums.length;
    int max = Integer.MIN_VALUE, sum = 0;
    for (int i = 0; i < n; i++) {
      sum += nums[i];
      max = Math.max(max, sum);
      if (sum < 0) sum = 0;
    }
    return max;
  }
}