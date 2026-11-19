/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if(head == null) {
            return head
        }

        var length = 1
        var curr = head
        while (curr?.next != null) {
            ++length
            curr = curr?.next
        }

        if(length == 1) {
            return null
        }

        if (length == n) {
            return head?.next
        }

        curr = head
        val element_to_remove = length - n + 1
        var current_index = 1
        while(current_index < element_to_remove) {
            if (current_index + 1 == element_to_remove) {
                val next_next = curr?.next?.next
                curr?.next = next_next
                return head
            } else {
                curr = curr?.next
                current_index++
            }
        }

        return head
    }
}
