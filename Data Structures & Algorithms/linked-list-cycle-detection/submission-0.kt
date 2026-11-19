/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        var r1 = head
        var r2 = head?.next?.next

        while (r1 != null) {
            if (r1 == r2) {
                return true
            }

            r1 = r1?.next
            r2 = r2?.next?.next
        }

        return false
    }
}
