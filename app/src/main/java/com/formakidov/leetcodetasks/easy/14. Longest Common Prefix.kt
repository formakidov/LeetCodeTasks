package com.formakidov.leetcodetasks.easy

/*
14. Longest Common Prefix
Easy

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".



Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.


Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters if it is non-empty.*/


fun longestCommonPrefix(words: Array<String>): String {
    if (words.isEmpty()) {
        return ""
    }
    var commonPrefix = ""
    for (i in 0 until words[0].length) {
        val candidateChar = words[0][i]
        for (j in 0 until words.size) {
            if (words[j].length <= i || candidateChar != words[j][i]) {
                return commonPrefix
            }
        }
        commonPrefix += candidateChar
    }
    return commonPrefix
}

fun testLongestCommonPrefix(input: Array<String>, expected: String) {
    val actual = longestCommonPrefix(input)
    if (actual == expected) {
        println("\u001B[32mPASSED\u001B[0m: Input: ${input.contentToString()}, Expected: \"$expected\", Actual: \"$actual\"")
    } else {
        println("\u001B[31mFAILED\u001B[0m: Input: ${input.contentToString()}, Expected: \"$expected\", Actual: \"$actual\"")
    }
}

fun main() {
    val strs1 = arrayOf("flower", "flow", "flight")
    testLongestCommonPrefix(strs1, "fl")

    val strs2 = arrayOf("dog", "racecar", "car")
    testLongestCommonPrefix(strs2, "")

    val strs3 = arrayOf<String>()
    testLongestCommonPrefix(strs3, "")

    val strs4 = arrayOf("apple")
    testLongestCommonPrefix(strs4, "apple")

    val strs5 = arrayOf("a")
    testLongestCommonPrefix(strs5, "a")

    val strs6 = arrayOf("ab", "a")
    testLongestCommonPrefix(strs6, "a")

    val strs7 = arrayOf("cir", "car")
    testLongestCommonPrefix(strs7, "c")

    val strs8 = arrayOf("abab", "ab", "abc")
    testLongestCommonPrefix(strs8, "ab")
}
