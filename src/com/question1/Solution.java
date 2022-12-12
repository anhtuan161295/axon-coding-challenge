package com.question1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static long[] solution(long[] array) {
        // Write your solution here
        List<Long> list = new ArrayList<>();
        long max = 1;
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                list.add(Long.valueOf(i));
                max = Math.max(max, array[i]);
            }
        }

        return list.stream().mapToLong(l -> l).toArray();
    }

    public static void main(String[] args) {
        long[] result = Solution.solution(new long[]{10, 5, 2, 3, 11, 7});
        System.out.println(Arrays.toString(result)); // [0, 4]

        long[] result2 = Solution.solution(new long[]{3, 7, 2, 3, 7, 11, 15, 8, 11, 9});
        System.out.println(Arrays.toString(result2)); // [1, 6, 8]
    }


}
