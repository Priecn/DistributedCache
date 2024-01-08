package eviction_policies;

public interface IEvictionPolicy <Key> {
    void keyAccessed(Key key);
    String evict();
}
