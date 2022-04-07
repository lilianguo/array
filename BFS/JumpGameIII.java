/**
 * 1306. Jump Game III
 * Medium
 *
 * Given an array of non-negative integers arr, you are initially positioned at start index of the array. When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.
 *
 * Notice that you can not jump outside of the array at any time.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [4,2,3,0,3,1,2], start = 5
 * Output: true
 * Explanation:
 * All possible ways to reach at index 3 with value 0 are:
 * index 5 -> index 4 -> index 1 -> index 3
 * index 5 -> index 6 -> index 4 -> index 1 -> index 3
 *
 * Example 2:
 *
 * Input: arr = [4,2,3,0,3,1,2], start = 0
 * Output: true
 * Explanation:
 * One possible way to reach at index 3 with value 0 is:
 * index 0 -> index 4 -> index 1 -> index 3
 *
 * Example 3:
 *
 * Input: arr = [3,0,2,1,2], start = 2
 * Output: false
 * Explanation: There is no way to reach at index 1 with value 0.
 *
 *
 *
 * Constraints:
 *
 *     1 <= arr.length <= 5 * 104
 *     0 <= arr[i] < arr.length
 *     0 <= start < arr.length
 */
class Solution {
  public boolean canReach(int[] arr, int start) {
    if (arr[start] == 0) return true;
    Queue<Integer> queue = new LinkedList<>();
    HashSet<Integer> visited = new HashSet<>();
    queue.add(start);
    visited.add(start);
    while(!queue.isEmpty()) {
      int idx = queue.poll();
      // System.out.println("next is " + arr[idx]);
      int n1 = idx + arr[idx];
      int n2 = idx - arr[idx];
      if (!visited.contains(n1) && isInBound(n1, arr)) {
        // System.out.println("n1 in bound " + n1);
        if (arr[n1] == 0) {
          return true;
        } else {
          queue.add(n1);
          visited.add(n1);
        }
      }
      if (!visited.contains(n2) && isInBound(n2, arr)){
        // System.out.println("n2 in bound " + n2);
        if (arr[n2] == 0) {
          return true;
        } else {
          queue.add(n2);
          visited.add(n2);
        }
      }
    }
    return false;
  }

  public boolean isInBound(int idx, int[] arr) {
    int len = arr.length;
    return idx >= 0 && idx < len;
  }
}