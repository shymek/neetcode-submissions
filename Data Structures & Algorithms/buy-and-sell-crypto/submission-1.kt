class Solution {
    fun maxProfit(prices: IntArray): Int {
        var l = 0
        var r = 1

        if (prices.size < 2) {
            return 0
        }
        if (prices.size <= 2) {
            return Math.max(prices[1] - prices[0], 0)
        }

        var curr_max = 0
        while(r < prices.size) {
            if (prices[r] < prices[l]) {
                // found a cheaper buy day
                l = r
            } else {
                curr_max = Math.max(prices[r] - prices[l], curr_max)
            }
            r++
        }

        return curr_max
    }
}
