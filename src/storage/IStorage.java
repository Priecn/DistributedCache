package storage;

public interface IStorage<Key, Value> {
    Value fetch(Key key);
    void add(Key key, Value value);
    void delete(Key key);
}
