package org.emmanuel_numar_acceso_agua.repository;


import java.util.ArrayList;
import java.util.List;
import org.emmanuel_numar_acceso_agua.model.DataRegion;

public class DataRegionRepositoryImpl implements DataRegionRepository {
  @Override
  public List<DataRegion> findAllGrades() {

    List  <DataRegion> data = new ArrayList<>();
    data.add( new DataRegion("Caribe",35500600F,10700000));
    data.add( new DataRegion("Andina",150000000F, 37068593));
    data.add( new DataRegion("Orinoquía",20000000F, 2000000));
    data.add( new DataRegion("Amazonía",5000000F, 1243730));
    data.add( new DataRegion("Insular",1000000F, 200000));
    data.add( new DataRegion("Pacífica",10000000F, 1500000));
    return data;
  }
}
