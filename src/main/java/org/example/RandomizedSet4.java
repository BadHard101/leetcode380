package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

class RandomizedSet4 {
    ArrayList<Integer> vals;
    HashMap<Integer, Integer> indexes;
    Random random;

    public RandomizedSet4() {
        vals = new ArrayList<>();
        indexes = new HashMap<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if (indexes.containsKey(val)) return false;
        indexes.put(val, vals.size());
        vals.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (!indexes.containsKey(val)) return false;
        
        int valIndex = indexes.get(val);
        if (valIndex < vals.size() - 1) {
            int lastVal = vals.get(vals.size()-1);
            vals.set(valIndex, lastVal);
            indexes.put(lastVal, valIndex);
        }
        vals.remove(vals.size()-1);
        indexes.remove(val);
        return true;
    }
    
    public int getRandom() {
        return vals.get(random.nextInt(vals.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */