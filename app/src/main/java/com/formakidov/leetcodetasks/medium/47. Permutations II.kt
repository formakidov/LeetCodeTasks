package com.formakidov.leetcodetasks.medium

/*
47. Permutations II
Medium
Topics
premium lock icon
Companies
Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.



Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
Example 2:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]


Constraints:

1 <= nums.length <= 8
-10 <= nums[i] <= 10
*/
class Solution47 {
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        if (nums.isEmpty()) {
            return emptyList()
        } else if (nums.size == 1) {
            return listOf(nums.toList())
        }

        nums.sort()

        val result = mutableListOf<List<Int>>()
        val current = mutableListOf<Int>()
        val alreadyUsed = BooleanArray(nums.size)

        fun trace() {
            if (current.size == nums.size) {
                result.add(ArrayList(current))
                return
            }

            for (i in nums.indices) {
                if (alreadyUsed[i] || (i > 0 && nums[i] == nums[i - 1] && !alreadyUsed[i - 1])) {
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
    val solution = Solution47()

    fun test(nums: IntArray, expected: List<List<Int>>) {
        val result = solution.permuteUnique(nums)
        if (result.toSet() == expected.toSet()) {
            println("✅ Test passed for input: ${nums.contentToString()}. Expected: $expected, Got: $result")
        } else {
            println("❌ Test FAILED for input: ${nums.contentToString()}. Expected: $expected, Got: \u001B[31m$result\u001B[0m")
        }
    }

    test(
        intArrayOf(1, 1, 2), listOf(
            listOf(1, 1, 2),
            listOf(1, 2, 1),
            listOf(2, 1, 1)
        )
    )

    test(
        intArrayOf(1, 2, 3), listOf(
            listOf(1, 2, 3),
            listOf(1, 3, 2),
            listOf(2, 1, 3),
            listOf(2, 3, 1),
            listOf(3, 1, 2),
            listOf(3, 2, 1)
        )
    )

    test(intArrayOf(), emptyList())
    test(intArrayOf(1), listOf(listOf(1)))
    test(intArrayOf(2, 2, 2), listOf(listOf(2, 2, 2)))
    test(
        intArrayOf(-1, 1, -1), listOf(
            listOf(-1, -1, 1),
            listOf(-1, 1, -1),
            listOf(1, -1, -1)
        )
    )
    test(
        intArrayOf(0, 1), listOf(
            listOf(0, 1),
            listOf(1, 0)
        )
    )
}
