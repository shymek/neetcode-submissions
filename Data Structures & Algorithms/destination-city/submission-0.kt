class Solution {
    fun destCity(paths: List<List<String>>): String {
        val destinations = HashSet<String>()
        val froms = HashSet<String>()

        for(path in paths) {
            froms.add(path[0])
            destinations.add(path[1])
        }

        for (from in froms) {
            destinations.remove(from)
        }


        for (x in destinations) {
            return x
        }

        return ""
    }
}
