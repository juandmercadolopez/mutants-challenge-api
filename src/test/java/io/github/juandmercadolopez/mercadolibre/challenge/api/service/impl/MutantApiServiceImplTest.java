package io.github.juandmercadolopez.mercadolibre.challenge.api.service.impl;

import io.github.juandmercadolopez.mercadolibre.challenge.api.component.DnaComponent;
import io.github.juandmercadolopez.mercadolibre.challenge.api.entity.DnaEntity;
import io.github.juandmercadolopez.mercadolibre.challenge.api.model.StatModel;
import io.github.juandmercadolopez.mercadolibre.challenge.api.repository.DnaRepository;
import io.github.juandmercadolopez.mercadolibre.challenge.api.util.ObjectBuilder;
import mercadolibre.challenge.core.exception.DnaException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MutantApiServiceImplTest {

  @InjectMocks private static MutantApiServiceImpl mutantApiService;

  @Mock static DnaComponent dnaComponent;

  @Mock static DnaRepository dnaRepository;

  @Test
  void getStatsTest() {
    Mockito.when(dnaRepository.getCountRecords()).thenReturn(100);
    Mockito.when(dnaRepository.getCountMutantsRecords()).thenReturn(40);
    StatModel statModel = mutantApiService.getStats();
    Assertions.assertNotNull(statModel);
  }

  @Test
  void saveResultTest() {
    DnaEntity dnaEntityMock = Mockito.mock(DnaEntity.class);
    String[] dna = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
    Mockito.when(dnaComponent.buildDnaEntity(dna, true)).thenReturn(dnaEntityMock);
    Mockito.when(dnaRepository.save(Mockito.any(DnaEntity.class))).thenReturn(dnaEntityMock);
    DnaEntity dnaEntity = mutantApiService.saveResult(dna, true);
    Assertions.assertNotNull(dnaEntity);
  }

  @Test
  void validateDnaTest() throws DnaException {
    ObjectBuilder objectBuilder = new ObjectBuilder();
    boolean output = mutantApiService.validateDna(objectBuilder.buildDnaRequestForStatus200().getDna());
    Assertions.assertTrue(output);
  }
}
