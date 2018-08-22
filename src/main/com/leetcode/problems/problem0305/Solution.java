package main.com.leetcode.problems.problem0305;

import java.util.*;

public class Solution {
  public List<Integer> numIslands2(int m, int n, int[][] positions) {
    Map<Point, Island> pointToIsland = new HashMap<>();
    Map<Island, Island> childToParent = new HashMap<>();
    Set<Island> roots = new HashSet<>();
    List<Point> landToAdd = getLandToAdd(positions);
    List<Integer> numIslandsAtPosition = new ArrayList<>();

    for (Point point : landToAdd) {
      List<Island> islandsToMerge = getIslandsToMerge(point, pointToIsland);
      if (islandsToMerge.isEmpty()) {
        // we're creating a new island
        Island newIsland = new Island();
        newIsland.addPoint(point);
        pointToIsland.put(point, newIsland);
        childToParent.put(newIsland, newIsland);
        roots.add(newIsland);
      }
      else {
        mergeIslands(islandsToMerge, point, childToParent, pointToIsland, roots);
      }
      numIslandsAtPosition.add(roots.size());
    }
    return numIslandsAtPosition;
  }

  private Island compressAndGetRootForIsland(Island island, Map<Island, Island> childToParent) {
    Island curIsland = island;
    List<Island> islands = new ArrayList<>();
    // find the root
    while (!childToParent.get(curIsland).equals(curIsland)) {
      islands.add(curIsland);
      curIsland = childToParent.get(curIsland);
    }

    // now compress all islands along the path
    for (Island isle : islands) {
      childToParent.put(isle, curIsland);
    }
    return curIsland;
  }

  private void mergeIslands(List<Island> islandsToMerge,
                            Point point,
                            Map<Island, Island> childToParent,
                            Map<Point, Island> pointToIsland,
                            Set<Island> roots) {
    List<Island> oldRoots = new ArrayList<>();
    for (Island island : islandsToMerge) {
      oldRoots.add(compressAndGetRootForIsland(island, childToParent));
    }
    for (Island island : oldRoots) {
      roots.remove(island);
      childToParent.remove(island);
    }

    Island newRoot = oldRoots.get(0);
    newRoot.addPoint(point);
    pointToIsland.put(point, newRoot);
    childToParent.put(newRoot, newRoot);
    for (int i = 1; i < oldRoots.size(); i++) {
      Island oldRoot = oldRoots.get(i);
      childToParent.put(oldRoot, newRoot);
    }
    roots.add(newRoot);
  }

  private List<Island> getIslandsToMerge(Point pointToAdd, Map<Point, Island> pointToIsland) {
    Set<Island> islandsToMerge = new HashSet<>();
    for (Point neighbor : pointToAdd.getNeighbors()) {
      Island neighboringIsland = pointToIsland.get(neighbor);
      if (neighboringIsland != null) {
        islandsToMerge.add(neighboringIsland);
      }
    }
    return new ArrayList<>(islandsToMerge);
  }

  public List<Point> getLandToAdd(int[][] positions) {
    List<Point> points = new ArrayList<>();
    for (int[] position : positions) {
      points.add(new Point(position[0], position[1]));
    }
    return points;
  }

  private static class Island {
    private final Set<Point> points;

    Island() {
      points = new HashSet<>();
    }

    void addPoint(Point point) {
      points.add(point);
    }

    @Override
    public int hashCode() {
      return Objects.hash(points);
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (!(o instanceof Island)) {
        return false;
      }
      Island other = (Island)o;
      return other.points.equals(points);
    }
  }

  private static class Point {
    private final int i;
    private final int j;

    Point(int i, int j) {
      this.i = i;
      this.j = j;
    }

    public List<Point> getNeighbors() {
      return Arrays.asList(
          new Point(i + 1, j),
          new Point(i - 1, j),
          new Point(i, j + 1),
          new Point(i, j - 1)
      );
    }

    @Override
    public int hashCode() {
      return Objects.hash(i, j);
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (!( o instanceof Point)) {
        return false;
      }
      Point other = (Point) o;
      return other.i == i && other.j == j;
    }
  }
}
