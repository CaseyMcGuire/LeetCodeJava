package main.com.leetcode.problems.problem0297;

import main.com.leetcode.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Codec {

  public String serialize(TreeNode root) {
    StringBuilder serializedTree = new StringBuilder();
    List<TreeNode> curLevel = new ArrayList<>();
    List<TreeNode> nextLevel = new ArrayList<>();
    curLevel.add(root);
    while (!curLevel.isEmpty()) {
      for (TreeNode node : curLevel) {
        if (node == null) {
          serializedTree.append("#,");
        }
        else {
          nextLevel.add(node.left);
          nextLevel.add(node.right);
          serializedTree.append(node.val);
          serializedTree.append(',');
        }
      }
      curLevel = nextLevel;
      nextLevel = new ArrayList<>();
    }
    serializedTree.deleteCharAt(serializedTree.length() - 1);//remove last comma
    return serializedTree.toString();
  }

  public TreeNode deserialize(String data) {
    if (data == null || data.isEmpty()) {
      return null;
    }
    String[] entries = data.split(",");
    int index = 0;
    List<TreeNode> curLevel = new ArrayList<>();
    List<TreeNode> nextLevel = new ArrayList<>();
    TreeNode root = getNode(entries[index]);
    curLevel.add(root);
    index++;
    while (index < entries.length) {
      for (TreeNode node : curLevel) {
        TreeNode left = getNode(entries[index]);
        index++;
        TreeNode right = getNode(entries[index]);
        index++;
        node.left = left;
        node.right = right;
        if (left != null) {
          nextLevel.add(left);
        }
        if (right != null) {
          nextLevel.add(right);
        }
      }
      curLevel = nextLevel;
      nextLevel = new ArrayList<>();
    }
    return root;
  }

  private TreeNode getNode(String entry) {
    if (entry.equals("#")) {
      return null;
    }
    return new TreeNode(Integer.parseInt(entry));
  }
}
