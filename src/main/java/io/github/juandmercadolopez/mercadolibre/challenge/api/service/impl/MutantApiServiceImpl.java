package io.github.juandmercadolopez.mercadolibre.challenge.api.service.impl;

import io.github.juandmercadolopez.mercadolibre.challenge.api.component.DnaComponent;
import io.github.juandmercadolopez.mercadolibre.challenge.api.model.StatModel;
import io.github.juandmercadolopez.mercadolibre.challenge.api.repository.DnaRepository;
import io.github.juandmercadolopez.mercadolibre.challenge.api.service.MutantApiService;
import io.github.juandmercadolopez.mercadolibre.challenge.api.util.Util;
import mercadolibre.challenge.core.controller.Mutant;
import mercadolibre.challenge.core.exception.DnaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MutantApiServiceImpl implements MutantApiService {

  @Autowired DnaComponent dnaComponent;

  @Autowired DnaRepository dnaRepository;

  Mutant mutant;

  @Override
  public StatModel getStats() {
    int humansDnaCount = dnaRepository.getCountRecords();
    int mutantsDnaCount = dnaRepository.getCountMutantsRecords();
    double ratio = (double) mutantsDnaCount / (double) humansDnaCount;
    return StatModel.builder()
        .humansDna(humansDnaCount)
        .mutantsDna(mutantsDnaCount)
        .ratio(ratio)
        .build();
  }

  @Override
  public boolean validateDna(List<String> dnaRequestArray) throws DnaException {
    mutant = new Mutant();
    boolean output = mutant.isMutant(Util.stringArrayListToStringArray(dnaRequestArray));
    dnaRepository.save(
        dnaComponent.buildDnaEntity(Util.stringArrayListToStringArray(dnaRequestArray), output));
    return output;
  }
}
