/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        if (head == null) {
            return null
        }

        var previous: ListNode? = null
        var curr = head

        while (curr != null) {
            val tmp = curr?.next
            curr?.next = previous
            previous = curr
            curr = tmp
        }

        return previous
    }
}
