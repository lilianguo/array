/**
 * 1046. Last Stone Weight Easy
 *
 * <p>You are given an array of integers stones where stones[i] is the weight of the ith stone.
 *
 * <p>We are playing a game with the stones. On each turn, we choose the heaviest two stones and
 * smash them together. Suppose the heaviest two stones have weights x and y with x <= y. The result
 * of this smash is:
 *
 * <p>If x == y, both stones are destroyed, and If x != y, the stone of weight x is destroyed, and
 * the stone of weight y has new weight y - x.
 *
 * <p>At the end of the game, there is at most one stone left.
 *
 * <p>Return the smallest possible weight of the left stone. If there are no stones left, return 0.
 *
 * <p>Example 1:
 *
 * <p>Input: stones = [2,7,4,1,8,1] Output: 1 Explanation: We combine 7 and 8 to get 1 so the array
 * converts to [2,4,1,1,1] then, we combine 2 and 4 to get 2 so the array converts to [2,1,1,1]
 * then, we combine 2 and 1 to get 1 so the array converts to [1,1,1] then, we combine 1 and 1 to
 * get 0 so the array converts to [1] then that's the value of the last stone.
 *
 * <p>Example 2:
 *
 * <p>Input: stones = [1] Output: 1
 *
 * <p>Constraints:
 *
 * <p>1 <= stones.length <= 30 1 <= stones[i] <= 1000
 */
class Solution {
  public int lastStoneWeight(int[] stones) {
    /**
     * T: O(N + NlongN) == O(N * logN)
     * S: O(N)
     */
    if (stones == null) return 0;
    if (stones.length == 1) return stones[0];

    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
    // O(n)
    for (int stone : stones) pq.add(stone);

    // worst case O(NlogN)
    while(pq.size() > 1) {
      // pull takes O(logN) where N is number of stones in pq
      int y = pq.poll();
      int x = pq.poll();
      // System.out.println("x == " + x + " y == "  + y);
      if (x != y) {
        pq.add(y - x);
      }
    }
    return pq.size() == 0 ? 0 : pq.poll();
  }
}