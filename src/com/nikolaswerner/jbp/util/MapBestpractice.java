package com.nikolaswerner.jbp.util;

import java.util.Collection;
import java.util.Map;

/**
 * This file contains multiple methods that should show you what the best practice for handling Maps is.
 * @author nikolaswerner
 */
public class MapBestpractice<K,V>  {
    /*
    * There are several different methods to iterate over a map.
    * Each one has distinct advantages and disadvatages.
    */
    public void iterateOverTheWholeMap(Map<K,V> pMap) {
        // Very bad way of iterating over the whole map when you need all key-value-pairs
        for(K key : pMap.keySet()) { // First you´e reading the whole keyset and iterate over it
            V value = pMap.get(key); // Afterwards each key has to be searched in the map, this is very slow even for small maps
            // Do more things
            System.out.println(key + " - " +value);
        }
        // in generall you should avoid reading the values of the map as little as possible as this is a very expensive operation.
        
        // Better way of getting the same result
        for(Map.Entry<K,V> entry : pMap.entrySet()) { // Here only one read is done and afterwards you´l get all values.
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        
        // Doing the same thing in Java 8, the .stream() call is optional
        pMap.entrySet().forEach((entry) -> {System.out.println(entry.getKey() + " - " + entry.getValue());});
    }
    
    /*
    * This is valid when you know the keys that you want to remove in any kind of Collection
    */
    public void removeKeysFromMap(Map<K,V> pMap, Collection<K> keys) {
        // Bad way of takling the problem, you waste a lot of time while iterating over the key-Collection
        for(K key : keys) {
            pMap.remove(key); // And afterwards each key has to be searched in the key-Set of the map and removed
        }
        
        // This way is much more elegant:
        pMap.keySet().removeAll(keys); // It does the same thing, just in one operation and doesn´t waste time with the for-loop
    }
    
    /*
    * Removing values from a map is not very common, but can be a hustle. I want to show a basic way how to do it very effecient
    */
    public void removeValuesFromMap(Map<K,V> pMap, Collection<V> values) {
        // This is how a lof of people actually try to solve the problem
        // First they´ll iterate over the whole value-collection
        for(V value : values) {
            if(pMap.containsValue(value)) { // Check if the value is actually inside the map
                K key = null;
                for(Map.Entry<K,V> entry : pMap.entrySet()) { // itereate over all entries 
                    if(entry.getValue().equals(value)) { // once the entry is found, save the key and stop searching for it
                        key = entry.getKey();
                        break;
                    }
                }
                if(key != null) { // if the key was found, remove it
                    pMap.remove(key);
                }
            }
        }
        
        // This way is much more elegant:
        pMap.values().removeAll(values);
    }
}
