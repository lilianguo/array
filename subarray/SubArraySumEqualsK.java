/**
 * 560. Subarray Sum Equals K
 * Medium
 *
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 *
 * Example 1:
 *
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 *
 *
 *
 * Constraints:
 *
 *     The length of the array is in range [1, 20,000].
 *     The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 */

public class SubArraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        // solution1: cumulative sum T: O(n^2) S: O(n)
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

    // T:O(n^2)  S: O(1)
    public int subarraySumII(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum=0;
            for (int end = start; end < nums.length; end++) {
                sum+=nums[end];
                if (sum == k)
                    count++;
            }
        }
        return count;
    }

    // T: O(n) S: O(n)
    public int subarraySumIII(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap < Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            // If the cumulative sum(represented by sum[i] for sum up to ith index) up to two indices is the same,
            //the sum of the elements lying in between those indices is zero. Extending the same thought further,
            // if the cumulative sum up to two indices, say i and j is at a difference of k
            // i.e. if sum[i]−sum[j]=k, the sum of elements lying between indices i and j is k.
            // the count represents: ending at index i, how many subarrays equals to k would be found
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}