package cache;

public interface ICache<Key, Value> {
    Value get(Key key);
    void put(Key key, Value value);
}
