package io.hexlet.contest;

import io.hexlet.contest.solution.Node;
import io.hexlet.contest.solution.PairedTag;
import io.hexlet.contest.solution.SingleTag;
import io.hexlet.contest.solution.Tag;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HtmlBuilder {

  public String build(List input) {
    return parse(input).toString();
  }

  private Tag parse(List input) {
    Node node = new Node((String) input.get(0));
    final List<Object> body = new ArrayList<>();
    input.stream()
        .skip(1)
        .forEach(item -> {
          if (item instanceof Map) {
            node.setAttributes((Map) item);
          }
          else if (item instanceof String) {
            body.add(item);
          }
          else if (item instanceof List) {
            body.add(parse((List) item));
          }
        });
    node.setBody(body);
    return buildTag(node);
  }

  private Tag buildTag(Node node) {
    return node.getBody().isEmpty()
        ? new SingleTag(node.getName(), node.getAttributes())
        : new PairedTag(node.getName(), node.getAttributes(), node.getBody());
  }
}
