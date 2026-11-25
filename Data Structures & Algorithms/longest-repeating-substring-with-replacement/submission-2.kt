class Solution {
    val map = HashMap<Char, Int>()

    fun characterReplacement(s: String, k: Int): Int {
        if (s.length == 1) {
            return 1
        }
        // I need to track how many different characters I got.
        // But if I remove one character I don't want to remove others.... I mean I can have "AABBCC" so if I skip first A I don't want to remove next A
        // So a map of integers? 

        var l = 0
        var r = 1
        increment(s[l])
        var max = 1

        while(r < s.length) {
            increment(s[r])
            if (isMapValid(k)) {
                max = Math.max(r - l + 1, max)
            }
            while (!isMapValid(k) && l < r) {
                decrement(s[l])
                ++l
            }
            ++r
        }

        return max
    }

    private fun isMapValid(k: Int): Boolean {
        // to count replacements we need to get the current substring length
        // and substract the most frequent character.
        // that has to be less than k
        var mostFrequent = 0
        var sum = 0
        map.values.forEach { it -> 
            mostFrequent = Math.max(mostFrequent, it)
            sum += it
        }
        return (sum - mostFrequent) <= k
    }

    private fun increment(value: Char) {
        map[value] = (map[value] ?: 0) + 1
    }

    private fun decrement(value: Char) {
        // should never have negative?
        map[value] = (map[value] ?: 0) - 1

        if ((map[value] ?: 0) == 0 ){ 
            map.remove(value)
        }
    }

    private fun contains(value: Char): Boolean {
        return map[value] ?: 0 > 0
    }
}
