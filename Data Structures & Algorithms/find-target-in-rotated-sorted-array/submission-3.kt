class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var lo = 0
        var hi = nums.size - 1
        var mid = lo + (hi - lo) / 2

        while (lo <= hi) {
            mid = lo + (hi - lo) / 2
            if (nums[mid] == target) {
                return mid
            }
            // are we in the lower or higher part of the array

            if (nums[mid] > nums[hi]) {
                // it means we are in the higher part of the array 
                // so lo ... mid is sorted ->

                if (target >= nums[lo] && target < nums[mid]) {
                    // if it's in the lo.. mid range we go left
                    hi = mid - 1
                } else {
                    // otherwise it's in the other part so we go right
                    lo = mid + 1
                }
            } else {
                // means we are in the "right" or lower part of the array

                // so mid ... hi is sorted -> 
                // so we check if it's in the right sie 
                if (target > nums[mid] && target <= nums[hi]){ 
                    // we go right
                    lo = mid + 1
                } else {
                    hi = mid - 1
                }
            }
        }

        return -1
    }
}
