package io.hexlet.contest.solution;


import static com.google.common.collect.ImmutableMap.of;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.Test;

public class SingleTagTest {

  @Test
  public void testSingleTagRepresentation() {
    SingleTag tag = new SingleTag("a", of("href", "pic.jpg"));

    assertThat(tag.toString()).isEqualTo("<a href=\"pic.jpg\">");
  }
}