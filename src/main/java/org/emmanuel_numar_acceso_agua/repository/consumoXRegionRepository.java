package org.emmanuel_numar_acceso_agua.repository;

import java.util.List;
import org.emmanuel_numar_acceso_agua.model.consumoXRegion;

public interface consumoXRegionRepository {

  List<consumoXRegion> findAllData();
}
