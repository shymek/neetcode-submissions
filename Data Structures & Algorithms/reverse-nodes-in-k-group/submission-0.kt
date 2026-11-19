/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        if (head == null){
            return null
        }

        val dummy = ListNode(-1)
        dummy.next = head
        var groupPrev: ListNode? = dummy

        while (true) {
            val kth = getKth(groupPrev, k)
            if (kth == null) {
                break
            }

            val groupNext = kth?.next

            // reverse the group
            var previous = kth?.next
            var curr = groupPrev?.next

            while (curr != groupNext) {
                val tmp = curr?.next
                curr?.next = previous
                previous = curr
                curr = tmp
            }

            val tmp: ListNode? = groupPrev?.next
            groupPrev?.next = kth
            groupPrev = tmp
        }

        return dummy.next
    }

    fun getKth(head: ListNode?, k: Int): ListNode? {
        var curr = head
        var counter = k
        while (curr != null && counter > 0) {
            curr = curr?.next
            counter--
        }

        return curr
    }




    // fun reverseList(head: ListNode) {

    // }

    // /**
    // * This will return the new head.
    // * The old head becomes the head of the k size list
    // */
    // fun take(head: ListNode, k: Int): ListNode {
    //     var counter = 1
    //     var curr = head
    //     while(counter < k) {
    //         ++counter
    //         curr = curr?.next
    //     }

    //     val newHead = curr?.next
    //     curr?.next = null
    //     return newHead
    // }
}
