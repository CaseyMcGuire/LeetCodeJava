package main.com.other.google.shiftletters;

import java.util.*;

public class Solution {

  public List<List<String>> groupShiftedWords(List<String> words) {
    Map<List<Integer>, List<String>> shiftsToWords = new HashMap<>();
    for (String word : words) {
      List<Integer> shifts = calculateShifts(word);
      List<String> shiftedGroup = shiftsToWords.getOrDefault(shifts, new ArrayList<>());
      shiftedGroup.add(word);
      shiftsToWords.put(shifts, shiftedGroup);
    }
    return new ArrayList<>(shiftsToWords.values());
  }

  private List<Integer> calculateShifts(String word) {
    if (word.length() == 1) {
      return new ArrayList<>();
    }
    List<Integer> shifts = new ArrayList<>();
    for (int i = 0; i < word.length() - 1; i++) {
      int first = word.charAt(i) % 97;
      int second = word.charAt(i + 1) % 97;
      int difference = second - first;
      //have to adjust for wrapping
      if (difference < 0) {
        difference += 26;
      }

      shifts.add(difference);
    }
    return shifts;
  }

  public static void main(String[] args) {
    System.out.println(new Solution().groupShiftedWords(Arrays.asList("abc", "bcd", "yza", "fva", "iyd", "gfd")));
    System.out.println(new Solution().calculateShifts("yza"));
    System.out.println(new Solution().calculateShifts("abc"));
  }
}
