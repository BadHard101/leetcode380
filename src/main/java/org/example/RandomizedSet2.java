package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

class RandomizedSet2 {
    ArrayList<Integer> nums;
    HashMap<Integer, Integer> location;
    Random random;

    public RandomizedSet2() {
        nums = new ArrayList<>();
        location = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (nums.contains(val)) return false;

        location.put(val, nums.size());
        nums.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!nums.contains(val)) return false;

        int curLoc = location.get(val);
        if (curLoc < nums.size() - 1) {
            int lastOne = nums.get(nums.size() - 1);
            nums.set(curLoc, lastOne);
            location.put(lastOne, curLoc);
        }
        nums.remove(nums.size() - 1);
        location.remove(val);
        return true;
    }

    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */