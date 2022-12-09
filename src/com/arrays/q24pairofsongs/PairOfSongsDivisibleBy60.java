package com.arrays.q24pairofsongs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Anurag <br />
 * <link>https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60</link> LeetCode
 */
public class PairOfSongsDivisibleBy60 {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<time.length;i++){
            time[i] = time[i]%60;
            map.put(time[i], map.getOrDefault(time[i],0)+1);
        }
        Arrays.sort(time);
        int count = 0;
        for (int j : time) {
            int target = 60 - j;
            if (target == 60) target = 0;
            if (target < j) break;
            if (map.containsKey(target)) {
                if (target == j) {
                    count += (map.getOrDefault(j, 0) - 1);
                } else {
                    count += map.getOrDefault(target, 0);
                }
            }
            map.put(j, map.getOrDefault(j, 0) - 1);
        }
        return count;
    }
}
