package main.com.leetcode.problems.problem0146;

import java.util.*;

public class LRUCache {

  private int currentTime;
  private int capacity;
  private Map<Integer, CacheValue> elements;
  private TreeMap<Integer, Integer> timeLastAccessedToKey;

  public LRUCache(int capacity) {
    this.currentTime = 0;
    this.capacity = capacity;
    elements = new HashMap<>();
    timeLastAccessedToKey = new TreeMap<>();
  }

  public int get(int key) {

    CacheValue value = elements.get(key);
    if (value == null) {
      return -1;
    }
    int cachedValue = value.value;
    int timeLastAccessed = value.timeLastAccessed;
    value.timeLastAccessed = currentTime;
    timeLastAccessedToKey.remove(timeLastAccessed);
    timeLastAccessedToKey.put(currentTime, key);
    currentTime++;
    return cachedValue;
  }

  public void put(int key, int value) {

    CacheValue cacheValue = elements.get(key);

    if (cacheValue != null) {
      //we just need to update the value
      cacheValue.value = value;
      int prevTime = cacheValue.timeLastAccessed;
      cacheValue.timeLastAccessed = currentTime;
      timeLastAccessedToKey.remove(prevTime);
      timeLastAccessedToKey.put(currentTime, key);
    }
    else {
      if (elements.size() == capacity) {
        Map.Entry<Integer, Integer> leastRecentlyUsedEntry = timeLastAccessedToKey.firstEntry();
        timeLastAccessedToKey.remove(leastRecentlyUsedEntry.getKey());
        elements.remove(leastRecentlyUsedEntry.getValue());
      }
      CacheValue newValue = new CacheValue(value, currentTime);
      elements.put(key, newValue);
      timeLastAccessedToKey.put(currentTime, key);
    }
    currentTime++;
  }

  private static class CacheValue {
    private int value;
    private int timeLastAccessed;

    CacheValue(int value, int timeLastAccessed) {
      this.value = value;
      this.timeLastAccessed = timeLastAccessed;
    }
  }
}
