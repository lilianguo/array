import java.util.Map;
import java.util.TreeMap;

/*
1296. Divide Array in Sets of K Consecutive Numbers
Medium

Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into sets of k consecutive numbers
Return True if its possible otherwise return False.

 

Example 1:

Input: nums = [1,2,3,3,4,4,5,6], k = 4
Output: true
Explanation: Array can be divided into [1,2,3,4] and [3,4,5,6].

Example 2:

Input: nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
Output: true
Explanation: Array can be divided into [1,2,3] , [2,3,4] , [3,4,5] and [9,10,11].

Example 3:

Input: nums = [3,3,2,2,1,1], k = 3
Output: true

Example 4:

Input: nums = [1,2,3,4], k = 3
Output: false
Explanation: Each array should be divided in subarrays of size 3.

 

Constraints:

    1 <= nums.length <= 10^5
    1 <= nums[i] <= 10^9
    1 <= k <= nums.length

*/
class DivideArrayInSets {
    public boolean isPossibleDivide(int[] nums, int k) {
        int len = nums.length;
        int uniqMaxCount = len / k;
        if (len % k != 0) {
            return false;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
                if (map.get(num) > uniqMaxCount) {
                    return false;
                }
            }
        }
        while(!map.isEmpty()) {
            int currCount = 1;
            int currNum = map.firstKey();
            //System.out.println(" outer loop currNum is " + currNum);
            map.put(currNum, map.get(currNum) - 1);
            if (map.get(currNum) == 0) {
                System.out.println("removed key is " + currNum);
                map.remove(currNum);
            }
            while(currCount < k) {
                currNum++;
                //System.out.println("currNum is " + currNum);
                if (map.containsKey(currNum)) {
                    map.put(currNum, map.get(currNum) - 1);
                    if (map.get(currNum) == 0) {
                        map.remove(currNum);
                    }
                } else {
                    return false;
                }
                currCount++;
            }
        }
        return true;
    }

    private boolean isPossibleDivideII(int[] nums, int k) { 
        int len = nums.length;
        if (len % k != 0) {
            return false;
        }
        int s = len / k;
        int[] mod = new int[k];
        for (int num : nums) {
            mod[num % k]++;
        }
        for (int m : mod) {
            if (m != s) {
                return false;
            }
        }
        return true;
    }
}