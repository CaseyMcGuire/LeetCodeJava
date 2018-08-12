package main.com.leetcode.problems.problem0460;

import java.util.*;

public class LFUCache {

  private final Map<Integer, Integer> keyToValue;
  private final Map<Integer, Integer> keyToFrequency;
  private final TreeMap<Integer, Set<Integer>> frequencyToKeys;
  private final Map<Integer, Integer> keyToLastTimeUsed;
  private int time;
  private final int capacity;

  public LFUCache(int capacity) {
    this.keyToValue = new HashMap<>();
    this.keyToFrequency = new HashMap<>();
    this.frequencyToKeys = new TreeMap<>();
    this.keyToLastTimeUsed = new HashMap<>();
    this.time = 0;
    this.capacity = capacity;
  }

  public int get(int key) {
    if (capacity <= 0) {
      return -1;
    }
    time++;
    Integer value = keyToValue.get(key);
    if (value == null) {
      return -1;
    }
    int frequency = keyToFrequency.get(key);

    // remove the key from the set of its old frequency
    Set<Integer> keysOfFrequency = frequencyToKeys.get(frequency);
    keysOfFrequency.remove(key);
    if (keysOfFrequency.isEmpty()) {
      frequencyToKeys.remove(frequency);
    }

    // add the key to the set of its new frequency
    int newFrequency = frequency + 1;
    Set<Integer> newKeysOfFrequency = frequencyToKeys.getOrDefault(newFrequency, new HashSet<>());
    newKeysOfFrequency.add(key);
    frequencyToKeys.put(newFrequency, newKeysOfFrequency);


    keyToFrequency.put(key, newFrequency);
    keyToLastTimeUsed.put(key, time);
    time++;

    return value;
  }

  public void put(int key, int value) {
    if (capacity <= 0) {
      return;
    }
    time++;
    int oldValue = get(key);
    if (oldValue != -1) {
      // we're just replacing the old value, no need to worry about capacity
      keyToValue.put(key, value);
      keyToLastTimeUsed.put(key, time);
      return;
    }

    if (keyToValue.size() == capacity) {
      purgeLeastFrequentKey();
    }
    initializeKey(key, value);
  }

  private void purgeLeastFrequentKey() {
    Set<Integer> leastFrequencyKeys = frequencyToKeys.firstEntry().getValue();

    Integer leastRecentlyUsedKey = null;
    Integer leastTime = null;

    for (int key : leastFrequencyKeys) {
      int timeLastUsed = keyToLastTimeUsed.get(key);
      if (leastTime == null || leastTime > timeLastUsed) {
        leastTime = timeLastUsed;
        leastRecentlyUsedKey = key;
      }
    }
    purgekey(leastRecentlyUsedKey);
  }

  private void purgekey(int key) {
    keyToValue.remove(key);
    int frequency = keyToFrequency.remove(key);
    Set<Integer> keysOfFrequency = frequencyToKeys.get(frequency);
    keysOfFrequency.remove(key);
    if (keysOfFrequency.isEmpty()) {
      frequencyToKeys.remove(frequency);
    }
    keyToLastTimeUsed.remove(key);
  }

  private void initializeKey(int key, int value) {
    keyToValue.put(key, value);
    keyToFrequency.put(key, 1);
    Set<Integer> keysOfFrequency = frequencyToKeys.getOrDefault(1, new HashSet<>());
    keysOfFrequency.add(key);
    frequencyToKeys.put(1, keysOfFrequency);
    keyToLastTimeUsed.put(key, time);
  }

  public static void main(String[] args) {
    LFUCache cache = new LFUCache( 2 /* capacity */ );

    cache.put(1, 1);
    cache.put(2, 2);
    cache.get(1);       // returns 1
    cache.put(3, 3);    // evicts key 2
    cache.get(2);       // returns -1 (not found)
    cache.get(3);       // returns 3.
    cache.put(4, 4);    // evicts key 1.
    cache.get(1);       // returns -1 (not found)
    cache.get(3);       // returns 3
    cache.get(4);       // returns 4
  }

  //["LFUCache","put","put","get","get","get","put","put","get","get"]
  //    [[2],[1,1],[2,2],[1],[1],[2],[1,1],[3,3],[1],[3]]
}
