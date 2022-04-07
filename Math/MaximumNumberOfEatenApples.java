/**
 * 1705. Maximum Number of Eaten Apples Medium
 *
 * <p>There is a special kind of apple tree that grows apples every day for n days. On the ith day,
 * the tree grows apples[i] apples that will rot after days[i] days, that is on day i + days[i] the
 * apples will be rotten and cannot be eaten. On some days, the apple tree does not grow any apples,
 * which are denoted by apples[i] == 0 and days[i] == 0.
 *
 * <p>You decided to eat at most one apple a day (to keep the doctors away). Note that you can keep
 * eating after the first n days.
 *
 * <p>Given two integer arrays days and apples of length n, return the maximum number of apples you
 * can eat.
 *
 * <p>Example 1:
 *
 * <p>Input: apples = [1,2,3,5,2], days = [3,2,1,4,2] Output: 7 Explanation: You can eat 7 apples: -
 * On the first day, you eat an apple that grew on the first day. - On the second day, you eat an
 * apple that grew on the second day. - On the third day, you eat an apple that grew on the second
 * day. After this day, the apples that grew on the third day rot. - On the fourth to the seventh
 * days, you eat apples that grew on the fourth day.
 *
 * <p>Example 2:
 *
 * <p>Input: apples = [3,0,0,0,0,2], days = [3,0,0,0,0,2] Output: 5 Explanation: You can eat 5
 * apples: - On the first to the third day you eat apples that grew on the first day. - Do nothing
 * on the fouth and fifth days. - On the sixth and seventh days you eat apples that grew on the
 * sixth day.
 *
 * <p>Constraints:in
 *
 * <p>n == apples.length == days.length 1 <= n <= 2 * 104 0 <= apples[i], days[i] <= 2 * 104 days[i]
 * = 0 if and only if apples[i] = 0.
 */
class Solution {
  public int eatenApples(int[] apples, int[] days) {
  // Time complexity for PQ: Time complexity for the methods offer & poll is O(log(n)) and for the peek() it is Constant time O(1)
    PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
    int count = 0;
    int idx = 0;
    while (!pq.isEmpty() ||idx < apples.length) {
      if (idx < apples.length) {
        if (apples[idx] > 0) {
          int cApple = apples[idx];
          int lastValidIdx = idx + days[idx] - 1;
          pq.add(new int[] {cApple, lastValidIdx});
        }
      }
      while(!pq.isEmpty() && pq.peek()[1] < idx) {
        pq.poll();
      }
      if (!pq.isEmpty()) {
        int[] peek = pq.poll();
        peek[0]--;
        count++;
        if (peek[0] > 0)
          pq.add(peek);
      }
      idx++;
    }
    return count;
  }
}