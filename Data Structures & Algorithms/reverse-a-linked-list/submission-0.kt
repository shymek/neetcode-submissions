/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        if (head == null) {
            return head
        }
        if (head.next == null) {
            return head
        }

        var nnext = head?.next
        head.next = null
        var new_head = nnext?.next
        nnext?.next = head

        var tail = nnext

        while(new_head != null) {
            var temp_head = new_head
            new_head = temp_head.next
            temp_head.next = tail
            tail = temp_head
        }

        return tail
    }

    fun swapOrder(previous: ListNode?, current: ListNode, next: ListNode): ListNode? {
        val new_next = next.next
        next.next = current
        current.next = previous

        return new_next
    }
}
