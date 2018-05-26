package main.com.leetcode.problems.problem0535;

import java.util.HashMap;
import java.util.Map;

public class Codec {

  private Map<String, String> longToShort;
  private Map<String, String> shortToLong;
  private StringBuilder currentEncoding;

  public Codec() {
    longToShort = new HashMap<>();
    shortToLong = new HashMap<>();
    currentEncoding = new StringBuilder("a");
  }

  public String encode(String longUrl) {
    String shortEncoding = longToShort.get(longUrl);
    if (shortEncoding != null) {
      return shortEncoding;
    }
    String encoding = getShortUrl();
    longToShort.put(longUrl, encoding);
    shortToLong.put(encoding, longUrl);
    incrementEncoding();
    return encoding;
  }

  public String decode(String shortUrl) {
    return shortToLong.get(shortUrl);
  }

  private String getShortUrl() {
    return "http://tinyurl.com/" + currentEncoding.toString();
  }

  private void incrementEncoding() {
    char lastChar = currentEncoding.charAt(currentEncoding.length() - 1);
    if (lastChar == '9') {
      currentEncoding.append('a');
    }
    else if (lastChar >= 'a' && lastChar < 'z' ||
             lastChar >= 'A' && lastChar < 'Z' ||
             lastChar >= '0' && lastChar < '9') {
      setLastChar((char) (lastChar + 1));
    }
    else if (lastChar == 'z') {
      setLastChar('A');
    }
    else { // lastChar == 'Z'
      setLastChar('0');
    }
  }

  private void setLastChar(char c) {
    currentEncoding.setCharAt(currentEncoding.length() - 1, c);
  }
}
