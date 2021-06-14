package io.github.juandmercadolopez.mercadolibre.challenge.api.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DnaRequest {

  List<String> dna;
}
