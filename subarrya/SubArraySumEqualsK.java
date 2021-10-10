
/*
560. Subarray Sum Equals K
Medium

Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:

Input:nums = [1,1,1], k = 2
Output: 2

 

Constraints:

    The length of the array is in range [1, 20,000].
    The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].


*/

public class SubArraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        // solution1: start from each index traverse subarray
        // solution2: cumulative sum
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i =1; i <= nums.length; i++) {
            sum[i] =  sum[i - 1] + nums[i - 1];
            System.out.println("sum[i]: " + sum[i]);
        }
        int count = 0;
        for (int s = 0; s <= nums.length; s++) {
            for (int e = s + 1; e <= nums.length; e++) {
                if (sum[e] - sum[s] == k) {
                    count++;
                }
            }
        }
        return count;
    }
}