package io.hexlet.contest;


import java.util.*;

public class HtmlBuilder {

    private static List<String> singletonTags = Arrays.asList("hr", "hl", "br", "img");

    public String build(List input) {

        StringBuilder result = new StringBuilder();

        String tag = (String) input.get(0);

        result.append("<" + tag);

        Optional<Integer> indexOfAttributeMap = getAttributeMapIndex(input);
        indexOfAttributeMap.ifPresent(index -> {
            ((LinkedHashMap) input.get(index)).entrySet().forEach(attribute ->
                    result.append(" " + ((Map.Entry<String, String>) attribute).getKey()
                            + "=\"" + ((Map.Entry<String, String>) attribute).getValue()+"\""));
        });

        if (singletonTags.contains(tag)) {
            result.append(" />");
        } else {
            result.append(">");
        }


        for (int i = 1; i < input.size(); i++) {
            if (input.get(i) instanceof List) {
                result.append(build((List) input.get(i)));
            }
            if (input.get(i) instanceof String) {
                result.append(input.get(i));
            }
        }

        if (!singletonTags.contains(tag)) {
            result.append("</"+tag+">");
        }

        return result.toString();
    }

    private Optional<Integer> getAttributeMapIndex(List input) {

        for (int i = 0; i < input.size(); i++) {
            if (input.get(i) instanceof LinkedHashMap) return Optional.of(i);
        }
        return Optional.empty();
    }
}
