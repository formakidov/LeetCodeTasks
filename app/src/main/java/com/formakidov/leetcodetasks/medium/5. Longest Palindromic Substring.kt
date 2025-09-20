package com.formakidov.leetcodetasks.medium

/*
5. Longest Palindromic Substring
Medium
Topics
premium lock icon
Companies
Hint
Given a string s, return the longest palindromic substring in s.



Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"


Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
*/

class Solution5 {
    fun longestPalindrome(s: String): String {
        var longest: String = s[0].toString()

        fun findPalindrom(initialLeft: Int, initialRight: Int) {
            var left = initialLeft
            var right = initialRight
            while (left >= 0 && right < s.length && s[left] == s[right]) {
                if (right - left + 1 > longest.length) {
                    longest = s.substring(left, right + 1)
                }
                left--
                right++
            }
        }

        for (i in 0 until s.length) {
            findPalindrom(i, i) // odd palindrom length
            findPalindrom(i, i + 1) // even palindrom length
        }

        return longest
    }
}

private fun testSolution(s: String, expected: Set<String>) {
    val result = try {
        Solution5().longestPalindrome(s)
    } catch (_: NotImplementedError) {
        null
    }

    val resultMatches = expected.contains(result)
    val color = if (resultMatches) "\u001B[32m" else "\u001B[31m"
    val resetColor = "\u001B[0m"
    println("${color}Input: s = \"$s\"")
    println("Expected: one of $expected")
    println("Output: \"$result\"")
    if (!resultMatches) {
        println("Assertion Failed!$resetColor")
    } else {
        println("Assertion Passed!$resetColor")
    }
    println("-----------------------------------------")
}

fun main() {
    testSolution("aaa", setOf("aaa"))
    testSolution("zzzzzz", setOf("zzzzzz"))
    testSolution("abcdefg", setOf("a", "b", "c", "d", "e", "f", "g"))
    testSolution("forgeeksskeegfor", setOf("geeksskeeg"))
    testSolution("bananas", setOf("anana"))
    testSolution("aaaa", setOf("aaaa"))
    testSolution("baac", setOf("aa"))
    testSolution("babad", setOf("bab", "aba"))
    testSolution("cbbd", setOf("bb"))
    testSolution("a", setOf("a"))
    testSolution("ac", setOf("a", "c"))
    testSolution("racecar", setOf("racecar"))
    testSolution("abacdfgdcaca", setOf("aba", "aca"))
    testSolution("abb", setOf("bb"))
    testSolution("abcba", setOf("abcba"))
    testSolution("1", setOf("1"))
    testSolution("11", setOf("11"))
    testSolution("111", setOf("111"))
    testSolution("a1", setOf("a", "1"))
    testSolution("1a", setOf("a", "1"))
    testSolution("a1b", setOf("a", "1", "b"))
    testSolution("aa", setOf("aa"))
    testSolution("ab", setOf("a", "b"))
    testSolution("aba", setOf("aba"))
    testSolution("abc", setOf("a", "b", "c"))
    testSolution("abccba", setOf("abccba"))
    testSolution("abcdcba", setOf("abcdcba"))
    testSolution("madam", setOf("madam"))
    testSolution("level", setOf("level"))
    testSolution("noon", setOf("noon"))
    testSolution("aibohphobia", setOf("aibohphobia")) // A fear of palindromes
}
