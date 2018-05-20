package main.com.leetcode.problems.problem0681;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

public class Solution {
  public String nextClosestTime(String time) {
    TreeSet<Integer> numsInTime = new TreeSet<>();
    List<Integer> timeList = new ArrayList<>();
    for (char c : time.toCharArray()) {
      if (c == ':') {
        continue;
      }
      int digit = Character.getNumericValue(c);
      numsInTime.add(digit);
      timeList.add(digit);
    }

    Integer changedIndex = null;
    for (int i = timeList.size() - 1; i >= 0; i--) {
      int highestPossibleNum = getHighestDigitForTimePlace(timeList, i);
      NavigableSet<Integer> higherPossibleNums = numsInTime.subSet(timeList.get(i), false, highestPossibleNum, true);
      if (!higherPossibleNums.isEmpty()) {
        changedIndex = i;
        timeList.set(i, higherPossibleNums.pollFirst());
        break;
      }
    }
    boolean canCreateNextHighestNum = changedIndex != null;
    if (canCreateNextHighestNum) {
      for (int i = changedIndex + 1; i < timeList.size(); i++) {
        timeList.set(i, numsInTime.first());
      }
      return new StringBuilder()
          .append(timeList.get(0))
          .append(timeList.get(1))
          .append(':')
          .append(timeList.get(2))
          .append(timeList.get(3))
          .toString();
    }
    //we couldn't find a higher time, so let's find the lowest smaller time
    int lowestDigit = numsInTime.first();
    return new StringBuilder()
        .append(lowestDigit)
        .append(lowestDigit)
        .append(':')
        .append(lowestDigit)
        .append(lowestDigit)
        .toString();

  }

  private int getHighestDigitForTimePlace(List<Integer> time, int index) {
    switch (index) {
      case 3:
        return 9;
      case 2:
        return 5;
      case 1:
        if (time.get(0) <= 1) {
          return 9;
        }
        else {
          return 3;
        }
      case 0:
        return 2;
      default:
        throw new IllegalArgumentException();
    }
  }
}
