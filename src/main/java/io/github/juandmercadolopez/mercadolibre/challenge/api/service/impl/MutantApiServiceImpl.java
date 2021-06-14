package io.github.juandmercadolopez.mercadolibre.challenge.api.service.impl;

import io.github.juandmercadolopez.mercadolibre.challenge.api.service.MutantApiService;
import mercadolibre.challenge.core.controller.Mutant;
import mercadolibre.challenge.core.exception.DnaException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class MutantApiServiceImpl implements MutantApiService {

  Mutant mutant;

  @Override
  public boolean validateDna(List<String> dnaRequestArray) throws DnaException, IOException {
    mutant = new Mutant();
    return mutant.isMutant(stringArrayListToStringArray(dnaRequestArray));
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
}
