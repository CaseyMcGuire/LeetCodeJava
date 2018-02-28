package test.com.leetcode.problems;

import main.com.leetcode.datastructures.ListNode;
import main.com.leetcode.problems.problem0025.Solution;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestProblem0025 {

  private static Solution solution;

  @BeforeClass
  public static void setup() {
    solution = new Solution();
  }

  @Test
  public void testEmptyList() {
    Assert.assertNull(solution.reverseKGroup(null, 3));
  }

  @Test
  public void testNonReversedList() {
    ListNode list = ListNode.asList(1, 2, 3, 4, 5);
    Assert.assertEquals(list, solution.reverseKGroup(list, 1));
  }

  @Test
  public void testEntireReversedList() {
    ListNode list = ListNode.asList(1, 2, 3, 4, 5);
    ListNode expected = ListNode.asList(5, 4, 3, 2, 1);
    Assert.assertEquals(expected, solution.reverseKGroup(list, 5));
  }

  @Test
  public void testSmallList() {
    ListNode list = ListNode.asList(1, 2, 3, 4, 5);
    ListNode expected = ListNode.asList(2, 1, 4, 3, 5);
    Assert.assertEquals(expected, solution.reverseKGroup(list, 2));
  }

  @Test
  public void testLargerGroupThanList() {
    ListNode list = ListNode.asList(1, 2);
    ListNode expected = ListNode.asList(1, 2);
    Assert.assertEquals(expected, solution.reverseKGroup(list, 3));
  }
}
