package io.github.juandmercadolopez.mercadolibre.challenge.api.util;

import java.sql.Timestamp;
import java.time.Instant;

public class Util {

  public static Instant getTimestamp() {
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    return timestamp.toInstant();
  }
}
