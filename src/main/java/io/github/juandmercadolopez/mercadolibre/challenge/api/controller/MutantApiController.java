package io.github.juandmercadolopez.mercadolibre.challenge.api.controller;

import io.github.juandmercadolopez.mercadolibre.challenge.api.constant.ApplicationConstant;
import io.github.juandmercadolopez.mercadolibre.challenge.api.model.DnaRequest;
import io.github.juandmercadolopez.mercadolibre.challenge.api.model.DnaResponse;
import io.github.juandmercadolopez.mercadolibre.challenge.api.service.MutantApiService;
import io.github.juandmercadolopez.mercadolibre.challenge.api.util.Util;
import mercadolibre.challenge.core.exception.DnaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.logging.Logger;

@RestController
public class MutantApiController {

  private final Logger logger = Logger.getLogger(MutantApiController.class.getName());

  @Autowired MutantApiService mutantApiService;

  @PostMapping(path = "/mutant", consumes = "application/json", produces = "application/json")
  public ResponseEntity<DnaResponse> validateDna(@RequestBody DnaRequest dnaRequest) {

    try {
      if (mutantApiService.validateDna(dnaRequest.getDna())) {
        return new ResponseEntity<DnaResponse>(DnaResponse.builder()
                .timestamp(Util.getTimestamp())
                .status(HttpStatus.OK.value())
                .build(), HttpStatus.OK);
      } else {
        return new ResponseEntity<DnaResponse>(
            DnaResponse.builder()
                .timestamp(Util.getTimestamp())
                .status(HttpStatus.FORBIDDEN.value())
                .build(),
            HttpStatus.FORBIDDEN);
      }
    } catch (DnaException e) {
      logger.severe(e.getMessage());
      return new ResponseEntity<DnaResponse>(
          DnaResponse.builder()
              .timestamp(Util.getTimestamp())
              .error(e.getMessage())
              .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
              .build(),
              HttpStatus.INTERNAL_SERVER_ERROR);
    } catch (IOException e) {
      logger.severe(e.getMessage());
      return new ResponseEntity<DnaResponse>(
          DnaResponse.builder()
              .timestamp(Util.getTimestamp())
              .error(ApplicationConstant.ERROR_DURING_PROCESS)
              .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
              .build(),
              HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
