package main.com.leetcode.problems.problem0824;

public class Solution {
  public String toGoatLatin(String S) {
    String[] words = S.split(" ");
    StringBuilder goatLatinSentence = new StringBuilder();
    for (int i = 0; i < words.length; i++) {
      goatLatinSentence.append(transformWord(words[i], i));
      if (i != words.length - 1) {
        goatLatinSentence.append(" ");
      }
    }
    return goatLatinSentence.toString();
  }

  private String transformWord(String word, int index) {
    boolean startsWithVowel = startsWithVowel(word);
    StringBuilder transformedWord = new StringBuilder();
    if (startsWithVowel) {
      transformedWord.append(word);
    }
    else {
      transformedWord.append(word.substring(1)).append(word.charAt(0));
    }
    transformedWord.append("ma");
    for (int i = 0; i < index + 1; i++) {
      transformedWord.append('a');
    }
    return transformedWord.toString();
  }

  private boolean startsWithVowel(String word) {
    char firstLetter = Character.toLowerCase(word.charAt(0));
    switch (firstLetter) {
      case 'a':
      case 'i':
      case 'e':
      case 'u':
      case 'o':
        return true;
      default:
        return false;
    }
  }
}
