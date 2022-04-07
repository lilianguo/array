/**
 * 47. Permutations II
 * Medium
 *
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,2]
 * Output:
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 *
 * Example 2:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 *
 *
 * Constraints:
 *
 *     1 <= nums.length <= 8
 *     -10 <= nums[i] <= 10
 */
class Solution {
  public List<List<Integer>> permuteUnique(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> res = new ArrayList<>();
    if (nums == null || nums.length == 0) return res;
    List<Integer> curr = new ArrayList<>();
    Map<Integer, Integer> added = new HashMap<>();
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums)
      map.put(num, map.getOrDefault(num, 0) + 1);

    helper(nums, added, map, curr, res);
    return res;
  }

  public void helper(int[] nums, Map<Integer, Integer> added, Map<Integer, Integer> map, List<Integer> curr, List<List<Integer>> res) {
    if (curr.size() == nums.length) {
      res.add(new ArrayList<>(curr));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }

      if (added.getOrDefault(nums[i], 0) < map.get(nums[i])) {
        curr.add(nums[i]);
        added.put(nums[i], added.getOrDefault(nums[i], 0) + 1);
        helper(nums, added, map, curr, res);
        curr.remove(curr.size() - 1);
        added.put(nums[i], added.get(nums[i]) - 1);
      }
    }
    return;
  }
}
