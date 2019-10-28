// https://leetcode.com/problems/two-sum/submissions/
// 1. Two Sum
class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (map.containsKey(tmp)) {
                return new int[] {map.get(tmp), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No solution");
    }
}