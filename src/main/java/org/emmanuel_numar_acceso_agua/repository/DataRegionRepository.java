package org.emmanuel_numar_acceso_agua.repository;

import java.util.List;
import org.emmanuel_numar_acceso_agua.model.DataRegion;

public interface DataRegionRepository {

  List<DataRegion> findAllGrades();
}
