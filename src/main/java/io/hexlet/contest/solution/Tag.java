package io.hexlet.contest.solution;

import java.util.Map;
import java.util.StringJoiner;
import lombok.Getter;

public abstract class Tag {
  @Getter private final String name;
  private final Map<String, String> attributes;

  public Tag(String name, Map<String, String> attributes) {
    this.name = name;
    this.attributes = attributes;
  }

  public String attrsToString() {
    StringJoiner joiner = new StringJoiner("");
    this.attributes.forEach((k, v) -> joiner.add(String.format(" %s=\"%s\"", k, v)));
    return joiner.toString();
  }
}
