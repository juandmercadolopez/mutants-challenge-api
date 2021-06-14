package io.github.juandmercadolopez.mercadolibre.challenge.api.component;

import io.github.juandmercadolopez.mercadolibre.challenge.api.entity.DnaEntity;
import org.springframework.stereotype.Component;

@Component
public class DnaComponent {

  public DnaEntity buildDnaEntity(String[] dnaArray, boolean mutant) {
    return DnaEntity.builder()
        .sequence1(dnaArray[0])
        .sequence2(dnaArray[1])
        .sequence3(dnaArray[2])
        .sequence4(dnaArray[3])
        .sequence5(dnaArray[4])
        .sequence6(dnaArray[5])
        .mutant(mutant)
        .build();
  }
}
