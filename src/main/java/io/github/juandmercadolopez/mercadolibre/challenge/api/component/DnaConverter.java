package io.github.juandmercadolopez.mercadolibre.challenge.api.component;

import io.github.juandmercadolopez.mercadolibre.challenge.api.entity.DnaEntity;
import io.github.juandmercadolopez.mercadolibre.challenge.api.model.DnaModel;
import org.springframework.stereotype.Component;

@Component
public class DnaConverter {

  public DnaEntity convertDnaModelToEntity(DnaModel dnaModel) {
    return DnaEntity.builder()
        .id(dnaModel.getId())
        .sequence1(dnaModel.getSequence1())
        .sequence2(dnaModel.getSequence2())
        .sequence3(dnaModel.getSequence3())
        .sequence4(dnaModel.getSequence4())
        .sequence5(dnaModel.getSequence5())
        .sequence6(dnaModel.getSequence6())
        .mutant(dnaModel.isMutant())
        .build();
  }

  public DnaModel convertDnaEntityToModel(DnaEntity dnaEntity) {
    return DnaModel.builder()
        .id(dnaEntity.getId())
        .sequence1(dnaEntity.getSequence1())
        .sequence2(dnaEntity.getSequence2())
        .sequence3(dnaEntity.getSequence3())
        .sequence4(dnaEntity.getSequence4())
        .sequence5(dnaEntity.getSequence5())
        .sequence6(dnaEntity.getSequence6())
        .mutant(dnaEntity.isMutant())
        .build();
  }
}
