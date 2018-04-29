package main.com.leetcode.problems.problem406;

import java.util.*;

public class Solution {
  public int[][] reconstructQueue(int[][] people) {
    List<Person> randomPeople = new ArrayList<>();
    for (int[] person : people) {
      randomPeople.add(new Person(person[0], person[1]));
    }
    List<Person> orderedPeople = new ArrayList<>();
    for (int i = 0; i < randomPeople.size(); i++) {
      orderedPeople.add(null);
    }
    Collections.sort(randomPeople);
    for (Person person : randomPeople) {
      int curNumTallerInFront = 0;
      int i = 0;
      while (curNumTallerInFront < person.numTallerInFront) {
        if (orderedPeople.get(i) == null || orderedPeople.get(i).height >= person.height) {
          curNumTallerInFront++;
        }
        i++;
      }
      //we need to find the first unoccupied spot
      while (orderedPeople.get(i) != null) {
        i++;
      }
      orderedPeople.set(i, person);
    }
    int[][] ordered = new int[orderedPeople.size()][];
    for (int i = 0; i < orderedPeople.size(); i++) {
      ordered[i] = new int[] {orderedPeople.get(i).height, orderedPeople.get(i).numTallerInFront};
    }
    return ordered;
  }


  private static class Person implements Comparable<Person> {
    int height;
    int numTallerInFront;

    public Person(int height, int numTallerInFront) {
      this.height = height;
      this.numTallerInFront = numTallerInFront;
    }

    @Override
    public int compareTo(Person o) {
      int heightDifference = this.height - o.height;
      if (heightDifference != 0) {
        return heightDifference;
      }
      return this.numTallerInFront - o.numTallerInFront;
    }
  }
}
