class TimeMap() {
    val map = HashMap<String, ArrayList<Node>>()

    fun set(key: String, value: String, timestamp: Int) {
        if (map.containsKey(key)) { 
            val list = map[key]
            list?.add(Node(timestamp, value))
        } else {
            val list = ArrayList<Node>()
            list.add(Node(timestamp, value))
            map[key] = list
        }
    }

    fun get(key: String, timestamp: Int): String {
        if (!map.containsKey(key)) {
            return ""
        }
        val list = map[key]!!

        var lo = 0
        var hi = list.size - 1
        var mid = lo + (hi - lo) / 2

        if (timestamp < list[lo].timestamp) {
            return ""
        }

        if (timestamp > list[hi].timestamp) {
            return list[hi].feel
        }

        while (lo <= hi){
            mid = lo + (hi - lo) / 2
            val midEl = list[mid]!!
            if (midEl.timestamp == timestamp) {
                return midEl.feel
            }

            if (timestamp > midEl.timestamp) {
                lo = mid + 1
            } else {
                hi = mid - 1
            }
        }

        return list[hi].feel
    }

    class Node(val timestamp: Int, val feel: String)
}
