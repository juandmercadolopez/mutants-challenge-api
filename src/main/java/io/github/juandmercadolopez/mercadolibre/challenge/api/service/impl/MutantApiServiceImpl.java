package io.github.juandmercadolopez.mercadolibre.challenge.api.service.impl;

import io.github.juandmercadolopez.mercadolibre.challenge.api.component.DnaConverter;
import io.github.juandmercadolopez.mercadolibre.challenge.api.model.DnaModel;
import io.github.juandmercadolopez.mercadolibre.challenge.api.model.StatModel;
import io.github.juandmercadolopez.mercadolibre.challenge.api.repository.DnaRepository;
import io.github.juandmercadolopez.mercadolibre.challenge.api.service.MutantApiService;
import mercadolibre.challenge.core.controller.Mutant;
import mercadolibre.challenge.core.exception.DnaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class MutantApiServiceImpl implements MutantApiService {

  @Autowired DnaConverter dnaConverter;

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
  public boolean validateDna(List<String> dnaRequestArray) throws DnaException, IOException {
    mutant = new Mutant();
    boolean output = mutant.isMutant(stringArrayListToStringArray(dnaRequestArray));
    dnaRepository.save(
        dnaConverter.convertDnaModelToEntity(
            buildDnaModel(stringArrayListToStringArray(dnaRequestArray), output)));
    return output;
  }

  private String[] stringArrayListToStringArray(List<String> dnaRequestArray) {
    String[] dnaArray = new String[dnaRequestArray.size()];
    int index = 0;
    for (String dnaPart : dnaRequestArray) {
      dnaArray[index] = dnaPart;
      index++;
    }
    return dnaArray;
  }

  private DnaModel buildDnaModel(String[] dnaArray, boolean mutant) {

    return DnaModel.builder()
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
