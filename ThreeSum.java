public class ThreeSum {
    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */

     // time O(n^2)
     // space O(1)
    public List<List<Integer>> threeSum(int[] numbers) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (numbers == null || numbers.length < 3) {
            return res;
        }
        Arrays.sort(numbers);
        for (int i = 0;  i < numbers.length - 2; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            // i 指向最小的元素，所以从i+ 1开始, 之前比 numbers[i]小的都遍历过所有组合了
            // tested twoSum(numbers, -numbers[i], 0, res); it would produce duplicate results 
            twoSum(numbers, -numbers[i], i + 1, res);
        }
        return res;
    }

    private void twoSum(int[] numbers, int target, int start, List<List<Integer>> res) {
        int end = numbers.length - 1;
       for (; start < end; end--) {
           while (start < end && numbers[start] + numbers[end] < target) {
            start++;
        }
        if (start < end && numbers[start] + numbers[end] == target)  {
            List<Integer> curr = new ArrayList<>();
            curr.add(-target);
            curr.add(numbers[start]);
            curr.add(numbers[end]);
            res.add(curr);
            while (start < end && numbers[end] == numbers[end - 1]) {
                end--;
            }
        }
       }
    }
}