package com.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Anurag <br />
 * <link>https://leetcode.com/problems/insert-delete-getrandom-o1/</link>
 * LeetCode
 */
public class InsertDeleteGetRandomBigO1 {

}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet(); boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val); int param_3 = obj.getRandom();
 */

class RandomizedSet {

    private final Set<Integer> randomizedSet;

    public RandomizedSet() {
        randomizedSet = new HashSet<>();
    }

    /**
     * Inserts an item val into the set if not present. Returns true if the item was
     * not present, false otherwise.
     */
    public boolean insert(int val) {
        return randomizedSet.add(val);
    }

    /**
     * Removes an item val from the set if present. Returns true if the item was
     * present, false otherwise.
     */
    public boolean remove(int val) {
        return randomizedSet.remove(val);
    }

    /**
     * Returns a random element from the current set of elements (it's guaranteed
     * that at least one element exists when this method is called). Each element
     * must have the same probability of being returned.
     */
    public int getRandom() {
        List<Integer> list = new ArrayList<>(randomizedSet);
        int randomValue = (int) (Math.random() * randomizedSet.size());
        return list.get(randomValue);

    }
}
