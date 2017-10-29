package io.hexlet.contest.solution;

import static com.google.common.collect.ImmutableMap.of;
import static java.util.Arrays.asList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.Test;

public class PairedTagTest {

  @Test
  public void testPairedTagRepresentation() {
    SingleTag img = new SingleTag("img", of("src", "kitty.jpg"));
    PairedTag div = new PairedTag("div", of("class", "main"), asList(img));

    assertThat(div.toString()).isEqualTo("<div class=\"main\"><img src=\"kitty.jpg\"></div>");
  }

}