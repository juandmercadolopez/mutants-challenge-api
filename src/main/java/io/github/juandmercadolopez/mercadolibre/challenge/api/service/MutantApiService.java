package io.github.juandmercadolopez.mercadolibre.challenge.api.service;

import mercadolibre.challenge.core.exception.DnaException;

import java.io.IOException;
import java.util.List;

public interface MutantApiService {

  boolean validateDna(List<String> dnaRequestArray) throws DnaException, IOException;
}
