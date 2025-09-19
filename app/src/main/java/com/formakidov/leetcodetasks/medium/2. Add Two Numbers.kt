package com.formakidov.leetcodetasks.medium

/*
2. Add Two Numbers
Solved
Medium
Topics
premium lock icon
Companies
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 

Example 1:


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 

Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
*/

//class ListNode(var `val`: Int) {
//    var next: ListNode? = null
//}

class Solution2 {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val prevToHead = ListNode(0)
        var carry = 0
        var p = l1
        var q = l2
        var curr = prevToHead

        while (p != null || q != null || carry != 0) {
            val sum = (p?.`val` ?: 0) + (q?.`val` ?: 0) + carry
            val remainder = sum % 10
            carry = sum / 10
            curr.next = ListNode(remainder)
            curr = curr.next!!
            p = p?.next
            q = q?.next
        }

        return prevToHead.next
    }
}

private fun createListNode(values: IntArray): ListNode? {
    if (values.isEmpty()) return null
    val head = ListNode(values[0])
    var current = head
    for (i in 1 until values.size) {
        current.next = ListNode(values[i])
        current = current.next!!
    }
    return head
}

private fun listNodeToString(node: ListNode?): String {
    if (node == null) return "[]"
    val sb = StringBuilder("[")
    var current = node
    while (current != null) {
        sb.append(current.`val`)
        if (current.next != null) {
            sb.append(", ")
        }
        current = current.next
    }
    sb.append("]")
    return sb.toString()
}

private fun areListNodesEqual(l1: ListNode?, l2: ListNode?): Boolean {
    var c1 = l1
    var c2 = l2
    while (c1 != null && c2 != null) {
        if (c1.`val` != c2.`val`) return false
        c1 = c1.next
        c2 = c2.next
    }
    return c1 == null && c2 == null
}

private fun testSolution(l1: IntArray, l2: IntArray, expected: IntArray) {
    val list1 = createListNode(l1)
    val list2 = createListNode(l2)
    val expectedList = createListNode(expected)
    val originalL1 = listNodeToString(list1)
    val originalL2 = listNodeToString(list2)
    val expectedResult = listNodeToString(expectedList)

    val result = try {
        Solution2().addTwoNumbers(list1, list2)
    } catch (_: NotImplementedError) {
        null
    }

    val resultMatches = areListNodesEqual(result, expectedList)
    val color = if (resultMatches) "\u001B[32m" else "\u001B[31m"
    val resetColor = "\u001B[0m"
    println("${color}Input: l1 = $originalL1, l2 = $originalL2")
    println("Expected: $expectedResult")
    println("Output: ${listNodeToString(result)}")
    if (!resultMatches) {
        println("Assertion Failed!$resetColor")
    } else {
        println("Assertion Passed!$resetColor")
    }
    println("-----------------------------------------")
}

fun main() {
    testSolution(intArrayOf(2, 4, 3), intArrayOf(5, 6, 4), intArrayOf(7, 0, 8))
    testSolution(intArrayOf(0), intArrayOf(0), intArrayOf(0))
    testSolution(intArrayOf(9, 9, 9, 9, 9, 9, 9), intArrayOf(9, 9, 9, 9), intArrayOf(8, 9, 9, 9, 0, 0, 0, 1))
    testSolution(intArrayOf(1, 2, 3), intArrayOf(1, 2, 3), intArrayOf(2, 4, 6))
    testSolution(intArrayOf(5), intArrayOf(5), intArrayOf(0, 1))
    testSolution(intArrayOf(1), intArrayOf(9, 9), intArrayOf(0, 0, 1))
    testSolution(intArrayOf(9, 9), intArrayOf(1), intArrayOf(0, 0, 1))
    testSolution(intArrayOf(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1), intArrayOf(5, 6, 4), intArrayOf(6, 6, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1))
}
