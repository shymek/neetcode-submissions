class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var min = 0
        var max = nums.size - 1
        var mid = max / 2

        while(min <= max) {
            if (nums[mid] > target) {
                max = mid - 1
            } else if (nums[mid] < target) {
                min = mid + 1
            } else {
                return mid
            }

            mid = (max - min) / 2 + min
        }

        return -1
    }
}

