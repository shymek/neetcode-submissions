/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val theLists = ArrayList<ListNode?>(lists.size)
        theLists.addAll(lists)
        if (theLists.isEmpty()) {
            return null
        }

        if (theLists.size == 1) {
            return lists[0]
        }

        while(theLists.size > 1) {
            // val newLists: ArrayList<ListNode> = ArrayList()
            // split into pairs...
            while(theLists.size >= 2) {
                // while there are 2 lists, we get the two top lists and merge them and add them back to the list of lists
                val left = theLists.removeAt(0)
                val right = theLists.removeAt(0)
                val merged = mergeTwoLists(left, right)
                theLists.add(merged)
            }
            // so now there are 1 or 0 lists
            return theLists[0]
        }
        return theLists[0]
    }

    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    var left = list1
    var right = list2

    var newHead: ListNode = ListNode(-1)
    var current: ListNode? = newHead

    while(left != null || right != null) {
        if (left == null) {
            current?.next = right
            break
        }
        if (right == null) {
            current?.next = left
            break
        }

        val leftVal = left!!.`val`
        val rightVal = right!!.`val`

            if (leftVal < rightVal) {
                val nextLeft = left?.next
                left?.next = null
                current?.next = left
                left = nextLeft
                current = current?.next
            } else {
                val nextRight = right?.next
                right?.next = null
                current?.next = right
                right = nextRight
                current = current?.next
            }
        }

        return newHead.next
    }
}
