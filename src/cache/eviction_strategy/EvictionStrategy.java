package cache.eviction_strategy;

public interface EvictionStrategy {
    public void keyAccessed(String key);
    public String evictKey();
}
