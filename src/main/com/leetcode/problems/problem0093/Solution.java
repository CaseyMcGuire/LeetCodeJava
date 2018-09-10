package main.com.leetcode.problems.problem0093;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<String> restoreIpAddresses(String s) {
    List<String> ipAddresses = new ArrayList<>();
    restoreIpAddresses(s, 0, 0, new IpAddress(), ipAddresses);
    return ipAddresses;
  }

  private void restoreIpAddresses(String s, int start, int depth, IpAddress address, List<String> ipAddresses) {
    if (depth == 4) {
      if (address.length == s.length() && address.isValid()) {
        ipAddresses.add(address.toString());
      }
      return;
    }
    for (int i = 1; i <= 3; i++) {
      int end = start + i;
      if (end > s.length()) {
        return;
      }
      String currentPiece = s.substring(start, end);
      address.add(currentPiece);
      restoreIpAddresses(s, end, depth + 1, address, ipAddresses);
      address.remove();
    }
  }

  private static class IpAddress {
    private List<String> pieces;
    private int length;

    IpAddress() {
      this.pieces = new ArrayList<>();
    }

    public void add(String piece) {
      length += piece.length();
      pieces.add(piece);
    }

    public void remove() {
      length -= pieces.get(pieces.size() - 1).length();
      pieces.remove(pieces.size() - 1);
    }

    public boolean isValid() {
      for (String piece : pieces) {
        if (piece.length() > 1 && piece.startsWith("0") || Integer.parseInt(piece) > 255) {
          return false;
        }
      }
      return true;
    }

    public String toString() {
      StringBuilder builder = new StringBuilder();
      for (int i = 0; i < pieces.size(); i++) {
        builder.append(pieces.get(i));
        if (i != pieces.size() - 1) {
          builder.append(".");
        }
      }
      return builder.toString();
    }
  }
}
