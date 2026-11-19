class LRUCache(capacity: Int) {

    val map = HashMap<Int, Node>()
    val capacity: Int = capacity
    var size: Int = 0
    val head: Node = Node(0, 0, null, null)
    val tail: Node = Node(0, 0, null, null)

    init {
        head.next = tail
        tail.previous = head
    }

    fun get(key: Int): Int {
        if (map.containsKey(key)){ 
            moveToTop(key)
            return map[key]!!.value
        }
        return -1
    }

    fun put(key: Int, value: Int) {
        if (map.containsKey(key)) {
                moveToTop(key)
                val node = map[key]
                node!!.value = value
        } else {
            // new key
            if (size >= capacity) {
                removeLast()
                addNewOnTop(key, value)
            } else {
                addNewOnTop(key, value)
                ++size
            }
        }
    }

    fun moveToTop(key: Int) {
        val node = map[key]
        unlink(node!!)
        addToStart(node)
    }

    fun unlink(node: Node) {
        val previous = node.previous
        val next = node.next
        node.previous = null
        node.next = null
        previous?.next = next
        next?.previous = previous
    }

    fun addToStart(node: Node) {
        val headNext = head.next
        head.next = node
        headNext?.previous = node
        node?.previous = head
        node?.next = headNext
    }

    fun removeLast() {
        if (size < 1) {
            return
        }
        val last = tail.previous
        unlink(last!!)
        map.remove(last!!.key)
    }

    fun addNewOnTop(key: Int, value: Int) {
        val node = Node(key, value)
        addToStart(node)
        map[key] = node
    }
}

data class Node(val key: Int, var value: Int, var next: Node? = null, var previous: Node? = null)