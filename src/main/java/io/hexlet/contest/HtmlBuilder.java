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

  String first(List input) {
    return (String) input.get(0);
  }

  List rest(List input) {
    return input.subList(1, input.size());
  }



  public String build(List input) {

    String result = "<" + first(input) + "";

    if (input.get(1) instanceof Map) {
      Map<String, String> params = (Map<String, String>) input.get(1);

      for (String param : params.keySet()) {
        result += " " + param + "=\"" + params.get(param) + "\"";
      }

      result += ">";

      if (input.get(2) instanceof String) {
        result += input.get(2);
      }
      else {
        result += build((List) input.get(2));
      }
      return result + "</" + first(input) + ">";
    }
    else {
      result += ">";

      if (input.get(1) instanceof String) {
        result += input.get(1);
      }
      else {
        result += build((List) input.get(1));
      }
      return result + "</" + first(input) + ">";
    }
  }


}
