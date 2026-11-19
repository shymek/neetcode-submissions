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
        val previous = last?.previous
        previous?.next = tail
        tail?.previous = previous
        last?.next = null
        last?.previous = null
        map.remove(last!!.key)
    }

    fun addNewOnTop(key: Int, value: Int) {
        val node = Node(key, value)
        addToStart(node)
        map[key] = node
    }

    // fun moveToTop(key: Int) {
    //     val node = map[key]
    //     if (node == head) {
    //         return
    //     }

    //     val previous = node?.previous
    //     val next = node?.next

    //     previous?.next = next
    //     next?.previous = previous

    //     node?.next = null
    //     node?.previous = null

    //     head?.previous = node
    //     node?.next = head
    //     head = node
    // }

    // fun removeLast() {
    //     var current = head
    //     while(current?.next != null) {
    //         current = current?.next
    //     }
    //     if (current != null) {
    //         map.remove(current!!.key)
    //     }

    //     current?.previous?.next = null
    // }

    // fun addNewOnTop(key: Int, value: Int) {
    //     val newNode = Node(key, value, head, null)
    //     head?.previous = newNode
    //     head = newNode
    //     map[key] = newNode
    // }
}

data class Node(val key: Int, var value: Int, var next: Node? = null, var previous: Node? = null)