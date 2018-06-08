package main.com.leetcode.problems.problem0380;

import java.util.*;

public class RandomizedSet {

  private Map<Integer, Integer> valToIndex;
  private Map<Integer, Integer> indexToVal;
  private Deque<Integer> removedIndices;
  private int currentIndex;
  private final Random random;

  public RandomizedSet() {
    valToIndex = new HashMap<>();
    indexToVal = new HashMap<>();
    removedIndices = new ArrayDeque<>();
    currentIndex = 0;
    random = new Random();
  }

  public boolean insert(int val) {
    if (valToIndex.containsKey(val)) {
      return false;
    }
    int index;
    if (!removedIndices.isEmpty()) {
      index = removedIndices.pop();
    }
    else {
      index = currentIndex;
      currentIndex++;
    }
    valToIndex.put(val, index);
    indexToVal.put(index, val);
    return true;
  }

  public boolean remove(int val) {
    Integer index = valToIndex.get(val);
    if (index == null) {
      return false;
    }
    valToIndex.remove(val);
    indexToVal.remove(index);
    removedIndices.push(index);
    return true;
  }

  // not 100% sure this is O(1) amortized.
  public int getRandom() {
    consolidateSetIfNecessary();
    Integer randomElement = null;
    while (randomElement == null) {
      int randomIndex = random.nextInt(currentIndex + 1);
      randomElement = indexToVal.get(randomIndex);
    }
    return randomElement;
  }

  private void consolidateSetIfNecessary() {
    boolean shouldConsolidate = removedIndices.size() >= (currentIndex / 4);
    if (!shouldConsolidate) {
      return;
    }
    Set<Integer> values = valToIndex.keySet();
    valToIndex = new HashMap<>();
    indexToVal = new HashMap<>();
    removedIndices = new ArrayDeque<>();
    for (Integer val : values) {
      insert(val);
    }
  }
}
