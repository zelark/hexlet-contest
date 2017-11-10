package io.hexlet.contest.solution;

import static java.util.Collections.emptyList;
import static java.util.Collections.emptyMap;

import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node {
  private String name;
  private Map<String, String> attributes;
  private List<Object> body;

  public Node(String name) {
    this.name = name;
    this.attributes = emptyMap();
    this.body = emptyList();
  }
}
