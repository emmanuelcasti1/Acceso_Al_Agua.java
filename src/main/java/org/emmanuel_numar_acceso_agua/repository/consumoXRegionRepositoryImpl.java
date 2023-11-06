package org.emmanuel_numar_acceso_agua.repository;


import java.util.ArrayList;
import java.util.List;
import org.emmanuel_numar_acceso_agua.model.consumoXRegion;

public class consumoXRegionRepositoryImpl implements consumoXRegionRepository {
  @Override
  public List<consumoXRegion> findAllData() {

    List  <consumoXRegion> dataRegionList = new ArrayList<>();
    dataRegionList.add( new consumoXRegion("Caribe",35500600F,10700000));
    dataRegionList.add( new consumoXRegion("Andina",150000000F, 37068593));
    dataRegionList.add( new consumoXRegion("Orinoquía",20000000F, 2000000));
    dataRegionList.add( new consumoXRegion("Amazonía",5000000F, 1243730));
    dataRegionList.add( new consumoXRegion("Insular",1000000F, 200000));
    dataRegionList.add( new consumoXRegion("Pacífica",10000000F, 1500000));
    return dataRegionList;
  }
}
