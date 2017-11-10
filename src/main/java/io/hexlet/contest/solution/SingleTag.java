package io.hexlet.contest.solution;

import static java.util.Collections.emptyMap;

import java.util.Map;

public final class SingleTag extends Tag {

  public SingleTag(String name) {
    this(name, emptyMap());
  }

  public SingleTag(String name, Map<String, String> attributes) {
    super(name, attributes);
  }

  @Override
  public String toString() {
    return String.format("<%s%s />", this.getName(), this.attrsToString());
  }
}
