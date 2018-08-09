package main.com.leetcode.problems.problem0449;

import com.sun.tools.javac.jvm.Code;
import main.com.leetcode.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Codec {

  public String serialize(TreeNode root) {
    if (root == null) {
      return "";
    }
    StringBuilder serializedTreeBuilder = new StringBuilder();
    List<TreeNode> currentLevel = new ArrayList<>();
    List<TreeNode> nextLevel = new ArrayList<>();
    currentLevel.add(root);
    while (!currentLevel.isEmpty()) {
      for (TreeNode curNode : currentLevel) {
        serializedTreeBuilder.append(curNode == null ? "#" : curNode.val).append(",");
        if (curNode != null) {
          nextLevel.add(curNode.left);
          nextLevel.add(curNode.right);
        }
      }
      currentLevel = nextLevel;
      nextLevel = new ArrayList<>();
    }
    return serializedTreeBuilder.deleteCharAt(serializedTreeBuilder.length() - 1).toString();
  }

  public TreeNode deserialize(String data) {
    if (data.isEmpty() || data.equals("#")) {
      return null;
    }
    String[] tokens = data.split(",");
    TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));
    List<TreeNode> currentLevel = new ArrayList<>();
    currentLevel.add(root);
    List<TreeNode> nextLevel = new ArrayList<>();
    int index = 1;
    while (!currentLevel.isEmpty() && index < tokens.length) {
      for (TreeNode node : currentLevel) {
        TreeNode leftChild = parseToken(tokens[index]);
        node.left = leftChild;
        if (leftChild != null) {
          nextLevel.add(leftChild);
        }
        index++;

        TreeNode rightChild = parseToken(tokens[index]);
        node.right = rightChild;
        if (rightChild != null) {
          nextLevel.add(rightChild);
        }
        index++;
      }
      currentLevel = nextLevel;
      nextLevel = new ArrayList<>();
    }
    return root;
  }

  private TreeNode parseToken(String token) {
    return token.equals("#") ? null : new TreeNode(Integer.parseInt(token));
  }

  public static void main(String[] args) {
    Codec codec = new Codec();
    System.out.println(codec.serialize(codec.deserialize("2,1,3")));
  }

}
