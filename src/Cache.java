// Cache.java
import java.util.HashMap;
import java.util.Map;

public class Cache<T> {
    private Map<String, T> cache = new HashMap<>();

    public void addItem(String key, T item) {
        cache.put(key, item);
    }

    public T getItem(String key) {
        return cache.get(key);
    }

    public void clear() {
        cache.clear();
    }

    public void addAll(Cache<?> otherCache) {
        for (Map.Entry<?, ?> entry : otherCache.cache.entrySet()) {
            if (entry.getValue() instanceof String) {
                this.cache.put((String) entry.getKey(), (T) entry.getValue());
            } else if (entry.getValue() instanceof Integer && this.cache.isEmpty()) {
                this.cache.put((String) entry.getKey(), (T) entry.getValue());
            }
        }
    }
}