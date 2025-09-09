package com.formakidov.leetcodetasks.medium

/*
61. Rotate List
Medium
Topics
premium lock icon
Companies
Given the head of a linked list, rotate the list to the right by k places.



Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
Example 2:


Input: head = [0,1,2], k = 4
Output: [2,0,1]


Constraints:

The number of nodes in the list is in the range [0, 500].
-100 <= Node.val <= 100
0 <= k <= 2 * 109
*/

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 */
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution61 {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        // edge cases
        if (head == null) return null
        if (head.next == null || k == 0) return head

        // count size
        var size = 2
        var tail = head.next!!
        while(tail.next != null) {
            tail = tail.next!!
            size++
        }

        val effectiveK = if (k >= size) k % size else k
        if (effectiveK == 0) {
            return head // effectively no rotation
        } else {
            tail.next = head
        }

        var newTail = head
        (0 until size - effectiveK - 1).forEach { i ->
            newTail = newTail?.next
        }

        val newHead = newTail?.next

        newTail?.next = null

        return newHead
    }
}

fun main() {
    val solution = Solution61()

    fun createListNode(list: List<Int>): ListNode? {
        if (list.isEmpty()) return null
        val head = ListNode(list.first())
        var current = head
        for (i in 1 until list.size) {
            current.next = ListNode(list[i])
            current = current.next!!
        }
        return head
    }

    fun listNodeToList(head: ListNode?): List<Int> {
        val list = mutableListOf<Int>()
        var current = head
        while (current != null) {
            list.add(current.`val`)
            current = current.next
        }
        return list
    }

    fun test(inputList: List<Int>, k: Int, expectedList: List<Int>) {
        val head = createListNode(inputList)
        val result = solution.rotateRight(head, k)
        val resultList = listNodeToList(result)
        if (resultList == expectedList) {
            println("✅ Test passed for input: $inputList, k: $k. Expected: $expectedList, Got: $resultList")
        } else {
            println("❌ Test FAILED for input: $inputList, k: $k. Expected: $expectedList, Got: \u001B[31m$resultList\u001B[0m")
        }
    }

    test(listOf(), 0, listOf())
    test(listOf(), 1, listOf())
    test(listOf(), 5, listOf())
    test(listOf(1), 0, listOf(1))
    test(listOf(1), 1, listOf(1))
    test(listOf(1), 100, listOf(1))
    test(listOf(1, 2), 2, listOf(1, 2))
    test(listOf(0, 1, 2), 4, listOf(2, 0, 1))
    test(listOf(1, 2, 3), 0, listOf(1, 2, 3))
    test(listOf(1, 2, 3), 1, listOf(3, 1, 2))
    test(listOf(1, 2, 3), 3, listOf(1, 2, 3))
    test(listOf(-1, -2, -3), 1, listOf(-3, -1, -2))
    test(listOf(1, 2, 3, 4), 6, listOf(3, 4, 1, 2))
    test(listOf(1, 2, 3, 4, 5), 5, listOf(1, 2, 3, 4, 5))
    test(listOf(1, 2, 3, 4, 5), 2, listOf(4, 5, 1, 2, 3))
    test(listOf(1, 2, 3, 4, 5, 6), 10, listOf(3, 4, 5, 6, 1, 2))
}
