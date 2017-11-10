package io.hexlet.contest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HtmlBuilder {

  List<String> wow = new ArrayList<>();

  HtmlBuilder() {
    wow.add("br");
    wow.add("img");
    wow.add("hr");
  }

  Object first(List input) {
    try {
      return input.get(0);
    }
    catch (Exception e) {
      return null;
    }
  }

  Object second(List input) {
    try {
      return input.get(1);
    }
    catch (Exception e) {
      return null;
    }
  }

  Object third(List input) {
    try {
      return input.get(2);
    }
    catch (Exception e) {
      return null;
    }
  }

  List rest(List input) {
    return input.subList(1, input.size());
  }


  public String build(List input) {

    String result = "<" + first(input) + "";

    if (second(input) instanceof Map) {
      Map<String, String> params = (Map<String, String>) second(input);

      for (String param : params.keySet()) {
        result += " " + param + "=\"" + params.get(param) + "\"";
      }
    }

    if (wow.contains(first(input))) {
      result += " />";
    }
    else {
      result += ">";
    }

    if (second(input) instanceof Map && third(input) instanceof String) {
      result += third(input);
    }
    if (second(input) instanceof String) {
      result += second(input);
    }

    List other = rest(input);

    if (first(other) instanceof Map) {
      other = rest(other);
    }

    if (first(other) instanceof String) {
      other = rest(other);
    }


    for (Object q : other) {
      if (q instanceof List) {
        result += build((List) q);
      }
      else if (q instanceof String) {
        result += q;
      }
    }


    if (!wow.contains(first(input))) {
      result += "</" + first(input) + ">";
    }

    return result;
  }
}
