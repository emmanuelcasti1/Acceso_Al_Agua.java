package org.emmanuel_numar_acceso_agua.repository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.emmanuel_numar_acceso_agua.model.consumoXRegion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.plaf.synth.Region;

public class consumoXRegionInMemomyRepositoryImpl implements consumoXRegionRepository {

  private static final Logger logger = LoggerFactory.getLogger( consumoXRegionInMemomyRepositoryImpl.class);

  private List<consumoXRegion> consumoXRegionList;

  public consumoXRegionInMemomyRepositoryImpl() {
    this.consumoXRegionList = new ArrayList<>(dataRegionList());
  }


  private List<consumoXRegion> dataRegionList(){
    logger.info( "Cargando las estadísticas regionales" );
    return List.of(
    new consumoXRegion("Caribe",35500600F,10700000),
    new consumoXRegion("Andina",150000000F, 37068593),
    new consumoXRegion("Amazonía",5000000F, 1243730),
    new consumoXRegion("Insular",1000000F, 200000),
    new consumoXRegion("Pacífica",10000000F, 1500000));
  }
  @Override
  public List<consumoXRegion> findAllData() {
    return consumoXRegionList;
  }

  @Override
  public Optional<consumoXRegion> getconsumoXRegion(String Region) {
    return this.consumoXRegionList.stream().filter( p->p.nombre().equals( Region ) ).findAny();
  }

  @Override
  public consumoXRegion addconsumoXRegion(consumoXRegion newconsumoXRegion) {
    this.consumoXRegionList.add( newconsumoXRegion );

    return this.consumoXRegionList.stream()
            .filter( isTheConsumoOfTheProject( newconsumoXRegion ) )
            .findAny()
            .orElse( null );
  }

  private Predicate<consumoXRegion> isTheConsumoOfTheProject(consumoXRegion newconsumoXRegion) {
    return p -> p.nombre().equals( newconsumoXRegion.nombre() );
  }


}
