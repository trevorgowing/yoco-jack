package com.trevorgowing;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {
    URL url = new URL("https://s3-eu-west-1.amazonaws.com/yoco-testing/tests.json");
    ObjectMapper objectMapper = new ObjectMapper();
    List<Game> games = objectMapper.readValue(url.openStream(), new TypeReference<List<Game>>(){});
  }
}
