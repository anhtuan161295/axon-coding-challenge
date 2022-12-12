package com.question2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    // https://leetcode.com/problems/course-schedule/solutions/58550/clean-java-solutions-bfs-and-dfs/
    public static String solution(long total, long[][] conditions) {
        // Write your solution here
        if (conditions.length == 1) return "victory";

        boolean result = canFinish(conditions);
        return result ? "victory" : "defeat";
    }

    public static boolean canFinish(long[][] conditions) {
        Map<Integer, Set<Integer>> missionMap = new HashMap<>();
        for (int i = 0; i < conditions.length; i++) {
            int mission1 = (int) conditions[i][0];
            int mission2 = (int) conditions[i][1];
            missionMap.putIfAbsent(mission1, new HashSet<>());
            missionMap.get(mission1).add(mission2);
        }

        // dfs visit each course
        int[] visited = new int[conditions.length]; // 0: unvisited; 1: being visited; 2: visited
        for (int i = 0; i < conditions.length; i++) {
            if (visited[i] == 0 && !dfs(i, missionMap, visited)) {
                return false;
            }
        }

        return true;
    }

    // detect circle (if a circle is detected, return false)
    private static boolean dfs(int course, Map<Integer, Set<Integer>> missionMap, int[] visited) {
        visited[course] = 1;  // mark course as being visited
        for (int neighbor : missionMap.get(course)) {
            if (visited[neighbor] == 1) {  // circle detected
                return false;
            }
            if (visited[neighbor] == 0 && !dfs(neighbor, missionMap, visited)) {  // circle detected
                return false;
            }
        }
        visited[course] = 2;  // mark course as visited
        return true;
    }

    public static void main(String[] args) {
        String result = Solution.solution(2, new long[][]{{0, 1}});
        System.out.println(result);

        String result2 = Solution.solution(2, new long[][]{{1, 0}, {0, 1}});
        System.out.println(result2);
    }
}
