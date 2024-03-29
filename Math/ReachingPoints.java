/**
 * 780. Reaching Points
 * Hard
 *
 * Given four integers sx, sy, tx, and ty, return true if it is possible to convert the point (sx, sy) to the point (tx, ty) through some operations, or false otherwise.
 *
 * The allowed operation on some point (x, y) is to convert it to either (x, x + y) or (x + y, y).
 *
 *
 *
 * Example 1:
 *
 * Input: sx = 1, sy = 1, tx = 3, ty = 5
 * Output: true
 * Explanation:
 * One series of moves that transforms the starting point to the target is:
 * (1, 1) -> (1, 2)
 * (1, 2) -> (3, 2)
 * (3, 2) -> (3, 5)
 *
 * Example 2:
 *
 * Input: sx = 1, sy = 1, tx = 2, ty = 2
 * Output: false
 *
 * Example 3:
 *
 * Input: sx = 1, sy = 1, tx = 1, ty = 1
 * Output: true
 *
 *
 *
 * Constraints:
 *
 *     1 <= sx, sy, tx, ty <= 109
 */
class Solution {
  public boolean reachingPointsII(int sx, int sy, int tx, int ty) {
    if (sx > tx || sy > ty) return false;
    if (sx == tx && sy == ty) return true;
    return reachingPoints(sx + sy, sy, tx, ty) || reachingPoints(sx, sx + sy, tx, ty);
  }

  public boolean reachingPoints(int sx, int sy, int tx, int ty) {
    while (tx >= sx && ty >= sy) {
      if (sx == tx && sy == ty)
        return true;
      if (tx > ty) tx -= ty;
      else ty -= tx;
    }
    return false;
  }
}

class SolutionI {
  public boolean reachingPoints(int sx, int sy, int tx, int ty) {
    while (tx >= sx && ty >= sy) {
      if (tx == ty) break;
      if (tx > ty) {
        if (ty > sy) tx %= ty;
        else return (tx - sx) % ty == 0;
      } else {
        if (tx > sx) ty %= tx;
        else return (ty - sy) % tx == 0;
      }
    }
    return (tx == sx && ty == sy);
  }
}