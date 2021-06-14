package io.github.juandmercadolopez.mercadolibre.challenge.api.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StatModel {
  int humansDna;
  int mutantsDna;
  double ratio;
}
