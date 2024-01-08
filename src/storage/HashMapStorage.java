package storage;

import exception.KeyNotPresentException;
import exception.StorageFullException;

import java.util.HashMap;
import java.util.Map;

public class HashMapStorage implements IStorage<String, String> {

    final private Map<String, String> storage;
    final int capacity;

    public HashMapStorage(int capacity) {
        this.capacity = capacity;
        storage = new HashMap<>();
    }

    @Override
    public String fetch(String key) {
        if (!storage.containsKey(key)) {
            throw new KeyNotPresentException();
        }
        return storage.get(key);
    }

    @Override
    public void add(String key, String value) {
        if (storage.containsKey(key)) {
            storage.put(key, value);
        } else if (this.capacity == storage.size()) {
            throw new StorageFullException();
        }else {
            storage.put(key, value);
        }
    }

    @Override
    public void delete(String key) {
        if (!storage.containsKey(key)) {
            throw new KeyNotPresentException();
        }
        storage.remove(key);
    }
}
