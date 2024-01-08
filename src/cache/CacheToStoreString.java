package cache;


import eviction_policies.IEvictionPolicy;
import exception.StorageFullException;
import storage.IStorage;

public class CacheToStoreString implements ICache<String, String> {

    IStorage<String, String> storage;
    IEvictionPolicy<String> evictionPolicy;

    public CacheToStoreString(IStorage<String, String> storage, IEvictionPolicy<String> evictionPolicy) {
        this.storage = storage;
        this.evictionPolicy = evictionPolicy;
    }

    @Override
    public String get(String key) {
        String data = storage.fetch(key);
        evictionPolicy.keyAccessed(key);
        return data;
    }

    @Override
    public void put(String key, String value) {
        try {
            storage.add(key, value);
            evictionPolicy.keyAccessed(key);
        } catch (StorageFullException exception) {
            String keyToRemove = evictionPolicy.evict();
            storage.delete(keyToRemove);
            storage.add(key, value);
            evictionPolicy.keyAccessed(key);
        }

    }
}
