/**
 * 1481. Least Number of Unique Integers after K Removals
 * Medium
 *
 * Given an array of integers arr and an integer k. Find the least number of unique integers after removing exactly k elements.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [5,5,4], k = 1
 * Output: 1
 * Explanation: Remove the single 4, only 5 is left.
 *
 * Example 2:
 *
 * Input: arr = [4,3,1,1,3,3,2], k = 3
 * Output: 2
 * Explanation: Remove 4, 2 and either one of the two 1s or three 3s. 1 and 3 will be left.
 *
 *
 *
 * Constraints:
 *
 *     1 <= arr.length <= 10^5
 *     1 <= arr[i] <= 10^9
 *     0 <= k <= arr.length
 */
class Solution {
  public int findLeastNumOfUniqueInts(int[] arr, int k) {
    if (k >= arr.length) return 0;
    PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>( (a, b) ->
        a.getValue().compareTo(b.getValue())
    );
    HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
    for (int num : arr) {
      count.put(num, count.getOrDefault(num, 0) + 1);
    }
    for (Map.Entry<Integer,Integer> entry : count.entrySet())
      pq.add(entry);
    while(k > 0) {
      k -= pq.poll().getValue();
    }
    if (k == 0)
      return pq.size();
    if (k < 0)
      return pq.size() + 1;

    return 0;
  }
}