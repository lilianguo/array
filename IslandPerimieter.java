/**
 * 463. Island Perimeter Easy
 *
 * <p>You are given row x col grid representing a map where grid[i][j] = 1 represents land and
 * grid[i][j] = 0 represents water.
 *
 * <p>Grid cells are connected horizontally/vertically (not diagonally). The grid is completely
 * surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
 *
 * <p>The island doesn't have "lakes", meaning the water inside isn't connected to the water around
 * the island. One cell is a square with side length 1. The grid is rectangular, width and height
 * don't exceed 100. Determine the perimeter of the island.
 *
 * <p>Example 1:
 *
 * <p>Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]] Output: 16 Explanation: The perimeter
 * is the 16 yellow stripes in the image above.
 *
 * <p>Example 2:
 *
 * <p>Input: grid = [[1]] Output: 4
 *
 * <p>Example 3:
 *
 * <p>Input: grid = [[1,0]] Output: 4
 *
 * <p>Constraints:
 *
 * <p>row == grid.length col == grid[i].length 1 <= row, col <= 100 grid[i][j] is 0 or 1. There is
 * exactly one island in grid.
 */
class Solution {
  // T: O(mn) S:O(1)
  public int islandPerimeter(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
    // To make it faster, we could only check the left and up direction of each cell
    // given we're traversing left to to right and up to bottom, down, right direction will be dealt twice if we traverse 4 directions
    int[] dx = new int[] {-1, 0, 1, 0};
    int[] dy = new int[] {0, 1, 0, -1};
    int sum = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length;j++) {
        if (grid[i][j] == 1) {
          sum += getPerimeter(i, j, dx, dy, grid);
        }
      }
    }
    return sum;
  }

  public int getPerimeter(int x, int y, int[] dx, int[] dy, int[][] grid) {
    int count = 4;
    for (int i = 0; i < dx.length; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      if (nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length && grid[nx][ny] == 1) {
        // And if we only count 2 directions, count -= 2;
        count--;
      }
    }
    return count;
  }
}