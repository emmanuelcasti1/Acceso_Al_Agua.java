package org.emmanuel_numar_acceso_agua.repository;

import java.util.List;
import java.util.Optional;

import org.emmanuel_numar_acceso_agua.model.consumoXRegion;

import javax.swing.plaf.synth.Region;

public interface consumoXRegionRepository {

  List<consumoXRegion> findAllData();

  Optional<consumoXRegion> getconsumoXRegion(String Region);

  consumoXRegion addconsumoXRegion(consumoXRegion newconsumoXRegion);
}