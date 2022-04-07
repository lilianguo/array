class Solution {
  public boolean hasPath(int[][] maze, int[] start, int[] destination) {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    if (maze[start[0]][start[1]] == 1) {
      return false;
    }

    Queue<int[]> nexts = new LinkedList<int[]>();
    boolean[][] visited = new boolean[maze.length][maze[0].length];
    nexts.add(start);
    visited[start[0]][start[1]] = true;
    while(!nexts.isEmpty()) {
      int[] curr = nexts.poll();
      if (curr[0] == destination[0] && curr[1] == destination[1])
        return true;
      for (int i = 0; i < 4; i++) {
        int nx = dx[i] + curr[0];
        int ny = dy[i] + curr[1];
        while(isInBound(nx, ny, maze) && maze[nx][ny] == 0) {
          nx += dx[i];
          ny += dy[i];
        }
        if (!visited[nx - dx[i]][ny - dy[i]]) {
          nexts.add(new int[] {nx - dx[i], ny - dy[i]});
          visited[nx - dx[i]][ny - dy[i]] = true;
        }
      }

    }

    return false;


  }



  private boolean isInBound(int x, int y, int[][] maze) {
    int m = maze.length, n = maze[0].length;
    if (x < 0 || x >= m || y < 0 || y >= n)
      return false;
    return true;
  }
}