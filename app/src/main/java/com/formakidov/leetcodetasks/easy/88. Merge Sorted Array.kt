package com.formakidov.leetcodetasks.easy

/*
88. Merge Sorted Array
Easy
Topics
premium lock icon
Companies
Hint
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

 

Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].
Example 3:

Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 

Constraints:

nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-109 <= nums1[i], nums2[j] <= 109
 

Follow up: Can you come up with an algorithm that runs in O(m + n) time?
*/

class Solution88 {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        var i = m - 1
        var j = n - 1

        while (i > -1 || j > -1) {
            if (i == -1) {
                nums1[i + j + 1] = nums2[j]
                j--
                continue
            }
            if (j == -1) {
                nums1[i + j + 1] = nums1[i]
                i--
                continue
            }

            if (nums1[i] > nums2[j]) {
                val tmp = nums1[i]
                nums1[i] = 0
                nums1[i + j + 1] = tmp
                i--
            } else {
                nums1[i + j + 1] = nums2[j]
                j--
            }
        }
    }
}

private fun testSolution(nums1Initial: IntArray, m: Int, nums2: IntArray, n: Int, expected: IntArray) {
    val nums1 = nums1Initial.clone()
    val originalNums1ForPrinting = nums1Initial.contentToString()

    Solution88().merge(nums1, m, nums2, n)

    val resultMatches = nums1.contentEquals(expected)
    val color = if (resultMatches) "\u001B[32m" else "\u001B[31m"
    val resetColor = "\u001B[0m"
    println("${color}Input: nums1 = $originalNums1ForPrinting, m = $m, nums2 = ${nums2.contentToString()}, n = $n")
    println("Expected: ${expected.contentToString()}")
    println("Output: ${nums1.contentToString()}")
    if (!resultMatches) {
        println("Assertion Failed!$resetColor")
    } else {
        println("Assertion Passed!$resetColor")
    }
    println("-----------------------------------------")
}

fun main() {
    testSolution(intArrayOf(1, 2, 3, 0, 0, 0), 3, intArrayOf(2, 5, 6), 3, intArrayOf(1, 2, 2, 3, 5, 6))
    testSolution(intArrayOf(1), 1, intArrayOf(), 0, intArrayOf(1))
    testSolution(intArrayOf(1, 2, 3, 4, 5), 5, intArrayOf(), 0, intArrayOf(1, 2, 3, 4, 5))
    testSolution(intArrayOf(4, 5, 6, 0, 0, 0), 3, intArrayOf(1, 2, 3), 3, intArrayOf(1, 2, 3, 4, 5, 6))
    testSolution(intArrayOf(2, 0), 1, intArrayOf(1), 1, intArrayOf(1, 2))
    testSolution(intArrayOf(0, 0, 0), 0, intArrayOf(1, 2, 3), 3, intArrayOf(1, 2, 3))
    testSolution(intArrayOf(0), 0, intArrayOf(1), 1, intArrayOf(1))
    testSolution(IntArray(200), 0, IntArray(200) { it + 1 }, 200, IntArray(200) { it + 1 }) // m = 0, n = 200
    testSolution(IntArray(200) { if (it < 200) it + 1 else 0 }, 200, intArrayOf(), 0, IntArray(200) { it + 1 }) // m = 200, n = 0
    testSolution(IntArray(1), 0, intArrayOf(5), 1, intArrayOf(5)) // m = 0, n = 1, m+n=1
    testSolution(intArrayOf(5), 1, intArrayOf(), 0, intArrayOf(5)) // m = 1, n = 0, m+n=1
    testSolution(IntArray(400) { if (it < 200) it * 2 else 0 }, 200, IntArray(200) { it * 2 + 1 }, 200, IntArray(400) { it }) // m = 200, n = 200
}
