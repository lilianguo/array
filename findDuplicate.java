import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

class findDuplicate {
    // leetcode 287

    // time O(nlogn)
    // Space complexity : O(1) (or O(n))
    public int findDuplicateNumber(int[] nums) {
        Arrays.sort(nums);
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }
        return res;
    }
    
    // Time complexity : O(n)
    // Space complextiy: O(n)
    public int findDuplicateII(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }
    // Time complexity : O(n)
    // Space complextiy: O(1)
    /*
    什么是快慢指针算法？
    从起点出发，慢指针走一步，快指针走两步。因为有环，所以一定会相遇。
    相遇之后，把其中一根指针拉回起点，重新走，这回快慢指针都各走一步。他们仍然会再次相遇，且相遇点为环的入口。

    时间复杂度是多少？
    时间复杂度是 O(n)O(n) 的。
    */
    public int findDuplicateIII(int[] nums) {
        // Find the intersection point of the two runners.
        int slow = nums[0];
        int fast = nums[0];
        System.out.println("slow is: " + slow);
        System.out.println("fast is :" + fast);
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
            System.out.println("slow is: " + slow);
            System.out.println("fast is :" + fast);
        } while (slow != fast);
        
        // Find the "entrance" to the cycle.
        
        int ptr1 = nums[0];
        int ptr2 = slow;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
            System.out.println("ptr1 is: " + ptr1);
            System.out.println("ptr2 is :" + ptr2);
        }

        return ptr1;
    }
}