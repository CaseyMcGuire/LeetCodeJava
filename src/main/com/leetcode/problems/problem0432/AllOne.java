package main.com.leetcode.problems.problem0432;

import java.util.*;

public class AllOne {

  private final Map<String, Integer> stringToValue;
  private final TreeMap<Integer, Set<String>> valueToKeys;

  /** Initialize your data structure here. */
  public AllOne() {
    stringToValue = new HashMap<>();
    valueToKeys = new TreeMap<>();
  }

  /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
  public void inc(String key) {
    int oldValue = stringToValue.getOrDefault(key, 0);
    int newValue = oldValue + 1;
    if (oldValue != 0) {
      removeValueFromKeys(oldValue, key);
    }
    stringToValue.put(key, newValue);
    Set<String> keys = valueToKeys.getOrDefault(newValue, new HashSet<>());
    keys.add(key);
    valueToKeys.put(newValue, keys);
  }

  /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
  public void dec(String key) {
    Integer oldValue = stringToValue.get(key);
    if (oldValue == null) {
      return;
    }
    removeValueFromKeys(oldValue, key);
    if (oldValue == 1) {
      stringToValue.remove(key);
    }
    else {
      int newValue = oldValue - 1;
      stringToValue.put(key, newValue);
      Set<String> existingKeys = valueToKeys.getOrDefault(newValue, new HashSet<>());
      existingKeys.add(key);
      valueToKeys.put(newValue, existingKeys);
    }
  }

  private void removeValueFromKeys(int value, String key) {
    Set<String> keys = valueToKeys.get(value);
    keys.remove(key);
    if (keys.isEmpty()) {
      valueToKeys.remove(value);
    }
  }

  /** Returns one of the keys with maximal value. */
  public String getMaxKey() {
    if (stringToValue.isEmpty()) {
      return "";
    }
    Set<String> largestKeys = valueToKeys.lastEntry().getValue();
    for (String key : largestKeys) {
      return key;
    }
    return null;
  }

  /** Returns one of the keys with Minimal value. */
  public String getMinKey() {
    if (stringToValue.isEmpty()) {
      return "";
    }
    Set<String> smallestKeys = valueToKeys.firstEntry().getValue();
    for (String key : smallestKeys) {
      return key;
    }
    return null;
  }
}
