package io.hexlet.contest;


import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HtmlBuilder {

  public String build(List input) {
    return parseTag(input).toString();
  }

  Tag parseTag(List input) {
    Iterator iterator = input.iterator();

    if (!iterator.hasNext()) {
      throw new IllegalArgumentException("Tag must have name!");
    }

    Tag tag = new Tag((String) iterator.next());

    while (iterator.hasNext()) {
      Object tagInfo = iterator.next();
      if (tagInfo instanceof Map) {
        tag.setAttrs((Map) tagInfo);
      } else if (tagInfo instanceof List) {
        tag.addBody(parseTag((List) tagInfo));
      } else {
        tag.addBody(tagInfo);
      }
    }

    return tag;
  }

}
