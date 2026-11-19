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
        val map = HashMap<Node, Node>()

        val newHead = Node(head.`val`)
        var currentResult: Node? = newHead
        var currentSource = head
        map[head] = newHead

        while(currentSource != null) {
            if (currentSource?.next != null) {
                val nextNode = currentSource!!.next!!
                val newNextNode = Node(nextNode.`val`)

                map[nextNode] = newNextNode

                currentResult?.next = newNextNode
            }

            currentSource = currentSource?.next
            currentResult = currentResult?.next
        }

        currentSource = head
        currentResult = newHead

        while(currentSource != null) {
            if(currentSource?.random != null) {
                currentResult?.random = map[currentSource!!.random!!]
            }

            currentSource = currentSource?.next
            currentResult = currentResult?.next
        }

        return newHead
    }
}
