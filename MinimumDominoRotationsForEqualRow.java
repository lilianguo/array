import java.util.List;
import java.util.Map;

/*
1007. Minimum Domino Rotations For Equal Row
Medium

In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the i-th domino.  
(A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)

We may rotate the i-th domino, so that A[i] and B[i] swap values.

Return the minimum number of rotations so that all the values in A are the same, or all the values in B are the same.

If it cannot be done, return -1.

 

Example 1:

Input: A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
Output: 2
Explanation: 
The first figure represents the dominoes as given by A and B: before we do any rotations.
If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.

Example 2:

Input: A = [3,5,1,2,3], B = [3,6,3,3,4]
Output: -1
Explanation: 
In this case, it is not possible to rotate the dominoes to make one row of values equal.

 

Note:

    1 <= A[i], B[i] <= 6
    2 <= A.length == B.length <= 20000

*/


class MinimumDominoRotationsForEqualRow {
    public int minDominoRotations(int[] A, int[] B) {
        if ((A == null && B == null) || (A.length == B.length && A.length == 1)) {
            return 0;
        }
        if (A.length != B.length) {
            return -1;
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < A.length; i++ ) {
            countMap.putIfAbsent(A[i], 0);
            countMap.put(A[i], countMap.get(A[i]) + 1);
            countMap.putIfAbsent(B[i], 0);
            countMap.put(B[i], countMap.get(B[i]) + 1);
        }

        List<Integer> candidates = new ArrayList<>();
        for (int key : countMap.keySet()) {
            //System.out.println("countMap.get(key): " + countMap.get(key));
            if (countMap.get(key) >= A.length) {
                if (countMap.get(key) == 2 * A.length) {
                    return 0;
                }
                candidates.add(key);
            }
        }
        // try out possible combinations
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < candidates.size(); i++) {
            int candidate = candidates.get(i);
            //System.out.println("candidate: " + candidate);
            min = Math.min(min, Math.min(getMinRotate(candidate, B, A), getMinRotate(candidate, A, B)));
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private int getMinRotate(int candidate, int[] A, int[] B) {
        int swapCount = 0;
        int i = 0;
        for (; i < A.length; i++) {
            if (A[i] != candidate && B[i] != candidate) {
                return Integer.MAX_VALUE;
            } else if (A[i] == candidate) {
                continue;
            } else {
                swapCount++;
            }
        }
        if (i == A.length && swapCount >= 0) {
            return swapCount;
        }
        return Integer.MAX_VALUE;
    }
}