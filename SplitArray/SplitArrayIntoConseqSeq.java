import java.util.TreeMap;

/*
659. Split Array into Consecutive Subsequences
Medium

Given an array nums sorted in ascending order, return true if and only if you can split it into 1 or more subsequences such that 
    each subsequence consists of consecutive integers and has length at least 3.

 

Example 1:

Input: [1,2,3,3,4,5]
Output: True
Explanation:
You can split them into two consecutive subsequences : 
1, 2, 3
3, 4, 5

Example 2:

Input: [1,2,3,3,4,4,5,5]
Output: True
Explanation:
You can split them into two consecutive subsequences : 
1, 2, 3, 4, 5
3, 4, 5

Example 3:

Input: [1,2,3,4,4,5]
Output: False


Example 4:
[1,2,3,3,4,5]


Example 5:
[1,2,3,3,4,4,5,5]



Constraints:

    1 <= nums.length <= 10000


    

*/
class SplitArrayIntoConseqSeq {
    public boolean isPossible(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        int currNum = map.firstKey();
        int currLen = 1;
        int prevLen = -1;
        int prevEnd = -1;
        if (map.get(currNum) > 1) {
            map.put(currNum, map.get(currNum) - 1);
        } else {
            map.remove(currNum);
        }

        while(!map.isEmpty()) {
            if (!map.containsKey(currNum + 1)) {
                if (currLen >= 3) {
                    prevLen = currLen;
                    prevEnd = currNum;
                    currLen = 1;
                    currNum = map.firstKey();
                    if (map.get(currNum) > 1) {
                        map.put(currNum, map.get(currNum) - 1);
                    } else {
                        map.remove(currNum);
                    }
                    continue;
                } else if (currLen == 2 || prevLen < 5) {

                }
            } else {
                currNum += 1;
                currLen++;
                if (map.get(currNum) > 1) {
                    map.put(currNum, map.get(currNum) - 1);
                } else {
                    map.remove(currNum);
                }                
            }
        }
        return currLen >= 3;
    }
}