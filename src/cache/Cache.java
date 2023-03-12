package cache;

import cache.eviction_strategy.EvictionStrategy;
import cache.storage.CacheStorage;

public class Cache {
    public final EvictionStrategy evictionStrategy;
    public final CacheStorage cacheStorage;
    public  Cache(EvictionStrategy evictionStrategy, CacheStorage cacheStorage){
        this.evictionStrategy = evictionStrategy;
        this.cacheStorage = cacheStorage;
    }
    public void add(String key,Object value){
        if(cacheStorage.isCacheStorageFull()){
            cacheStorage.remove(key);
            evictionStrategy.evictKey();
        }
        cacheStorage.add(key,value);
        evictionStrategy.keyAccessed(key);
    }
    public Object get(String key){
        evictionStrategy.keyAccessed(key);
        return cacheStorage.get(key);
    }
}
