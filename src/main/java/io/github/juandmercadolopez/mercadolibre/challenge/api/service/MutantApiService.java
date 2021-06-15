package io.github.juandmercadolopez.mercadolibre.challenge.api.service;

import io.github.juandmercadolopez.mercadolibre.challenge.api.model.StatModel;
import mercadolibre.challenge.core.exception.DnaException;

import java.util.List;

public interface MutantApiService {

  boolean validateDna(List<String> dnaRequestArray) throws DnaException;

  StatModel getStats();
}
