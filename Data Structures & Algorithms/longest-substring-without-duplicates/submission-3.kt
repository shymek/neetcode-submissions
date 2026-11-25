class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        if (s == "") {
            return 0
        }
        if (s.length == 1) {
            return 1
        }
        var l = 0
        var r = 1
        var max = 0
        var letters = HashSet<Char>()
        letters.add(s[0])

        while(r < s.length) {
            while(letters.contains(s[r]) && l < r) {
                letters.remove(s[l])
                l++
            }

            letters.add(s[r])
            r++

            max = Math.max(letters.size, max)
        }

        return max
    }
}
