package io.github.juandmercadolopez.mercadolibre.challenge.api.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "dna")
public class DnaEntity {

  @Id
  @GeneratedValue
  @Column(name = "id", nullable = false)
  int id;

  @Column(name = "sequence1", nullable = false, length = 6)
  String sequence1;

  @Column(name = "sequence2", nullable = false, length = 6)
  String sequence2;

  @Column(name = "sequence3", nullable = false, length = 6)
  String sequence3;

  @Column(name = "sequence4", nullable = false, length = 6)
  String sequence4;

  @Column(name = "sequence5", nullable = false, length = 6)
  String sequence5;

  @Column(name = "sequence6", nullable = false, length = 6)
  String sequence6;

  @Column(name = "mutant", nullable = false)
  boolean mutant;
}
