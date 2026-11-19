class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        // min = 1
        // max = max value from piles
        // then go through array value / k, sum it up and check if it's lower than the current solution which is ma

        var min = 1
        var curr_max = piles[0]
        for (pile in piles) {
            curr_max = max(pile, curr_max)
        }

        var solution = curr_max
        while (min <= curr_max) {
            val mid = (curr_max - min) / 2 + min
            val sum_for_mid = getBenc(mid, piles)

            if (sum_for_mid <= h) {
                solution = min(solution, mid)
            }

            if (sum_for_mid > h) {
                min = mid + 1
            } else {
                curr_max = mid - 1
            }
        }

        return solution
    }

    private fun getBenc(k: Int, piles: IntArray): Long {
        var sum = 0L
        for (pile in piles) {
            sum += (pile + k -1) / k
        }
        return sum
    }
}
