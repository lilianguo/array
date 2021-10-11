/*
* 283. Move Zeroes
* Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
*  Note that you must do this in-place without making a copy of the array.
* Input: nums = [0,1,0,3,12]
* Output: [1,3,12,0,0]
 */
class Solution {
  // go through the array, slow
  public void moveZeroes(int[] nums) {
    if (nums == null || nums.length < 2) {
      return;
    }
    int size = nums.length;
    int idx = 0;
    for (int i = 0; i < size; i++) {
      if (nums[i] != 0) {
        nums[idx] = nums[i];
        idx++;
      }
    }
    for (int i = idx; i < size; i++) {
      nums[i] = 0;
    }
  }

}