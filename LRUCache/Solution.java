import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        LRUCache lrc = new LRUCache(2);
        System.out.println(lrc.get(2));
        lrc.put(2, 6);
        System.out.println(lrc.get(1));
        lrc.put(1, 5);
        lrc.put(1, 2);
        System.out.println(lrc.get(1));
        System.out.println(lrc.get(2));
    }
}

class LRUCache {
    TreeMap<Integer, Integer> recentKeys = new TreeMap<>();
    HashMap<Integer, Integer[]> map = new HashMap<>();
    int size;
    int currSize;
    int rank = 0;
    public LRUCache(int capacity) {
        size = capacity;
        currSize = 0;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Integer[] item = map.get(key);
            recentKeys.remove(item[1]);
            int nextRank = rank++;
            recentKeys.put(nextRank, key);
            map.put(key, new Integer[] { item[0], nextRank });
            return item[0];
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Integer[] item = map.get(key);
            recentKeys.remove(item[1]);
            int nextRank = rank++;
            recentKeys.put(nextRank, key);
            map.put(key, new Integer[] { value, nextRank });
        } else {
            if (currSize < size) {
                int nextRank = rank++;
                map.put(key, new Integer[] { value, nextRank });
                recentKeys.put(nextRank, key);
                currSize++;
            } else {
                Map.Entry<Integer, Integer> toRemove = recentKeys.firstEntry();
                recentKeys.remove(toRemove.getKey());
                map.remove(toRemove.getValue());
                int nextRank = rank++;
                map.put(key, new Integer[] { value, nextRank });
                recentKeys.put(nextRank, key);
            }
        }
        
    }
}