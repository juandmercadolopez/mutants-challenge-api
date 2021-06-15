package io.github.juandmercadolopez.mercadolibre.challenge.api.util;

import io.github.juandmercadolopez.mercadolibre.challenge.api.model.DnaRequest;

import java.util.ArrayList;
import java.util.List;

public class ObjectBuilder {

  public DnaRequest buildDnaRequestForStatus200() {
    // {"dna":["ATGCGA","CAGTGC","TGATGT","AGTGGC","CCCCTA","TCACTG"]}
    List<String> list = new ArrayList<>();
    list.add("ATGCGA");
    list.add("CAGTGC");
    list.add("TGATGT");
    list.add("AGTGGC");
    list.add("CCCCTA");
    list.add("TCACTG");
    return DnaRequest.builder().dna(list).build();
  }

  public DnaRequest buildDnaRequestForStatus403() {
    // {"dna":["ATGCGA","CAGTGC","TGATGT","AGTGGC","CACCTA","TCACTG"]}
    List<String> list = new ArrayList<>();
    list.add("ATGCGA");
    list.add("CAGTGC");
    list.add("TGATGT");
    list.add("AGTGGC");
    list.add("CACCTA");
    list.add("TCACTG");
    return DnaRequest.builder().dna(list).build();
  }

  public DnaRequest buildDnaRequestForStatus500() {
    // {"dna":["ATGCGA","CAGTGC","TGATGT","AGTGGC","CCCCTA"}
    List<String> list = new ArrayList<>();
    list.add("ATGCGA");
    list.add("CAGTGC");
    list.add("TGATGT");
    list.add("AGTGGC");
    list.add("CCCCTA");
    return DnaRequest.builder().dna(list).build();
  }
}
