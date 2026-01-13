package warmest.service;

import org.springframework.stereotype.Service;
import warmest.WarmestDataStructure;
import warmest.WarmestDataStructureInterface;

@Service
public class WarmestService {

    // Spring services are singletons by default,
    // so one instance of the data structure is shared between all requests
    private final WarmestDataStructureInterface ds = new WarmestDataStructure();

    // Adds or updates a key-value pair
    public Integer put(String key, int value) {
        return ds.put(key, value);
    }

    // Returns the value for the given key (if exists)
    // and makes this key the warmest
    public Integer get(String key) {
        return ds.get(key);
    }

    // Removes the key from the data structure (if exists)
    public Integer remove(String key) {
        return ds.remove(key);
    }

    // Returns the most recently used key
    public String getWarmest() {
        return ds.getWarmest();
    }
}