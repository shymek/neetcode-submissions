class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        // get sizes 
        val m = nums1.size
        val n = nums2.size
        val total = m + n
        // now we need to check if this is even or odd
        // depending on that we will know if we need the last element
        // or last 2 elements
        val isEven = total % 2 == 0
        val newSize = total / 2

        var count = 0
        var prev: Double = -1.0
        var curr: Double = -1.0
        var mIndex = 0
        var nIndex = 0

        while(count <= newSize) {
            var temp = curr
            prev = curr

            // now we need to pick either nums1 or nums2 depending on which
            // is lower, increment its index and increment the counter
            if (mIndex < m && nIndex < n) {
                // both have elements so we compare
                val mVal = nums1[mIndex]
                val nVal = nums2[nIndex]

                if (mVal < nVal) {
                    ++mIndex
                    curr = mVal.toDouble()
                } else {
                    ++nIndex
                    curr = nVal.toDouble()
                }
            } else {
                // now one of them don't have any values so we have two ifs
                if (mIndex < m) {
                    curr = nums1[mIndex].toDouble()
                    ++mIndex
                } else if (nIndex < n) {
                    curr = nums2[nIndex].toDouble()
                    ++nIndex
                }
            }

            ++count
        }

        if (isEven) {
            return (prev + curr) / 2.0
        } else {
            return curr
        }
    }
}
