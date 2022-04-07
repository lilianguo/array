/**
 * 505. The Maze II
 * Medium
 *
 * There is a ball in a maze with empty spaces (represented as 0) and walls (represented as 1). The ball can go through the empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.
 *
 * Given the m x n maze, the ball's start position and the destination, where start = [startrow, startcol] and destination = [destinationrow, destinationcol], return the shortest distance for the ball to stop at the destination. If the ball cannot stop at destination, return -1.
 *
 * The distance is the number of empty spaces traveled by the ball from the start position (excluded) to the destination (included).
 *
 * You may assume that the borders of the maze are all walls (see examples).
 *
 *
 *
 * Example 1:
 *
 * Input: maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], start = [0,4], destination = [4,4]
 * Output: 12
 * Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.
 * The length of the path is 1 + 1 + 3 + 1 + 2 + 2 + 2 = 12.
 *
 * Example 2:
 *
 * Input: maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], start = [0,4], destination = [3,2]
 * Output: -1
 * Explanation: There is no way for the ball to stop at the destination. Notice that you can pass through the destination but you cannot stop there.
 *
 * Example 3:
 *
 * Input: maze = [[0,0,0,0,0],[1,1,0,0,1],[0,0,0,0,0],[0,1,0,0,1],[0,1,0,0,0]], start = [4,3], destination = [0,1]
 * Output: -1
 *
 *
 *
 * Constraints:
 *
 *     m == maze.length
 *     n == maze[i].length
 *     1 <= m, n <= 100
 *     maze[i][j] is 0 or 1.
 *     start.length == 2
 *     destination.length == 2
 *     0 <= startrow, destinationrow <= m
 *     0 <= startcol, destinationcol <= n
 *     Both the ball and the destination exist in an empty space, and they will not be in the same position initially.
 *     The maze contains at least 2 empty spaces.
 */
class Solution {
  // difference with I is to have a minMatrix that keep update the min steps for each point
  // in the end, if destination is not updated at all ,it's not reachable, otherwise, it's the answer
  public int shortestDistance(int[][] maze, int[] start, int[] destination) {
    int m = maze.length, n = maze[0].length;
    int[][] minMatrix = new int[m][n];

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    for (int[] row : minMatrix)
      Arrays.fill(row, Integer.MAX_VALUE);

    int desX = destination[0], desY = destination[1];
    int starX = start[0], starY = start[1];
    minMatrix[starX][starY] = 0;
    Queue<int[]> queue = new LinkedList<>();
    queue.add(start);

    while(!queue.isEmpty()) {
      int[] curr = queue.poll();
      for (int i = 0; i < dx.length; i++) {
        int nx = dx[i] + curr[0];
        int ny = dy[i] + curr[1];
        int count = 0;
        while(nx >= 0 && ny >= 0 && nx < m && ny < n && maze[nx][ny] == 0) {
          count++;
          nx += dx[i];
          ny += dy[i];
        }
        if (minMatrix[nx - dx[i]][ny - dy[i]] > minMatrix[curr[0]][curr[1]] + count) {
          minMatrix[nx - dx[i]][ny - dy[i]] = minMatrix[curr[0]][curr[1]] + count;
          queue.add(new int[] {nx - dx[i], ny - dy[i]});
        }

      }
    }

    return minMatrix[desX][desY] == Integer.MAX_VALUE ? -1 : minMatrix[desX][desY];
  }
}