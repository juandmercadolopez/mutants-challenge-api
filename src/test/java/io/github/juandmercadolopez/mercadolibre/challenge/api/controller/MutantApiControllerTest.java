package io.github.juandmercadolopez.mercadolibre.challenge.api.controller;

import io.github.juandmercadolopez.mercadolibre.challenge.api.model.DnaResponse;
import io.github.juandmercadolopez.mercadolibre.challenge.api.model.StatModel;
import io.github.juandmercadolopez.mercadolibre.challenge.api.service.impl.MutantApiServiceImpl;
import io.github.juandmercadolopez.mercadolibre.challenge.api.util.ObjectBuilder;
import lombok.SneakyThrows;
import mercadolibre.challenge.core.exception.DnaException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

@ExtendWith(MockitoExtension.class)
class MutantApiControllerTest {

  @InjectMocks static MutantApiController mutantApiController;

  @Mock static MutantApiServiceImpl mutantApiService;

  @Test
  void validateDna200Test() throws DnaException {
    ObjectBuilder builder = new ObjectBuilder();
    Mockito.when(mutantApiService.validateDna(builder.buildDnaRequestForStatus200().getDna()))
        .thenReturn(true);
    ResponseEntity<DnaResponse> output =
        mutantApiController.validateDna(builder.buildDnaRequestForStatus200());
    Assertions.assertEquals(200, output.getStatusCodeValue());
  }

  @Test
  void validateDna403Test() throws DnaException {
    ObjectBuilder builder = new ObjectBuilder();
    Mockito.when(mutantApiService.validateDna(builder.buildDnaRequestForStatus403().getDna()))
        .thenReturn(false);
    ResponseEntity<DnaResponse> output =
        mutantApiController.validateDna(builder.buildDnaRequestForStatus403());
    Assertions.assertEquals(403, output.getStatusCodeValue());
  }

  @SneakyThrows
  @Test
  void validateDna500DnaExceptionTest() {
    ObjectBuilder builder = new ObjectBuilder();
    Mockito.when(mutantApiService.validateDna(builder.buildDnaRequestForStatus500().getDna()))
        .thenThrow(new DnaException("error"));
    ResponseEntity<DnaResponse> output =
        mutantApiController.validateDna(builder.buildDnaRequestForStatus500());
    Assertions.assertEquals(500, output.getStatusCodeValue());
  }

  @Test
  void getStatsTest(){
    StatModel statModelMock = Mockito.mock(StatModel.class);
    Mockito.when(mutantApiService.getStats()).thenReturn(statModelMock);
    ResponseEntity<StatModel> response = mutantApiController.getStats();
    Assertions.assertNotNull(response);
  }
}
