/**
 * 46. Permutations
 * Medium
 *
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * Example 2:
 *
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 *
 * Example 3:
 *
 * Input: nums = [1]
 * Output: [[1]]
 *
 *
 *
 * Constraints:
 *
 *     1 <= nums.length <= 6
 *     -10 <= nums[i] <= 10
 *     All the integers of nums are unique.
 */
class Solution {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    if (nums == null || nums.length == 0) return res;
    List<Integer> curr = new ArrayList<>();
    Set<Integer> added = new HashSet<>();
    helper(nums, added, curr, res);
    return res;

  }

  public void helper(int[] nums, Set<Integer> added, List<Integer> curr, List<List<Integer>> res) {
    if (curr.size() == nums.length) {
      res.add(new ArrayList<>(curr));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (!added.contains(nums[i])) {
        curr.add(nums[i]);
        added.add(nums[i]);
        helper(nums, added, curr, res);
        curr.remove(curr.size() - 1);
        added.remove(nums[i]);
      }
    }
    return;
  }
}