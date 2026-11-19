/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reorderList(head: ListNode?): Unit {
        if (head == null){
            return
        }
        if (head.next == null){
            return
        }
        if (head?.next?.next == null) {
            return
        }

        // find half

        var list1 = head
        var list2 = head.next
        var list1_head = list1
        var list2_head = list2

        while(list2 != null && list2.next != null) {
            list1 = list1?.next
            list2 = list2?.next?.next
        }

        list2_head = list1?.next
        list1?.next = null
        list2_head = reverseList(list2_head!!)
        list2 = list2_head
        list1 = head
        var list1_next = list1?.next
        var list2_next = list2_head?.next
        var new_l1_next: ListNode? = null

        while(list1_next != null || list2 != null) {
            list1?.next = list2
            list1 = list1?.next
            new_l1_next = list1_next?.next
            list1?.next = list1_next
            list1_next = new_l1_next
            list1 = list1?.next
            list2 = list2_next
            list2_next = list2?.next
        }
        

        // print(list1?.`val`)
    }

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

    fun printList(head: ListNode): Unit {
        var current: ListNode? = head
        while (current != null) {
            print(current.`val`)
            print(", ")
            current = current?.next
        }
        println()
    }
}
