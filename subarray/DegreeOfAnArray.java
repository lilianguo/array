/**
 * 697. Degree of an Array Easy
 *
 * <p>Given a non-empty array of non-negative integers nums, the degree of this array is defined as
 * the maximum frequency of any one of its elements.
 *
 * <p>Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has
 * the same degree as nums.
 *
 * <p>Example 1:
 *
 * <p>Input: nums = [1,2,2,3,1] Output: 2 Explanation: The input array has a degree of 2 because
 * both elements 1 and 2 appear twice. Of the subarrays that have the same degree: [1, 2, 2, 3, 1],
 * [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2] The shortest length is 2. So return 2.
 *
 * <p>Example 2:
 *
 * <p>Input: nums = [1,2,2,3,1,4,2] Output: 6 Explanation: The degree is 3 because the element 2 is
 * repeated 3 times. So [2,2,3,1,4,2] is the shortest subarray, therefore returning 6.
 *
 * <p>Constraints:
 *
 * <p>nums.length will be between 1 and 50,000. nums[i] will be an integer between 0 and 49,999.
 */
class Solution {
  public int findShortestSubArray(int[] nums) {
    /**
     * T: O(n) S: O(n)
     */
    Map<Integer, Integer> left = new HashMap<>();
    Map<Integer, Integer> degree = new HashMap<>();
    Map<Integer, Integer> right = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int curr = nums[i];
      if (!left.containsKey(curr)) {
        left.put(curr, i);
      }
      right.put(curr, i);
      degree.put(curr, degree.getOrDefault(curr, 0) + 1);
    }
    int maxD = Collections.max(degree.values());
    int len = nums.length;
    for (int num : degree.keySet()) {
      if (degree.get(num) == maxD) {
        len = Math.min(len, right.get(num) - left.get(num) + 1);
      }
    }
    return len;
  }


  public int findShortestSubArray(int[] nums) {
    /**
     * 边遍历边更新
     * 时间复杂度实际上相同 美遍历一个元素都要比较两次
     */
    Map<Integer, Integer> count = new HashMap<>();
    Map<Integer, Integer> left = new HashMap<>();
    int degree = 0;
    int len = nums.length;
    for (int i = 0; i < nums.length; i++) {
      left.putIfAbsent(nums[i], i);
      count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
      if (count.get(nums[i]) > degree) {
        degree = count.get(nums[i]);
        len = i - left.get(nums[i]) + 1;
      } else if(count.get(nums[i]) == degree) {
        len = Math.min(len, i - left.get(nums[i]) + 1);
      }
    }
    return len;
  }
}