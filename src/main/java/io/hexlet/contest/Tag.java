package io.hexlet.contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Tag {

  private List<Object> body = new ArrayList<>();
  private String name;
  private Map<String, String> attrs = new HashMap<>();

  public Tag(String name) {
    this.name = name;
  }

  public void setAttrs(Map attrs) {
    attrs.forEach((key, value) -> checkForString(key, value));
    this.attrs = attrs;
  }

  private void checkForString(Object key, Object value) {
    if (!String.class.isInstance(key) && !String.class.isInstance(value)) {
      throw new IllegalArgumentException("Attributes should be strings key and value!");
    }
  }

  void addBody(Object element) {
    body.add(element);
  }

  public String toString() {
    String attrsString = "";

    if (!this.attrs.isEmpty()) {
      attrsString = this.attrs.entrySet().stream()
          .map(attr -> attr.getKey() + "=\"" + attr.getValue() + "\"")
          .collect(Collectors.joining(" ", " ", ""));
    }

    if (body.isEmpty()) {
      return "<" + name + attrsString + " />";
    } else {
      String begin = "<" + name + attrsString + ">";
      String end = "</" + name + ">";
      StringBuilder bodyBuilder = new StringBuilder(); // :D
      body.forEach(bodyBuilder::append);
      return begin + bodyBuilder + end;
    }
  }
}
