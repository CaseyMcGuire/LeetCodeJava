package main.com.leetcode.problems.problem0165;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
  public int compareVersion(String version1, String version2) {
    List<Integer> firstVersion = getVersionNumbers(version1);
    List<Integer> secondVersion = getVersionNumbers(version2);
    int difference = Math.abs(firstVersion.size() - secondVersion.size());
    List<Integer> listToPad;
    if (firstVersion.size() > secondVersion.size()) {
      listToPad = secondVersion;
    }
    else {
      listToPad = firstVersion;
    }
    for (int i = 0; i < difference; i++) {
      listToPad.add(0);
    }
    int length = firstVersion.size();
    for (int i = 0; i < length; i++) {
      if (firstVersion.get(i) < secondVersion.get(i)) {
        return -1;
      }
      else if (firstVersion.get(i) > secondVersion.get(i)) {
        return 1;
      }
    }
    return 0;
  }

  private List<Integer> getVersionNumbers(String version) {
    return Arrays.stream(version.split("\\."))
                 .map(Integer::parseInt)
                 .collect(Collectors.toCollection(ArrayList::new));
  }

}
