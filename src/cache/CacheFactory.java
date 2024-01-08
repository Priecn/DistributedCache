package cache;

import eviction_policies.LRUEvictionPolicy;
import storage.HashMapStorage;

public class CacheFactory {

    public static ICache<String, String> getLRUCacheOFString() {
        return new CacheToStoreString(new HashMapStorage(5), new LRUEvictionPolicy());
    }
}
