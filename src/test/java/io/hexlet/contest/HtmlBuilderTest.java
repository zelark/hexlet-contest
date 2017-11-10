package io.hexlet.contest;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import lombok.SneakyThrows;
import org.junit.Ignore;
import org.junit.Test;

public class HtmlBuilderTest {

  private ObjectMapper mapper = new ObjectMapper();

  @Test
  @SneakyThrows
  public void test_01() {
    List input = mapper.readValue(
        new File("src/test/resources/test_payload_01.json"),
        ArrayList.class
    );

    String result = new HtmlBuilder().build(input);

    assertThat(result)
        .isEqualTo("<html><head><title>hello, guys!</title></head><body class=\"container\">"
            + "<h1 class=\"header\">html builder example</h1><div>"
            + "<img class=\"image\" src=\"cat.jpg\" /><span>span text <b>lol</b><hr />span text</span>"
            + "</div></body></html>"
        );
  }

  @Test
  @SneakyThrows
  public void test_02() {
    List input = mapper.readValue(
        new File("src/test/resources/test_payload_02.json"),
        ArrayList.class
    );

    String result = new HtmlBuilder().build(input);

    assertThat(result).isEqualTo("<span class=\"foo\" id=\"spam\">bar</span>");
  }
}