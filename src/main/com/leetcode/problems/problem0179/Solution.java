package main.com.leetcode.problems.problem0179;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
  public String largestNumber(int[] nums) {
    List<String> numbers = new ArrayList<>();
    for (int num : nums) {
      numbers.add(num + "");
    }

    Collections.sort(numbers, this::compare );
    StringBuilder builder = new StringBuilder();
    for (int i = numbers.size() - 1; i >= 0; i--) {
      builder.append(numbers.get(i));
    }
    String num = builder.toString();
    if (num.charAt(0) == '0') {
      return "0";
    }
    return num;
  }

  private int compare(String s1, String s2) {
    int lengthComparision = s1.length() > s2.length() ? s2.length() : s1.length();

    for (int i = 0; i < lengthComparision; i++) {
      int num1 = Character.getNumericValue(s1.charAt(i));
      int num2 = Character.getNumericValue(s2.charAt(i));
      if (num1 < num2) {
        return -1;
      }
      else if (num1 > num2) {
        return 1;
      }
    }
    Integer first = Integer.parseInt(s1 + s2);
    Integer second = Integer.parseInt(s2 + s1);
    return first > second ? 1 : -1;
  }

}
