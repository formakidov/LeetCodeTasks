package com.formakidov.leetcodetasks.medium

import kotlin.math.max

/*
3. Longest Substring Without Repeating Characters
Medium
Topics
premium lock icon
Companies
Hint
Given a string s, find the length of the longest substring without duplicate characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
 */

class Solution3 {
    fun lengthOfLongestSubstring(s: String): Int {
        val charIndexMap = hashMapOf<Char, Int?>()
        var max = 0
        var startCountIndex = 0

        s.forEachIndexed { i, c ->
            val indexOfStoredChar = charIndexMap[c]
            charIndexMap.put(c, i)
            if (indexOfStoredChar != null && indexOfStoredChar >= startCountIndex) {
                startCountIndex = indexOfStoredChar + 1
            } else {
                max = max(i - startCountIndex + 1, max)
            }
        }

        return max
    }
}

fun main() {
    testLengthOfLongestSubstring("wobgrovw", 6)
    testLengthOfLongestSubstring("tmmzuxt", 5)
    testLengthOfLongestSubstring("zzzaac", 2)
    testLengthOfLongestSubstring("pwwkew", 3)
    testLengthOfLongestSubstring("dvdf", 3)
    testLengthOfLongestSubstring("abcabcbb", 3)
    testLengthOfLongestSubstring("bbbbb", 1)
    testLengthOfLongestSubstring("", 0)
    testLengthOfLongestSubstring(" ", 1)
    testLengthOfLongestSubstring("au", 2)
    testLengthOfLongestSubstring("aab", 2)
    testLengthOfLongestSubstring("abba", 2)
    testLengthOfLongestSubstring("abcdefg", 7)
    testLengthOfLongestSubstring("abacaba", 3)
    testLengthOfLongestSubstring("anviaj", 5)
    testLengthOfLongestSubstring("ohomm", 3)
    testLengthOfLongestSubstring("bpfbhmipx", 7)
    testLengthOfLongestSubstring("abcdefghijklmnopqrstuvwxyz", 26)
    testLengthOfLongestSubstring("abcdefghijklmnopqrstuvwxyza", 26)
    testLengthOfLongestSubstring("!@#$%^&*()_+", 12)
    testLengthOfLongestSubstring("1234567890", 10)
}

private fun testLengthOfLongestSubstring(s: String, expected: Int) {
    val solution = Solution3()
    val result = solution.lengthOfLongestSubstring(s)
    if (result == expected) {
        println("\u001B[32mPASSED\u001B[0m: For input \"$s\", expected $expected, got $result")
    } else {
        println(
            "\u001B[31mFAILED\u001B[0m: For input \"$s\", expected $expected, got $result"
        )
    }
}
