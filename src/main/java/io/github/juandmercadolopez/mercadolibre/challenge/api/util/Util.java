package io.github.juandmercadolopez.mercadolibre.challenge.api.util;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

public class Util {

  public static Instant getTimestamp() {
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    return timestamp.toInstant();
  }

  public static String[] stringArrayListToStringArray(List<String> dnaRequestArray) {
    String[] dnaArray = new String[dnaRequestArray.size()];
    int index = 0;
    for (String dnaPart : dnaRequestArray) {
      dnaArray[index] = dnaPart;
      index++;
    }
    return dnaArray;
  }
}
