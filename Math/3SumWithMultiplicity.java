class Solution {
  public int threeSumMulti(int[] arr, int target) {
    /**
     * T: O(n + |target|^2)
     * S: O(100)
     */
    int MOD = 1_000_000_007;
    long[] count = new long[101];
    // O(n)
    for (int num : arr)
      count[num]++;

    long res = 0;

    // find it so that x <= y <= z
    // All different
    // O(target^2)
    for (int x = 0; x < 100; ++x) {
      for (int y = x + 1; y < 100; ++y) {
        int z = target - x - y;
        if (y < z && z <= 100) {
          res += count[x] * count[y] * count[z];
          res %= MOD;
        }
      }
    }

    // x == y != z
    for (int x = 0; x < 100; ++x) {
      int z = target - 2 * x;
      if (x < z && z <= 100) {
        // System.out.println("z == " + z);
        // System.out.println("x == " + x);
        // System.out.println("count[3] " + count[3]);
        // System.out.println("count[0] " + count[0]);
        res += count[x] * (count[x] - 1) * count[z] / 2;
        res %= MOD;
        // System.out.println("res " + res);
      }
    }

    // x != y == z
    for (int z = 0; z <= 100; ++z) {
      int x  = target - 2 * z;
      if ( x >= 0 && x < z && x <= 100)  {
        // System.out.println("z == " + z);
        // System.out.println(count[z]);

        res += count[z] * (count[z]  - 1) * count[x] / 2;
        res %= MOD;
        // System.out.println("dif res " + res);
      }
    }

    // x == y == z
    if (target % 3 == 0) {
      int x = target / 3;
      if (0 <= x && x <= 100) {
        res += count[x] * (count[x] - 1) * (count[x] - 2) / 6;
        res %= MOD;
      }
      // System.out.println("same res " + res);
    }
    return (int) res;
  }
}