package io.hexlet.contest.solution;

import static java.util.Collections.emptyList;
import static java.util.Collections.emptyMap;
import static java.util.stream.Collectors.joining;

import java.util.List;
import java.util.Map;
import lombok.Getter;

@Getter
public final class PairedTag extends Tag {

  private final List<Object> body;

  public PairedTag(String name) {
    this(name, emptyMap(), emptyList());
  }

  public PairedTag(String name, Map<String, String> attributes) {
    this(name, attributes, emptyList());
  }

  public PairedTag(String name, Map<String, String> attributes, List<Object> body) {
    super(name, attributes);
    this.body = body;
  }

  @Override
  public String toString() {
    final String content = this.getBody().stream().map(Object::toString).collect(joining());
    final String name = this.getName();
    final String attrs = this.attrsToString();
    return String.format("<%s%s>%s</%s>", name, attrs, content, name);
  }
}
