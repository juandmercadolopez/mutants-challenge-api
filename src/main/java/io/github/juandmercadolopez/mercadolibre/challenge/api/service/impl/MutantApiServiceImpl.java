package io.github.juandmercadolopez.mercadolibre.challenge.api.service.impl;

import io.github.juandmercadolopez.mercadolibre.challenge.api.component.DnaComponent;
import io.github.juandmercadolopez.mercadolibre.challenge.api.entity.DnaEntity;
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
    boolean output = Mutant.isMutant(Util.stringArrayListToStringArray(dnaRequestArray));
    saveResult(Util.stringArrayListToStringArray(dnaRequestArray), output);
    return output;
  }

  public DnaEntity saveResult(String[] dnaRequestArray, boolean result) {
    return dnaRepository.save(dnaComponent.buildDnaEntity(dnaRequestArray, result));
  }
}
