/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var l1C = l1
        var l2C = l2

        var num1 = 0
        var num2 = 0
        var dummy = ListNode(0)
        var currentN = dummy
        var rest = 0

        while(l1C != null || l2C != null) {
            num1 = 0
            num2 = 0

            if(l1C != null) {
                num1 = l1C.`val`
                l1C = l1C?.next
            }

            if (l2C != null) {
                num2 = l2C.`val`
                l2C = l2C?.next
            }

            var thisSum = num1 + num2 + rest
            rest = 0
            if (thisSum >= 10) {
                rest = thisSum / 10
                thisSum -= rest * 10
            }

            currentN!!.next = ListNode(thisSum)
            currentN = currentN.next!!
        }

        if (rest > 0) {
            currentN!!.next = ListNode(rest)
        }

        return dummy.next
    }
}
