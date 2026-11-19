/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reverseList(head: ListNode?): ListNode? {
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
