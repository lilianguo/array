import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

class findDuplicate {
    // leetcode 287

    // time O(nlogn)
    // Space complexity : O(1) (or O(n))
    public int findDuplicateNumber(int[] nums) {
        Arrays.sort(nums);
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }
        return res;
    }
    
    // Time complexity : O(n)
    // Space complextiy: O(n)
    public int findDuplicateII(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }
}