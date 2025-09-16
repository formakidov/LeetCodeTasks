package com.formakidov.leetcodetasks.easy

/*
27. Remove Element
Solved
Easy
Topics
premium lock icon
Companies
Hint
Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
Return k.
Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int val = ...; // Value to remove
int[] expectedNums = [...]; // The expected answer with correct length.
                            // It is sorted with no values equaling val.

int k = removeElement(nums, val); // Calls your implementation

assert k == expectedNums.length;
sort(nums, 0, k); // Sort the first k elements of nums
for (int i = 0; i < actualLength; i++) {
    assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.

 

Example 1:

Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2,_,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 2.
It does not matter what you leave beyond the returned k (hence they are underscores).
Example 2:

Input: nums = [0,1,2,2,3,0,4,2], val = 2
Output: 5, nums = [0,1,4,0,3,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
Note that the five elements can be returned in any order.
It does not matter what you leave beyond the returned k (hence they are underscores).
 

Constraints:

0 <= nums.length <= 100
0 <= nums[i] <= 50
0 <= val <= 100
*/
class Solution27 {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var lastUnknownValueIndex = -1
        var l = 0 // counter of equal to 'val'
        var i = 0

        while (i < nums.size) {
            if (nums[i] == `val`) {
                l++

                if (lastUnknownValueIndex == -1) {
                    lastUnknownValueIndex = nums.size - 1
                } else {
                    lastUnknownValueIndex--
                }

                nums[i] = nums[lastUnknownValueIndex]
                nums[lastUnknownValueIndex] = -1
            } else {
                i++
            }
        }
        return nums.size - l
    }
}

fun main() {
    val solution = Solution27()

    fun test(nums: IntArray, `val`: Int, expectedK: Int, expectedNums: IntArray) {
        val originalNums = nums.copyOf()
        val k = solution.removeElement(nums, `val`)
        val resultNums = nums.copyOfRange(0, k)
        resultNums.sort()
        expectedNums.sort()

        if (k == expectedK && resultNums.contentEquals(expectedNums)) {
            println("✅ Test passed for input: ${originalNums.contentToString()}, val = $`val`. Expected: k = $expectedK, nums = ${expectedNums.contentToString()}, Got: k = $k, nums = ${resultNums.contentToString()}")
        } else {
            println("❌ Test FAILED for input: ${originalNums.contentToString()}, val = $`val`. Expected: k = $expectedK, nums = ${expectedNums.contentToString()}, Got: \u001B[31mk = $k, nums = ${resultNums.contentToString()}\u001B[0m")
        }
    }

    test(intArrayOf(1, 1, 1, 1), 1, 0, intArrayOf())
    test(intArrayOf(3, 3), 3, 0, intArrayOf())
    test(intArrayOf(2, 2, 2), 2, 0, intArrayOf())
    test(intArrayOf(3, 2, 3, 0, 3, 1, 3, 3, 3), 3, 3, intArrayOf(0, 1, 2))
    test(intArrayOf(3, 2, 2, 3), 3, 2, intArrayOf(2, 2))
    test(intArrayOf(0, 1, 2, 2, 3, 0, 4, 2), 2, 5, intArrayOf(0, 1, 4, 0, 3))
    test(intArrayOf(), 0, 0, intArrayOf())
    test(intArrayOf(1, 2, 3, 4), 5, 4, intArrayOf(1, 2, 3, 4))
    test(intArrayOf(5), 5, 0, intArrayOf())
    test(intArrayOf(5), 4, 1, intArrayOf(5))
    test(intArrayOf(4, 5), 5, 1, intArrayOf(4))
    test(intArrayOf(3, 3), 5, 2, intArrayOf(3, 3))
    test(intArrayOf(4, 4, 0, 1, 0, 2), 4, 4, intArrayOf(0, 1, 0, 2))
    test(intArrayOf(1), 1, 0, intArrayOf())
    test(intArrayOf(3, 2, 2, 1), 3, 3, intArrayOf(1, 2, 2))
    test(intArrayOf(1, 2, 2, 3), 3, 3, intArrayOf(1, 2, 2))
    test(intArrayOf(1, 2, 3, 3, 4), 3, 3, intArrayOf(1, 2, 4))
    test(intArrayOf(0, 1, 2, 0, 3, 0, 4), 0, 4, intArrayOf(1, 2, 3, 4))
    test(intArrayOf(1, 1, 1, 1), 2, 4, intArrayOf(1, 1, 1, 1))
    test(intArrayOf(4, 1, 2, 4, 4), 4, 2, intArrayOf(1, 2))
    test(intArrayOf(4, 1, 4, 2, 4), 4, 2, intArrayOf(1, 2))
}
