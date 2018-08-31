package main.com.leetcode.problems.problem0091;

public class Solution {
  public int numDecodings(String s) {
    if (s == null || s.length() == 0 || s.charAt(0) == '0') {
      return 0;
    }
    int[] numDecodings = new int[s.length()];
    for (int i = s.length() - 1; i >= 0; i--) {
      if (i == s.length() - 1) {
        if (s.charAt(i) != '0') {
          numDecodings[i] = 1;
        }
        continue;
      }

      Character oneDigitMapping = getMapping(s.charAt(i));
      Character previousMapping = getMapping(s.charAt(i + 1));
      Character twoDigitMapping = getMapping(s.charAt(i), s.charAt(i + 1));
      if (oneDigitMapping == null && previousMapping == null) {
        return 0;
      }

      if (i == s.length() - 2){
        if (twoDigitMapping != null) {
          numDecodings[i] = 1 + numDecodings[i + 1];
        }
        else {
          numDecodings[i] = numDecodings[i + 1];
        }
      }
      else {
        int currentNumDecodings = 0;
        if (previousMapping != null) {
          currentNumDecodings += numDecodings[i + 1];
        }
        if (twoDigitMapping != null) {
          currentNumDecodings += numDecodings[i + 2];
        }
        numDecodings[i] = currentNumDecodings;
      }
    }
    return numDecodings[0];
  }

  private Character getMapping(char... chars) {
    if (chars[0] == '0') {
      return null;
    }
    String str = new String(chars);
    int n = Integer.parseInt(str);
    char c = (char) (n + 64);
    if (c > 'Z') {
      return null;
    }
    else {
      return c;
    }
  }
}
