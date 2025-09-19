package com.formakidov.leetcodetasks.easy

/*
28. Find the Index of the First Occurrence in a String
Solved
Easy
Topics
premium lock icon
Companies
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 

Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.
Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.
 

Constraints:

1 <= haystack.length, needle.length <= 10^4
haystack and needle consist of only lowercase English characters.
*/

class Solution28 {
    fun strStr(haystack: String, needle: String): Int {
        val needleLength = needle.length
        var candidate = -1
        var i = 0
        var j = 0
        while (i < haystack.length) {
            if (haystack[i] == needle[j]) {
                if (candidate == -1) {
                    candidate = i
                }
                if (j == needleLength - 1) {
                    return candidate
                }
                i++
                j++
            } else {
                i = if (candidate == -1) i+1 else candidate + 1
                j = 0
                candidate = -1
            }
        }

        return -1
    }
}

private fun testSolution(haystack: String, needle: String, expected: Int) {
    val result = try {
        Solution28().strStr(haystack, needle)
    } catch (_: NotImplementedError) {
        null
    }

    val resultMatches = result == expected
    val color = if (resultMatches) "\u001B[32m" else "\u001B[31m"
    val resetColor = "\u001B[0m"
    println("${color}Input: haystack = \"$haystack\", needle = \"$needle\"")
    println("Expected: $expected")
    println("Output: $result")
    if (!resultMatches) {
        println("Assertion Failed!$resetColor")
    } else {
        println("Assertion Passed!$resetColor")
    }
    println("-----------------------------------------")
}

fun main() {
    testSolution("abc", "c", 2)
    testSolution("hello", "ll", 2)
    testSolution("aaaaa", "bba", -1)
    testSolution("leetcode", "leeto", -1)
    testSolution("sadbutsad", "sad", 0)
    testSolution("mississippi", "issip", 4)
    testSolution("mississippi", "issipi", -1)
    testSolution("a", "a", 0)
    testSolution("ab", "b", 1)
    testSolution("abc", "d", -1)
    testSolution("mississippi", "mississippi", 0)
    testSolution("mississippi", "i", 1)
    testSolution("babbbbbabb", "bbab", 5)
    testSolution("aaabaaa", "baaa", 3)
    testSolution("aaa", "aaaa", -1)
    testSolution("bba", "aaaaa", -1)
}
