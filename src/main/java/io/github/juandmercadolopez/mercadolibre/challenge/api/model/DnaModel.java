package io.github.juandmercadolopez.mercadolibre.challenge.api.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DnaModel {

  int id;
  String sequence1;
  String sequence2;
  String sequence3;
  String sequence4;
  String sequence5;
  String sequence6;
  boolean mutant;
}
