package main.com.leetcode.problems.problem0218;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
  public List<int[]> getSkyline(int[][] buildings) {
    if (buildings.length == 0) {
      return Collections.emptyList();
    }
    List<Building> buildingList = getBuildings(buildings);
    TreeMap<Integer, Set<Building>> rightToBuildings = new TreeMap<>();
    TreeMap<Integer, Set<Building>> leftToBuildings = new TreeMap<>();

    for (Building building : buildingList) {
      Set<Building> leftBuildings = leftToBuildings.getOrDefault(building.left, new HashSet<>());
      leftBuildings.add(building);
      Set<Building> rightBuildings = rightToBuildings.getOrDefault(building.right, new HashSet<>());
      rightBuildings.add(building);
      rightToBuildings.put(building.right, rightBuildings);
      leftToBuildings.put(building.left, leftBuildings);
    }

    List<Point> points = new ArrayList<>();
    TreeSet<Building> orderedBuildings = new TreeSet<>();
    int length = getLength(buildingList);
    int previousHeight = 0;
    for (int i = 0; i < length; i = getNextIndex(i, buildingList, leftToBuildings, rightToBuildings)) {
      Set<Building> buildingsToAdd = leftToBuildings.getOrDefault(i, new HashSet<>());
      Set<Building> buildingsToRemove = rightToBuildings.getOrDefault(i, new HashSet<>());
      orderedBuildings.removeAll(buildingsToRemove);
      orderedBuildings.addAll(buildingsToAdd);


      int height = 0;
      if (!orderedBuildings.isEmpty()) {
        height = orderedBuildings.last().height;
      }

      if (height != previousHeight) {
        points.add(new Point(i, height));
      }
      previousHeight = height;
    }
    points.add(new Point(length, 0));
    return points.stream().map(Point::getAsArray).collect(Collectors.toList());
  }

  private int getNextIndex(int index, List<Building> buildings, TreeMap<Integer, Set<Building>> leftToBuildings, TreeMap<Integer, Set<Building>> rightToBuilding) {
    Map.Entry<Integer, Set<Building>> closestLeft = leftToBuildings.higherEntry(index);
    Map.Entry<Integer, Set<Building>> closestRight = rightToBuilding.higherEntry(index);
    if (closestLeft == null && closestRight == null) {
      return getLength(buildings);
    }
    else if (closestLeft == null) {
      return closestRight.getKey();
    }
    else if (closestRight == null) {
      return closestLeft.getKey();
    }
    else {
      return Math.min(closestLeft.getKey(), closestRight.getKey());
    }
  }

  private int getLength(List<Building> buildings) {
    int right = 0;
    for (Building building : buildings) {
      right = Math.max(right, building.right);
    }
    return right;
  }

  private List<Building> getBuildings(int[][] buildings) {
    List<Building> buildingList = new ArrayList<>();
    for (int[] buildingElems : buildings) {
      Building building = new Building(buildingElems[0], buildingElems[1], buildingElems[2]);
      buildingList.add(building);
    }
    return buildingList;
  }

  private static class Building implements Comparable<Building> {
    private int left;
    private int right;
    private int height;

    Building(int left, int right, int height) {
      this.left = left;
      this.right = right;
      this.height = height;
    }

    public int compareTo(Building other) {
      if (other.height == height) {
        return 0;
      }
      else if (height > other.height) {
        return 1;
      }
      else {
        return -1;
      }
    }
  }

  private static class Point {
    private int x;
    private int y;

    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    int[] getAsArray() {
      return new int[]{x, y};
    }

    public String toString() {
      return "[" + x + ", " + y + "]";
    }
  }
}
