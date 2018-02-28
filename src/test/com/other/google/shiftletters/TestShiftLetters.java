package test.com.other.google.shiftletters;

import main.com.other.google.shiftletters.Solution;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;

public class TestShiftLetters {

  private static Solution solution;

  @BeforeClass
  public static void setup() {
    solution = new Solution();
  }

  @Test
  public void testBasicCase() {
    Set<List<String>> answer = new HashSet<>();
    answer.addAll(Arrays.asList(Arrays.asList("gfd"), Arrays.asList("abc", "bcd", "yza"), Arrays.asList("fva", "iyd")));

    List<String> words = Arrays.asList("abc", "bcd", "yza", "fva", "iyd", "gfd");
    Assert.assertEquals(answer, new HashSet<>(solution.groupShiftedWords(words)));
  }

  @Test
  public void testSingleWord() {
    Set<List<String>> answer = new HashSet<>();
    answer.addAll(Arrays.asList(Arrays.asList("a", "b", "d")));

    List<String> words = Arrays.asList("a", "b", "d");
    Assert.assertEquals(answer, new HashSet<>(solution.groupShiftedWords(words)));
  }

  @Test
  public void testWrappingWords() {
    Set<List<String>> answer = new HashSet<>();
    answer.addAll(Arrays.asList(Arrays.asList("xa", "yb", "zc", "ad", "nq"), Arrays.asList("da")));

    List<String> words = Arrays.asList("xa", "yb", "zc", "da", "ad", "nq" );
    Assert.assertEquals(answer, new HashSet<>(solution.groupShiftedWords(words)));
  }
}
