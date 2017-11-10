package io.hexlet.contest;

import java.util.List;
import java.util.Map;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
public class Tree {

  @NonNull
  private final String tag;
  private final Map<String, String> attrs;
  private final List inner;
}
