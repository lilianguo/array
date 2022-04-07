/**
 * 221. Maximal Square
 * Medium
 *
 * Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 *
 *
 *
 * Example 1:
 *
 * Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * Output: 4
 *
 * Example 2:
 *
 * Input: matrix = [["0","1"],["1","0"]]
 * Output: 1
 *
 * Example 3:
 *
 * Input: matrix = [["0"]]
 * Output: 0
 *
 *
 *
 * Constraints:
 *
 *     m == matrix.length
 *     n == matrix[i].length
 *     1 <= m, n <= 300
 *     matrix[i][j] is '0' or '1'.
 *
 *
 */
class Solution {

  /**
   * Complexity Analysis
   *
   *     Time complexity : O(mn). Single pass.
   *
   *     Space complexity : O(mn). Another matrix of same size is used for dp.
   * @param matrix
   * @return
   */
  public int maximalSquare(char[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int[][] dp = new int[m][n];
    int max = 0;
    for (int i = 0; i < m; i++) {
      if (matrix[i][0] == '1' ) {
        dp[i][0] = 1;
        max = 1;
      } else {
        dp[i][0] = 0;
      }
    }
    for (int j = 0; j < n; j++) {
      if (matrix[0][j] == '1') {
        dp[0][j] = 1;
        max = 1;
      } else {
        dp[0][j] = 0;
      }
    }

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (matrix[i][j] == '1') {
          dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
          max = Math.max(max, dp[i][j]);
        }
      }
    }
    return max * max;
  }
}