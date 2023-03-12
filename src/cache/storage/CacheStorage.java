package cache.storage;

public interface CacheStorage {
    public void add(String key,Object value);
    public Object get(String key);
    public boolean isCacheStorageFull();
    public void remove(String key);
}
