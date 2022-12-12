package com.practice.question1;

class Solution {
    public static long solution(long[] numbers) {
        // Type your solution here
        long max = 0L;
        for (long i : numbers) {
            max = Math.max(i, max);
        }
        return max;
    }
}
