import com.sun.prism.impl.Disposer.Target;

class twoSumII {
    // time: O(n)

    public int[] twoSumI(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return new int[0];
        }
        int start = 0, end = numbers.length - 1;
        while(start < end) {
            if (numbers[start] + numbers[end] == target) {
                // plus one because it's 1 based index
                return new int[] {start + 1, end + 1};
            }
            if (numbers[start] + numbers[end] > target) {
                end--;
            }
            if (numbers[start] + numbers[end] < target) {
                start++;
            }
        }
        return new int[0];
    }

    public int[] twoSumII (int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return new int[1];
        }
        for (int left = 0, right = numbers.length - 1; left < right; right--) {
            while(nums[left] + nums[right] < target) {
                left++;
            }
            if (nums[left] + nums[right] == target) {
                return new int[] {left, right};
            }
        }
        return new int[0];
    }
}
