package io.hexlet.contest.solution;

import static java.util.Collections.emptyList;
import static java.util.Collections.emptyMap;
import static java.util.stream.Collectors.joining;

import java.util.List;
import java.util.Map;

public final class PairedTag extends Tag {

  private final String body;
  private final List<? extends Tag> children;

  public PairedTag(String name) {
    this(name, emptyMap(), "", emptyList());
  }

  public PairedTag(String name, Map<String, String> attributes) {
    this(name, attributes, "", emptyList());
  }

  public PairedTag(String name, Map<String, String> attributes, String body) {
    this(name, attributes, body, emptyList());
  }

  public PairedTag(String name, Map<String, String> attributes, List<? extends Tag> children) {
    this(name, attributes, "", children);
  }

  public PairedTag(String name, Map<String, String> attributes, String body,
      List<? extends Tag> children) {
    super(name, attributes);
    this.body = body;
    this. children = children;
  }

  @Override
  public String toString() {
    final String content = children.isEmpty()
        ? body
        : children.stream().map(Tag::toString).collect(joining());
    final String name = this.getName();
    final String attrs = this.attrsToString();
    return String.format("<%s%s>%s</%s>", name, attrs, content, name);
  }
}
