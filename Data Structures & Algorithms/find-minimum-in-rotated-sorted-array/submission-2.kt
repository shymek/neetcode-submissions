class Solution {
    fun findMin(nums: IntArray): Int {
        var lo = 0
        var hi = nums.size - 1

        while (lo < hi) {
            var mid = lo + (hi - lo) / 2
            if (nums[mid] > nums[hi]) {
                // go right
                lo = mid + 1
            } else {
                // go left or mid is it
                hi = mid
            }
        }

        return nums[lo]
    }

}
