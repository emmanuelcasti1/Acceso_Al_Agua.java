package org.emmanuel_numar_acceso_agua.repository;

import org.emmanuel_numar_acceso_agua.model.consumoXRegion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;
public class ConsumoXRegionUsingFileRepositoryImpl implements consumoXRegionRepository {
        private static final Logger logger = LoggerFactory.getLogger( ConsumoXRegionUsingFileRepositoryImpl.class);
        private List<consumoXRegion> consumoXRegionList;

    public ConsumoXRegionUsingFileRepositoryImpl() {
        this.consumoXRegionList = new ArrayList<>(dataRegionList());
    }

    private List<consumoXRegion> dataRegionList(){
        logger.info( "Cargando las estadísticas desde archivo" );
        List<String> plainTextconsumoXRegionList =  readFileWithconsumoXRegion();
        List<consumoXRegion> consumoXRegionList = plainTextconsumoXRegionList.stream().map( this::buildconsumoXRegion ).toList();
        return consumoXRegionList;
    }

    private List<String> readFileWithconsumoXRegion(){
        Path path = Paths.get( "./src/main/resources/estadisticas.txt");
        try (Stream<String> stream = Files.lines( path)) {
            return stream.toList();
        } catch (IOException x) {
            logger.error("IOException: {0}", x);
        }
        return Collections.emptyList();
    }

    private consumoXRegion buildconsumoXRegion(String plainTextconsumoXRegionList) {
        String[] dataParts = plainTextconsumoXRegionList.split(",");
        if (dataParts.length != 3) {
            throw new IllegalArgumentException("El formato de entrada debe ser: 'nombre de la región,consumo y población'");
        }

        String nombre = dataParts[0].trim();
        float consumo = Float.parseFloat(dataParts[1].trim());
        int poblacion = Integer.parseInt(dataParts[2].trim());

        return new consumoXRegion(nombre, consumo, poblacion);
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
