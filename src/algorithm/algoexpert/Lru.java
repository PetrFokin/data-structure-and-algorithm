package algorithm.algoexpert;

import java.util.LinkedHashMap;
import java.util.Map;

public class Lru {
    static class LRUCache {
        int maxSize;
        String mostRecentKey;
        Map<String, Integer> cache = new LinkedHashMap<>();

        public LRUCache(int maxSize) {
            this.maxSize = Math.max(maxSize, 1);
        }

        public void insertKeyValuePair(String key, int value) {
            if (cache.containsKey(key)) {
                cache.remove(key); //?????
                cache.put(key, value);
                mostRecentKey = key;
            } else {
                cache.put(key, value);
                mostRecentKey = key;
                removeEldestPair();
            }
        }

        public LRUResult getValueFromKey(String key) {
            Integer value = cache.get(key);
            if (value != null) {
                cache.remove(key); //?????
                cache.put(key, value);
                mostRecentKey = key;
                return new LRUResult(true, value);
            }
            return new LRUResult(false, -1);
        }

        public String getMostRecentKey() {
            return mostRecentKey;
        }

        private void removeEldestPair() {
            if (cache.size() > maxSize) {
                String eldestKey = cache.entrySet().iterator().next().getKey();
                cache.remove(eldestKey);
            }
        }
    }

    //add Node with 2 fields

    static class LRUResult {
        boolean found;
        int value;

        public LRUResult(boolean found, int value) {
            this.found = found;
            this.value = value;
        }

        @Override
        public String toString() {
            return "LRUResult{" +
                    "found=" + found +
                    ", value=" + value +
                    '}';
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.insertKeyValuePair("a", 1);
        lruCache.insertKeyValuePair("b", 2);
        lruCache.insertKeyValuePair("c", 3);
        System.out.println(lruCache.getMostRecentKey());
        System.out.println(lruCache.getValueFromKey("a"));
        System.out.println(lruCache.getMostRecentKey());
        lruCache.insertKeyValuePair("d", 4);
        System.out.println(lruCache.getMostRecentKey());
        System.out.println(lruCache.getValueFromKey("b"));


    }
}
