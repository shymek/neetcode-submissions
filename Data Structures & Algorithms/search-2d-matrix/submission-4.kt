class Solution {
    var length = 0
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        length = matrix[0].size
        when(matrix.size) {
            1 -> {
                if (length == 1) {
                    return matrix[0][0] == target
                }
            }
            0 -> return false
        }
        var min = 0
        var max = matrix.size * matrix[0].size - 1
        var mid = max / 2

        // translate index to x, y -> 
        while(min <= max) {
            mid = (max - min) / 2 + min
            val (x, y) = getXY(mid)

            val value = matrix[x][y]
            if (value < target) {
                min = mid + 1
            } else if (value > target) {
                max = mid - 1
            } else {
                return true
            }
        }

        return false
    }

    fun getXY(index: Int): Pair<Int, Int> {
        val x = index/length
        val y = index - (x * length)

        return Pair(x, y)
    }
}
