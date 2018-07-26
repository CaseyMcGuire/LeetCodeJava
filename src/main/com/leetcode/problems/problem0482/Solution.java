package main.com.leetcode.problems.problem0482;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {
  public String licenseKeyFormatting(String S, int K) {
    Deque<Character> characterDeque = convertStringToDeque(S);
    List<String> groupedStrings = new ArrayList<>();
    StringBuilder builder = new StringBuilder();
    while (!characterDeque.isEmpty()) {
      if (builder.length() == K) {
        groupedStrings.add(builder.reverse().toString());
        builder = new StringBuilder();
      }
      builder.append(Character.toUpperCase(characterDeque.removeLast()));
    }
    if (builder.length() != 0) {
      groupedStrings.add(builder.reverse().toString());
    }
    StringBuilder formattedLicenseKey = new StringBuilder();
    for (int i = groupedStrings.size() - 1; i >= 0; i--) {

      formattedLicenseKey.append(groupedStrings.get(i));
      if (i != 0) {
        formattedLicenseKey.append('-');
      }
    }
    return formattedLicenseKey.toString();
  }

  private Deque<Character> convertStringToDeque(String s) {
    Deque<Character> characterDeque = new LinkedList<>();
    for (char c : s.toCharArray()) {
      if (c == '-') {
        continue;
      }
      characterDeque.addLast(c);
    }
    return characterDeque;
  }
}
