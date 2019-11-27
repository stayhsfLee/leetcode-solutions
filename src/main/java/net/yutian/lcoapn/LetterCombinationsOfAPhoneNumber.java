package net.yutian.lcoapn;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
  private static char[][] numberLetterMappings =
      new char[][] {
        {'a', 'b', 'c'},
        {'d', 'e', 'f'},
        {'g', 'h', 'i'},
        {'j', 'k', 'l'},
        {'m', 'n', 'o'},
        {'p', 'q', 'r', 's'},
        {'t', 'u', 'v'},
        {'w', 'x', 'y', 'z'}
      };

  public List<String> letterCombinations(String digits) {
      if ("".equals(digits)) {
          return Collections.emptyList();
      }
      char[] ds = digits.toCharArray();

      Node root = new Node(null);
      List<Node> currentLayer = new LinkedList<>();
      currentLayer.add(root);
      for(char c : ds) {
          char[] cs = numberLetterMappings[Integer.valueOf(""  + c) - 2];
          List<Node> nodeList = convertToList(cs);
          for(Node node : currentLayer) {
              node.subNodes = nodeList;
          }
          currentLayer = nodeList;
      }

      List<String> finalResult = new LinkedList<>();
      depthFirst(root, "", finalResult);

      return finalResult;
  }

  class Node{
      Character me;
      List<Node> subNodes;

      public Node(Character me) {
          this.me = me;
      }
  }

  public List<Node> convertToList(char[] cs) {
      List<Node> list = new LinkedList<>();
      for(char c : cs) {
          list.add(new Node(c));
      }
      return list;
  }

  public void depthFirst(Node root, String prefix, List<String> finalResult) {
      if (root.subNodes == null) {
          finalResult.add(prefix + root.me);
          return;
      }
      for (Node node : root.subNodes) {
          depthFirst(node, prefix  + ( root.me == null ? "" :  root.me), finalResult);
      }
  }
}
