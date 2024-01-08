package tester;

import cache.CacheFactory;
import cache.ICache;

public class Tester {
    public static void main(String[] args) {
        ICache<String, String> cache = CacheFactory.getLRUCacheOFString();

        cache.put("a", "b");
        cache.put("b", "c");
        cache.put("c", "d");
        cache.put("d", "e");
        cache.put("e", "f");
        cache.put("a", "g");
        cache.put("h", "i");
    }
}
