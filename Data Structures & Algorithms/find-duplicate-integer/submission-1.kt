class Solution {
    fun findDuplicate(nums: IntArray): Int {
        if (nums.size == 2) {
            return nums[0]
        }

        var slow = nums[0]
        var fast = nums[0]

        while(true) {
            slow = nums[slow]
            fast = nums[nums[fast]]

            if (slow == fast) {
                break
            }
        }

        var newSlow = nums[0]
        

        while (true) {
            if (slow == newSlow) {
                return slow
            }
            
            slow = nums[slow]
            newSlow = nums[newSlow]
        }
    }
}
