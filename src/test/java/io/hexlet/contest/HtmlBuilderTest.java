package io.hexlet.contest;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import lombok.SneakyThrows;
import org.junit.Test;

public class HtmlBuilderTest {

  private ObjectMapper mapper = new ObjectMapper();

  @Test
  @SneakyThrows
  public void test() {
    List input = mapper.readValue(
        new File("src/test/resources/test_payload.json"),
        ArrayList.class
    );

    String result = new HtmlBuilder().build(input);

    assertThat(result)
        .isEqualTo("<html><head><title>hello, hexlet!</title></head><body class=\"container\">"
            + "<h1 class=\"header\">html builder example</h1><div>"
            + "<img class=\"image\" src=\"cat.jpg\"><span>span text</span></div></body></html>"
        );
  }
}