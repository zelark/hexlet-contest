package io.hexlet.contest;


import static java.util.stream.Collectors.toList;

import com.google.common.collect.ImmutableSet;
import io.hexlet.contest.solution.Node;
import io.hexlet.contest.solution.PairedTag;
import io.hexlet.contest.solution.SingleTag;
import io.hexlet.contest.solution.Tag;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HtmlBuilder {

  private static final Set<String> SINGLE_TAGS_LIST = ImmutableSet.of("hr", "br","img");

  public String build(List input) {
    return parse(input).toString();
  }

  private Tag parse(List input) {
    Node node = new Node((String) input.get(0));
    input.stream()
        .skip(1)
        .forEach(item -> {
          if (item instanceof String) {
            node.setBody((String) item);
          }
          else if (item instanceof List) {
            List<List> children = (List) item;
            node.setChildren(children.stream().map(this::parse).collect(toList()));
          }
          else if (item instanceof Map) {
            node.setAttributes((Map) item);
          }
        });
    return buildTag(node);
  }

  private Tag buildTag(Node node) {
    return SINGLE_TAGS_LIST.contains(node.getName())
        ? new SingleTag(node.getName(), node.getAttributes())
        : new PairedTag(
            node.getName(),
            node.getAttributes(),
            node.getBody(),
            node.getChildren()
        );
  }
}
