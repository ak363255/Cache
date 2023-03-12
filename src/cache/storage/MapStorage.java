package cache.storage;

import java.util.HashMap;
import java.util.Map;

public class MapStorage implements CacheStorage {

    private Map<String,Object> cacheStorage;
    private int capacity;
    public MapStorage(int capacity){
        this.cacheStorage = new HashMap<>();
        this.capacity = capacity;
    }
    @Override
    public void add(String key, Object value) {
       cacheStorage.put(key,value);
    }

    @Override
    public Object get(String key) {
        return cacheStorage.get(key);
    }

    @Override
    public boolean isCacheStorageFull() {
        return cacheStorage.size() >= capacity;
    }

    @Override
    public void remove(String key) {
       cacheStorage.remove(key);
    }
}
