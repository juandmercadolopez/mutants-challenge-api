package io.github.juandmercadolopez.mercadolibre.challenge.api.repository;

import io.github.juandmercadolopez.mercadolibre.challenge.api.entity.DnaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface DnaRepository extends JpaRepository<DnaEntity, Serializable> {

  @Query("SELECT count(*) FROM DnaEntity")
  int getCountRecords();

  @Query("SELECT count(*) FROM DnaEntity dna WHERE dna.mutant = 1")
  int getCountMutantsRecords();
}
