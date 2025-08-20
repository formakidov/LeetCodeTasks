package com.formakidov.leetcodetasks.easy

/*
83. Remove Duplicates from Sorted List
Easy
Topics
premium lock icon
Companies
Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.



Example 1:


Input: head = [1,1,2]
Output: [1,2]
Example 2:


Input: head = [1,1,2,3,3]
Output: [1,2,3]


Constraints:

The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.
*/

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution83 {
    fun deleteDuplicates(head: ListNode86?): ListNode86? {
        var current = head
        while(current?.next != null) {
            if (current.`val` == current.next!!.`val`) {
                current.next = current.next!!.next
            } else {
                current = current.next
            }
        }
        return head
    }
}

class ListNode86(var `val`: Int) {
    var next: ListNode86? = null
}

private fun createListNode(values: IntArray): ListNode86? {
    if (values.isEmpty()) return null
    val head = ListNode86(values[0])
    var current = head
    for (i in 1 until values.size) {
        current.next = ListNode86(values[i])
        current = current.next!!
    }
    return head
}

private fun listNodeToString(head: ListNode86?): String {
    if (head == null) return "[]"
    val sb = StringBuilder("[")
    var current = head
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

private fun listsAreEqual(l1: ListNode86?, l2: ListNode86?): Boolean {
    var c1 = l1
    var c2 = l2
    while (c1 != null && c2 != null) {
        if (c1.`val` != c2.`val`) return false
        c1 = c1.next
        c2 = c2.next
    }
    return c1 == null && c2 == null
}

private fun testSolution(inputValues: IntArray, expectedValues: IntArray) {
    val head = createListNode(inputValues)
    val expectedHead = createListNode(expectedValues)

    val resultHead = Solution83().deleteDuplicates(createListNode(inputValues))

    val resultMatches = listsAreEqual(resultHead, expectedHead)
    val color = if (resultMatches) "\u001B[32m" else "\u001B[31m"
    val resetColor = "\u001B[0m"

    println("${color}Input:    ${listNodeToString(head)}")
    println("Expected: ${listNodeToString(expectedHead)}")
    println("Result:   ${listNodeToString(resultHead)}")

    if (!resultMatches) {
        println("Assertion Failed!$resetColor")
    } else {
        println("Assertion Passed!$resetColor")
    }
    println("-----------------------------------------")
}

fun main() {
    testSolution(intArrayOf(1, 1, 2), intArrayOf(1, 2))
    testSolution(intArrayOf(1, 1, 2, 3, 3), intArrayOf(1, 2, 3))
    testSolution(intArrayOf(), intArrayOf())
    testSolution(intArrayOf(1, 2, 3, 4, 5), intArrayOf(1, 2, 3, 4, 5))
    testSolution(intArrayOf(1, 1, 1, 1, 1), intArrayOf(1))
    testSolution(intArrayOf(-1, -1, 0, 0, 3), intArrayOf(-1, 0, 3))
    testSolution(intArrayOf(5), intArrayOf(5))
}
