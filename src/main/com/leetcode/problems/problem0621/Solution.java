package main.com.leetcode.problems.problem0621;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
  public int leastInterval(char[] tasks, int n) {
    PriorityQueue<Task> taskPriority = getTaskQueue(tasks);
    PriorityQueue<Task> idleTaskPriority = new PriorityQueue<>(Comparator.comparingInt(o -> o.timeLastRun));
    int numIntervals = 0;
    while (!taskPriority.isEmpty() || !idleTaskPriority.isEmpty()) {
      while (!idleTaskPriority.isEmpty() && idleTaskPriority.peek().timeLastRun + n + 1 <= numIntervals) {
        taskPriority.add(idleTaskPriority.poll());
      }
      if (!taskPriority.isEmpty()) {
        Task currentTask = taskPriority.poll();
        currentTask.timeLastRun = numIntervals;
        if (currentTask.num != 1) {
          currentTask.num--;
          idleTaskPriority.add(currentTask);
        }
      }
      numIntervals++;
    }
    return numIntervals;
  }

  private PriorityQueue<Task> getTaskQueue(char[] tasks) {
    Map<Character, Integer> taskNameToNumOccurrences = new HashMap<>();
    for (char c : tasks) {
      taskNameToNumOccurrences.merge(c, 1, (cur, iter) -> cur + iter);
    }

    return taskNameToNumOccurrences.entrySet()
                                   .stream()
                                   .map(entry -> new Task(entry.getValue(), entry.getKey()))
                                   .collect(Collectors.toCollection(PriorityQueue::new));
  }

  private static class Task implements Comparable<Task> {
    private int num;
    private char name;
    private int timeLastRun;

    public Task(int num, char name) {
      this.num = num;
      this.name = name;
      this.timeLastRun = 0;
    }

    @Override
    public int compareTo(Task o) {
      return o.num - this.num;
    }
  }

}
