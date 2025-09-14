package com.formakidov.leetcodetasks.medium

/*
46. Permutations
Medium
Topics
premium lock icon
Companies
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]
 

Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.
*/
class Solution46 {
    fun permute(nums: IntArray): List<List<Int>> {
        if (nums.isEmpty()) {
            return emptyList()
        } else if (nums.size == 1) {
            return listOf(nums.toList())
        }

        val result = mutableListOf<List<Int>>()
        val current = mutableListOf<Int>()
        val alreadyUsed = BooleanArray(nums.size)

        fun trace() {
            if (current.size == nums.size) {
                result.add(ArrayList(current))
                return
            }

            for (i in nums.indices) {
                if (alreadyUsed[i]) {
                    continue
                }

                current.add(nums[i])
                alreadyUsed[i] = true

                trace()

                alreadyUsed[i] = false
                current.removeAt(current.size - 1)
            }
        }

        trace()

        return result
    }
}

fun main() {
    val solution = Solution46()

    fun test(nums: IntArray, expected: List<List<Int>>) {
        val result = solution.permute(nums)
        if (result.toSet() == expected.toSet()) {
            println("✅ Test passed for input: ${nums.contentToString()}. Expected: $expected, Got: $result")
        } else {
            println("❌ Test FAILED for input: ${nums.contentToString()}. Expected: $expected, Got: \u001B[31m$result\u001B[0m")
        }
    }

    test(intArrayOf(), emptyList())
    test(intArrayOf(0), listOf(listOf(0)))
    test(intArrayOf(1), listOf(listOf(1)))
    test(intArrayOf(0, 1), listOf(listOf(0, 1), listOf(1, 0)))
    test(intArrayOf(10, -5), listOf(listOf(10, -5), listOf(-5, 10)))
    test(intArrayOf(7, 8), listOf(listOf(7, 8), listOf(8, 7)))
    test(
        intArrayOf(1, 2, 3), listOf(
            listOf(1, 2, 3), listOf(1, 3, 2), listOf(2, 1, 3), listOf(2, 3, 1), listOf(3, 1, 2), listOf(3, 2, 1)
        )
    )
    test(
        intArrayOf(-1, 5, 2), listOf(
            listOf(-1, 5, 2), listOf(-1, 2, 5), listOf(5, -1, 2), listOf(5, 2, -1), listOf(2, -1, 5), listOf(2, 5, -1)
        )
    )
    test(
        intArrayOf(1, 2, 3, 4), listOf(
            listOf(1, 2, 3, 4),
            listOf(1, 2, 4, 3),
            listOf(1, 3, 2, 4),
            listOf(1, 3, 4, 2),
            listOf(1, 4, 2, 3),
            listOf(1, 4, 3, 2),
            listOf(2, 1, 3, 4),
            listOf(2, 1, 4, 3),
            listOf(2, 3, 1, 4),
            listOf(2, 3, 4, 1),
            listOf(2, 4, 1, 3),
            listOf(2, 4, 3, 1),
            listOf(3, 1, 2, 4),
            listOf(3, 1, 4, 2),
            listOf(3, 2, 1, 4),
            listOf(3, 2, 4, 1),
            listOf(3, 4, 1, 2),
            listOf(3, 4, 2, 1),
            listOf(4, 1, 2, 3),
            listOf(4, 1, 3, 2),
            listOf(4, 2, 1, 3),
            listOf(4, 2, 3, 1),
            listOf(4, 3, 1, 2),
            listOf(4, 3, 2, 1)
        )
    )
}
