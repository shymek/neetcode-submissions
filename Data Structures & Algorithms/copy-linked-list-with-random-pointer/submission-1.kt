/*
// Definition for a Node.
class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}
*/

class Solution {
    fun copyRandomList(head: Node?): Node? {
        if (head == null) return null
        if (head?.next == null && head?.random == null) return Node(head!!.`val`!!)
        val arrayList: ArrayList<Node> = ArrayList()
        val newArrayList: ArrayList<Node> = ArrayList()

        val newHead = Node(head.`val`)
        var currentResult: Node? = newHead
        newArrayList.add(newHead)
        arrayList.add(head)
        var currentSource = head
        while(currentSource?.next != null) {
            val nextSource = currentSource!!.next!!
            arrayList.add(nextSource)
            val newNode = Node(nextSource.`val`)
            newArrayList.add(newNode)
            currentSource = nextSource

            currentResult?.next = newNode
            currentResult = newNode
        }
        currentResult = newHead
        currentSource = head
        while(currentSource != null) {
            if (currentSource?.random != null) {
                val thisRandom = currentSource!!.random!!
                val thisRandomIndex = arrayList.indexOf(thisRandom)
                if (thisRandomIndex >= 0) {
                    currentResult?.random = newArrayList[thisRandomIndex]
                }
            }

            // increment
            currentSource = currentSource?.next
            currentResult = currentResult?.next

        }

        return newHead
    }
}
