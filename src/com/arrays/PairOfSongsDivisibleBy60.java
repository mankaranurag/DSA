package com.arrays;

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
        for(int i=0;i<time.length;i++){
            int target = 60-time[i];
            if(target == 60) target = 0;
            if(target < time[i]) break;
            if(map.containsKey(target)){
                if(target == time[i]) {
                    count += (map.getOrDefault(time[i],0) -1);
                }else if(target > time[i]){
                    count += map.getOrDefault(target,0);
                }
            }
            map.put(time[i], map.getOrDefault(time[i],0) -1);
        }
        return count;
    }
}
