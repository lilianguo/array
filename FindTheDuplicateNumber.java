/**
 * 287. Find the Duplicate Number Medium
 *
 * <p>Given an array of integers nums containing n + 1 integers where each integer is in the range
 * [1, n] inclusive.
 *
 * <p>There is only one repeated number in nums, return this repeated number.
 *
 * <p>You must solve the problem without modifying the array nums and uses only constant extra
 * space.
 *
 * <p>Example 1:
 *
 * <p>Input: nums = [1,3,4,2,2] Output: 2
 *
 * <p>Example 2:
 *
 * <p>Input: nums = [3,1,3,4,2] Output: 3
 *
 * <p>Constraints:
 *
 * <p>1 <= n <= 105 nums.length == n + 1 1 <= nums[i] <= n All the integers in nums appear only once
 * except for precisely one integer which appears two or more times.
 *
 * <p>Follow up:
 *
 * <p>How can we prove that at least one duplicate number must exist in nums? Can you solve the
 * problem in linear runtime complexity?
 *
 */
class Solution {
  public int findDuplicate(int[] nums) {
    /**
     * T: O(n^2) S: O(1)
     */
    int tmp = nums[0];
    for (int i = 0; i < nums.length - 1; i++) {
      tmp = nums[i];
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[j] == tmp)
          return tmp;
      }
    }
    return tmp;
  }

  public int findDuplicate(int[] nums) {
    // Sorting: T: O(nlogn)
    // S: O(1)
    Arrays.sort(nums);
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == nums[i - 1])
        return nums[i];
    }
    return -1;
  }

  public int findDuplicate(int[] nums) {
    // HashSet
    // T: O(n)
    // S: O(n)
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      if (set.contains(num))
        return num;
      else
        set.add(num);
    }
    return -1;
  }

  public int findDuplicate(int[] nums) {
    // use nums[i] as index
    // traverse to mark each index negative
    // if the index is duplicate, then the nums[nums[i]] should be negative
    // T: O(n) S: O(1)
    int dup = -1;
    for (int i = 0; i < nums.length; i++) {
      int curr = Math.abs(nums[i]);
      if (nums[curr] < 0) {
        dup = curr;
      }
      nums[curr] *= -1;
    }
    return dup;
  }

  public int findDuplicate(int[] nums) {
    // cycle detect
    int fast = nums[0], slow = nums[0];

    do{
      fast = nums[nums[fast]];
      slow = nums[slow];
    } while (fast != slow);

    fast = nums[0];
    while(fast != slow) {
      fast = nums[fast];
      slow = nums[slow];
    }

    return fast;
  }
}
}