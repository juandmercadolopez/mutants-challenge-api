package io.github.juandmercadolopez.mercadolibre.challenge.api.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Generated
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DnaResponse {
  Instant timestamp;
  int status;
  String error;
}
