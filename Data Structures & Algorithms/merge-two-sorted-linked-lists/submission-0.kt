/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var l1 = list1
        var l2 = list2
        if (l1 == null)
            return list2
        if (l2 == null) 
            return list1

        var new_head: ListNode? = null
        var current: ListNode? = null
        
        if(l1.`val` <= l2.`val`) {
            new_head = l1
            l1 = l1.next
        }
        else if(l2!!.`val` <= l1!!.`val`) {
            new_head = l2
            l2 = l2.next
        }

        current = new_head

        while(l1 != null || l2 != null) {
            if(l1?.`val` ?: 9999999 <= l2?.`val` ?: 9999999) {
                current?.next = l1
                current = current?.next
                l1 = l1?.next
            } else if (l2?.`val` ?: 9999999 <= l1?.`val` ?: 9999999) {
                current?.next = l2
                current = current?.next
                l2 = l2?.next
            }
        }

        return new_head
    }
}
