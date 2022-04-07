/**
 * 128. Longest Consecutive Sequence
 * Medium
 *
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 *
 * Example 2:
 *
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 *
 *
 *
 * Constraints:
 *
 *     0 <= nums.length <= 105
 *     -109 <= nums[i] <= 109
 */
class Solution {

  /**
   *

   Time complexity : O(nlgn)O(nlgn)O(nlgn).

   The main for loop does constant work nnn times, so the algorithm's time complexity is dominated by the invocation of sort, which will run in O(nlgn)O(nlgn)O(nlgn) time for any sensible implementation.

   Space complexity : O(1)O(1)O(1) (or O(n)O(n)O(n)).

   For the implementations provided here, the space complexity is constant because we sort the input array in place. If we are not allowed to modify the input array, we must spend linear space to store a sorted copy.

   * @param nums
   * @return
   */
  public int longestConsecutive(int[] nums) {

    if (nums == null || nums.length < 1) return 0;
    PriorityQueue<Integer> q = new PriorityQueue<Integer>();
    for (int num : nums) q.add(num);
    int max = 1;
    int curLen = 1;
    int curr = q.poll();
    while(!q.isEmpty()) {
      int next = q.poll();
      if (next - curr == 1) {
        curLen++;
      } else if (next - curr > 1){
        curLen = 1;
      }
      max = Math.max(max, curLen);
      curr = next;
    }
    return max;
  }

  /**
   *

   Time complexity : O(n)

   Although the time complexity appears to be quadratic due to the while loop nested within the for loop, closer inspection reveals it to be linear. Because the while loop is reached only when currentNum marks the beginning of a sequence (i.e. currentNum-1 is not present in nums), the while loop can only run for nnn iterations throughout the entire runtime of the algorithm. This means that despite looking like O(n⋅n)O(n \cdot n)O(n⋅n) complexity, the nested loops actually run in O(n+n)=O(n)O(n + n) = O(n)O(n+n)=O(n) time. All other computations occur in constant time, so the overall runtime is linear.

   Space complexity : O(n)

   In order to set up O(1)O(1)O(1) containment lookups, we allocate linear space for a hash table to store the O(n)O(n)O(n) numbers in nums. Other than that, the space complexity is identical to that of the brute force solution.

   * @param nums
   * @return
   */
  public int longestConsecutive(int[] nums) {
    Set<Integer> num_set = new HashSet<Integer>();
    for (int num : nums) {
      num_set.add(num);
    }

    int longestStreak = 0;

    for (int num : num_set) {
      if (!num_set.contains(num-1)) {
        int currentNum = num;
        int currentStreak = 1;

        while (num_set.contains(currentNum+1)) {
          currentNum += 1;
          currentStreak += 1;
        }

        longestStreak = Math.max(longestStreak, currentStreak);
      }
    }

    return longestStreak;
  }

}