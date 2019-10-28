/*
16. 3Sum Closest
Medium

Share
Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. 
Return the sum of the three integers. You may assume that each input would have exactly one solution.

Example:

Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).


对数组排序，所以a <= b <= c such that a + b + c closest to the target. 这就相当于 a + b closest to (target - c).
所以我们可以在for loop on c， 取最小的diffence between (a + b) 和 （target - c）
最后return 的sum 为 (target - difference) （此处的difference 可为负）
*/
class 3SumClosest {
    public int threeSumClosest(int[] numbers, int target) {
        if(numbers == null || numbers.length == 0) {
            return Integer.MAX_VALUE;
        }
        Arrays.sort(numbers);
        int diff = Integer.MAX_VALUE;
        for(int i = 2; i < numbers.length; i++) {
            int tar = target - numbers[i];
            int distance = explore(numbers, 0, i - 1, tar);
            if(Math.abs(distance) < Math.abs(diff)) {
                diff = distance;
            }
        }
        return (target - diff);
    }
    
    private int explore(int[] num, int start, int end, int target) {
        int difference = Integer.MAX_VALUE;
        while(start < end) {
            int sum = num[start] + num[end];
            if(sum == target) {
                return 0;
            }
            if(Math.abs(difference) > Math.abs(target - sum)) {
                    difference = target - sum;
            }
            if(sum < target) {
                start++;
            } else {
                end--;
            }
        }
        return difference;
    }
}