package io.github.juandmercadolopez.mercadolibre.challenge.api.component;

import io.github.juandmercadolopez.mercadolibre.challenge.api.entity.DnaEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DnaComponentTest {

    @InjectMocks private DnaComponent dnaComponent;

    @Test
    void buildDnaEntityTest(){
        String[] dna = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
        DnaEntity dnaEntity = dnaComponent.buildDnaEntity(dna,true);
        Assertions.assertNotNull(dnaEntity);
    }
}
