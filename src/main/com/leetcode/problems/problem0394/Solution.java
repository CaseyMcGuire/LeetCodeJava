package main.com.leetcode.problems.problem0394;

import java.util.*;

public class Solution {


  public String decodeString(String s) {
    EncodedString encodedString = generateMultiEncodedString("1[" + s + "]");
    return encodedString.decode();
  }

  private EncodedString generateMultiEncodedString(String s) {
    Map<Integer, Integer> startToEnd = getMultiEncodedStringStartToEndMap(s);
    return generateMultiEncodedString(s, 2, s.length() - 1, 1, startToEnd);
  }

  private EncodedString generateMultiEncodedString(String s, int start, int end, int num, Map<Integer, Integer> startToEnd) {
    List<EncodedString> encodedStrings = new ArrayList<>();

    for (int i = start; i < end; i++) {
      if (Character.isAlphabetic(s.charAt(i))) {
        encodedStrings.add(new SimpleEncodedString(s.charAt(i) + ""));
      }
      else {//must be numeric
        StringBuilder nextNumStr = new StringBuilder();
        int iter = i;
        //might have more than one digit.
        while (Character.isDigit(s.charAt(iter))) {
          nextNumStr.append(s.charAt(iter));
          iter++;
        }
        int nextNum = Integer.parseInt(nextNumStr.toString());
        int bracketStart = iter;
        int bracketEnd = startToEnd.get(bracketStart);
        encodedStrings.add(generateMultiEncodedString(s, bracketStart + 1, bracketEnd, nextNum, startToEnd));
        i = bracketEnd;
      }
    }
    return new MultiEncodedString(num, encodedStrings);
  }


  private Map<Integer, Integer> getMultiEncodedStringStartToEndMap(String s) {
    Map<Integer, Integer> startToEnd = new HashMap<>();
    Deque<Integer> starts = new ArrayDeque<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '[') {
        starts.push(i);
      }
      else if (s.charAt(i) == ']') {
        startToEnd.put(starts.pop(), i);
      }
    }
    return startToEnd;
  }

  interface EncodedString {
    String decode();
  }

  static class SimpleEncodedString implements EncodedString {
    private String str;
    public SimpleEncodedString(String str) {
      this.str = str;
    }
    public String decode() {
      return str;
    }
  }

  static class MultiEncodedString implements EncodedString {
    private int num;
    private List<EncodedString> encodedStrings;

    public MultiEncodedString(int num, List<EncodedString> encodedStrings) {
      this.num = num;
      this.encodedStrings = encodedStrings;
    }

    public String decode() {
      StringBuilder single = new StringBuilder();
      for (EncodedString encoded : encodedStrings) {
        single.append(encoded.decode());
      }
      StringBuilder multi = new StringBuilder();
      for (int i = 0; i < num; i++) {
        multi.append(single);
      }
      return multi.toString();
    }
  }

}
