/**
 * 169. Majority Element
 * Easy
 *
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,3]
 * Output: 3
 *
 * Example 2:
 *
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 *
 *
 *
 * Constraints:
 *
 *     n == nums.length
 *     1 <= n <= 5 * 104
 *     -231 <= nums[i] <= 231 - 1
 *
 */
class Solution {
  // T:O(n)
  public int majorityElement(int[] nums) {
    int len = nums.length;
    int count = len / 2;
    Map<Integer, Integer> countMap = new HashMap<>();
    for (int num : nums) {
      countMap.put(num, countMap.getOrDefault(num, 0) + 1);
      if (countMap.get(num) > count)
        return num;
    }
    return 0;
  }

  // T:O(logn)
  public int majorityElement(int[] nums) {
    Arrays.sort(nums);
    return nums[nums.length / 2];
  }
}