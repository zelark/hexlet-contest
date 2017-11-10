package io.hexlet.contest;


import io.hexlet.contest.Tree.TreeBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HtmlBuilder {

  public String build(List input) {
    return formatTree(buildTree(input));
  }

  private Tree buildTree(List input) {

    if (input == null || input.isEmpty()) {
      throw new IllegalArgumentException("Tag must be not null in " + input);
    }

    String tagName = (String) input.get(0);
    TreeBuilder treeBuilder = Tree.builder().tag(tagName);
    List inner = new ArrayList<>();

    for (int i = 1; i < input.size(); i++) {

      Object content = input.get(i);
      if (content instanceof Map) {
        treeBuilder.attrs((Map) content);
      }
      if (content instanceof List) {
        inner.add(buildTree((List) content));
      }
      if (content instanceof String) {
        inner.add(content);
      }
    }

    treeBuilder.inner(inner);
    return treeBuilder.build();
  }

  private String formatTree(Tree html) {

    String tag = html.getTag();
    boolean isSingleTag = tag.equals("img") || tag.equals("br") || tag.equals("hr");

    StringBuilder result = new StringBuilder();
    result.append("<");
    result.append(tag);
    result.append(formatAttrs(html));
    if (isSingleTag) {
      result.append(" /");
    }
    result.append(">");

    result.append(formatInner(html));

    if (!isSingleTag) {
      result.append("</");
      result.append(tag);
      result.append(">");
    }
    return result.toString();
  }

  private String formatAttrs(Tree html) {

    StringBuilder result = new StringBuilder();

    if (html.getAttrs() != null && !html.getAttrs().isEmpty()) {
      html.getAttrs().forEach((k,v) -> result.append(" ").append(k).append("=\"").append(v).append("\""));
    }
    return result.toString();
  }

  private String formatInner(Tree html) {

    StringBuilder result = new StringBuilder();

    if (html.getInner() != null && !html.getInner().isEmpty()) {
      html.getInner().forEach(inner -> {
        if (inner instanceof String)
          result.append(inner);
        else
          result.append(formatTree((Tree) inner));
      });
    }
    return result.toString();
  }
}