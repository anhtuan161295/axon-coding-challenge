package com.practice.question2;

public class Solution {

    // https://leetcode.com/discuss/general-discussion/705268/determine-larger-branch-in-binary-tree-represented-as-an-array-question-from-another-site
    public static String solution(long[] arr) {
        // Type your solution here
        if (arr.length == 0) return "";
        long left = 0; // sums of each branch
        long right = 0;
        int level = 1; // current level we are on, root is level 0

        int nodes = (int) Math.pow(2, level); // num of nodes at each level will always be 2^level (root has 1 node, next level has 2, next level has 4, then 8, etc...)
        int nodesCounted = 0; // how many nodes we counted at the current level
        for (int i = 1; i < arr.length; i++) { // don't need to count root since sums will be the same with or without it
            if (nodesCounted == nodes) { // when we finish counting all nodes in a level, move to next level and reset count
                level++;
                nodesCounted = 0;
            }

            nodes = (int) Math.pow(2, level);
            if (arr[i] != -1) { // because nodes variable assumes each level is filled out (all nodes have 2 children) just skip this node if -1
                if (nodesCounted < nodes / 2) { // assuming completely filled out level, left branch nodes will always be in the lower half of the range we're looking in (0 to nodes)
                    left += arr[i];
                } else {
                    right += arr[i]; // right half of range
                }
            }
            nodesCounted++; // must increment even for non-existent nodes so we know this level is finished and can move to next level
        }

        if (left > right) {
            return "Left";
        }
        return right > left ? "Right" : "";
    }


}
