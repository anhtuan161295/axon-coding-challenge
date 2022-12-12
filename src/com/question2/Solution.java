package com.question2;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static String solution(long total, long[][] conditions) {
        // Write your solution here
        if (conditions.length == 1) return "victory";

        Map<Long, Long> missionMap = new HashMap<>();
        for (int i = 0; i < conditions.length; i++) {
            long mission1 = conditions[i][0];
            long mission2 = conditions[i][1];
            missionMap.put(mission1, mission2);
        }

        boolean isLooped = false;
        for (int i = 0; i < conditions.length; i++) {
            long mission1 = conditions[i][0];
            long mission2 = conditions[i][1];

            if (!canMissionDoable(mission2, missionMap)){
                isLooped = false;
                break;
            }
        }

        return isLooped ? "defeat" : "victory";
    }

    public static boolean canMissionDoable(long mission, Map<Long, Long> missionMap) {
        Long missionTodo = missionMap.getOrDefault(mission, null);
        if (missionTodo == null) return true; // no requirement for this mission;
        return canMissionDoable(missionTodo, missionMap);
    }

    public static void main(String[] args) {

    }
}
