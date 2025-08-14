package com.formakidov.leetcodetasks.easy

/*
21. Merge Two Sorted Lists
Easy
Topics
premium lock icon
Companies
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.



Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]


Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.
 */

class ListNode(var v: Byte) {
    var next: ListNode? = null
}

class Solution21 {
    fun mergeTwoLists(node1: ListNode?, node2: ListNode?): ListNode? {
        if (node1 == null) return node2
        if (node2 == null) return node1
        if (node1.v < node2.v) {
            node1.next = mergeTwoLists(node1.next, node2)
            return node1
        } else {
            node2.next = mergeTwoLists(node1, node2.next)
            return node2
        }
    }
}

fun main() {
    val solution = Solution21()

    fun test(list1: List<Byte>, list2: List<Byte>, expected: List<Byte>) {
        val l1 = createLinkedList(list1)
        val l2 = createLinkedList(list2)
        val merged = solution.mergeTwoLists(l1, l2)
        val result = linkedListToList(merged)

        if (result == expected) {
            println("✅ Test passed for list1: $list1, list2: $list2. Expected: $expected, Got: $result")
        } else {
            println("❌ Test FAILED for list1: $list1, list2: $list2. Expected: $expected, Got: \u001B[31m$result\u001B[0m")
        }
    }

    test(listOf(1, 2, 4), listOf(1, 3, 4), listOf(1, 1, 2, 3, 4, 4))
    test(listOf(), listOf(), listOf())
    test(listOf(), listOf(0), listOf(0))
    test(listOf(5), listOf(), listOf(5))
    test(listOf(1, 3, 5), listOf(2, 4, 6), listOf(1, 2, 3, 4, 5, 6))
    test(listOf(2, 4, 6), listOf(1, 3, 5), listOf(1, 2, 3, 4, 5, 6))
    test(listOf(1, 1, 1), listOf(1, 1, 1), listOf(1, 1, 1, 1, 1, 1))
    test(listOf(-10, 0, 10), listOf(-5, 5, 15), listOf(-10, -5, 0, 5, 10, 15))
    test(listOf(1), listOf(2), listOf(1, 2))
    test(listOf(2), listOf(1), listOf(1, 2))
    test(listOf(1, 2, 3), listOf(), listOf(1, 2, 3))
    test(listOf(), listOf(1, 2, 3), listOf(1, 2, 3))
    test(listOf(1, 5, 10), listOf(2, 3, 12), listOf(1, 2, 3, 5, 10, 12))
    test(List(50) { it.toByte() }, List(50) { (it + 25).toByte() },
        (List(50) { it.toByte() } + List(50) { (it + 25).toByte() }).sorted()
    )
    test(listOf(-100, 100), listOf(-99, 99), listOf(-100, -99, 99, 100))
}

fun createLinkedList(values: List<Byte>): ListNode? {
    if (values.isEmpty()) return null
    val head = ListNode(values[0])
    var current = head
    for (i in 1 until values.size) {
        current.next = ListNode(values[i])
        current = current.next!!
    }
    return head
}

fun linkedListToList(head: ListNode?): List<Byte> {
    val list = mutableListOf<Byte>()
    var current = head
    while (current != null) {
        list.add(current.v)
        current = current.next
    }
    return list
}
