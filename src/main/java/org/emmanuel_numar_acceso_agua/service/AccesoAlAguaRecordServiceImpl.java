package org.emmanuel_numar_acceso_agua.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.emmanuel_numar_acceso_agua.excepcion.ConsumoNoEncontradoExcepcion;
import org.emmanuel_numar_acceso_agua.model.consumoXRegion;
import org.emmanuel_numar_acceso_agua.repository.consumoXRegionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class AccesoAlAguaRecordServiceImpl implements AccesoAlAguaRecordService {

    private static final Logger logger = LoggerFactory.getLogger(AccesoAlAguaRecordServiceImpl.class);
    private final consumoXRegionRepository consumoXRegionRepository;

    public AccesoAlAguaRecordServiceImpl(consumoXRegionRepository consumoXRegionRepository) {
        {
            this.consumoXRegionRepository = consumoXRegionRepository;
        }
    }

    @Override
    public void mostrarNombreRegion() {
        List<consumoXRegion> consumoXRegionList = this.consumoXRegionRepository.findAllData();

        consumoXRegionList.stream()
                .map(consumoXRegion::nombre)
                .forEach(System.out::println);
    }


    public int poblacionColombia() {
        List<consumoXRegion> consumoXRegionList = this.consumoXRegionRepository.findAllData();
        int sumaPoblacion = 0;
        for (var consumoXRegion : consumoXRegionList) {
            sumaPoblacion += consumoXRegion.poblacion();
        }
        return sumaPoblacion;
    }

    public double consumoAguaColombia() {
        List<consumoXRegion> consumoXRegionList = this.consumoXRegionRepository.findAllData();
        double sumaConsumo = 0;
        for (var consumoXRegion : consumoXRegionList) {
            sumaConsumo += consumoXRegion.consumo();
        }
        return sumaConsumo;
    }

    public double hallarPromConsPersonaNacional() {
        double promedioPersona;
        promedioPersona = consumoAguaColombia() / poblacionColombia();

        return promedioPersona;
    }

    public String hallarRegionConMenorAccesoAlAgua() {
        List<consumoXRegion> consumoXRegionList = this.consumoXRegionRepository.findAllData();

        Optional<String> menosAcceso = consumoXRegionList.stream()
                .reduce((region1, region2) -> region1.consumo() < region2.consumo() ? region1 : region2)
                .map(consumoXRegion::nombre);

        return menosAcceso.orElse("");
    }

    @Override
    public consumoXRegion getconsumoXRegion(String nombre) throws ConsumoNoEncontradoExcepcion {
        Optional<consumoXRegion> consumoXRegionOptional = this.consumoXRegionRepository.getconsumoXRegion( nombre );

        if( consumoXRegionOptional.isEmpty() ){
            logger.error( "No se encontró una region con ese nombre {}", nombre );
            throw new ConsumoNoEncontradoExcepcion(nombre);
        }

        return consumoXRegionOptional.get();
    }

    public void hallarConsumoPersonaXRegion() {
        List<consumoXRegion> consumoXRegionList = this.consumoXRegionRepository.findAllData();
        float consumoXPersona;
        for (var consumoXRegion : consumoXRegionList) {
            consumoXPersona = consumoXRegion.consumo() / consumoXRegion.poblacion();
            System.out.println("En la region " + consumoXRegion.nombre() + " se consume: " + consumoXPersona + " Lt por persona.");
            System.out.println();
        }
    }

    public String hallarRegionConMenorConsuXPersona() {
        List<consumoXRegion> consumoXRegionList = this.consumoXRegionRepository.findAllData();

        Optional<String> menorconsuRegion = consumoXRegionList.stream()
                .min(Comparator.comparingDouble(region -> region.consumo() / region.poblacion()))
                .map(consumoXRegion::nombre);

        return menorconsuRegion.orElse("");
    }


    public String hallarRegionConMayorConsuXPersona() {
        List<consumoXRegion> consumoXRegionList = this.consumoXRegionRepository.findAllData();

        Optional<String> mayorconsuRegion = consumoXRegionList.stream()
                .max(Comparator.comparingDouble(consumoXRegion -> consumoXRegion.consumo() / consumoXRegion.poblacion()))
                .map(consumoXRegion -> consumoXRegion.nombre());

        return mayorconsuRegion.orElse("");
    }

    @Override
    public List<consumoXRegion> listAllConsumos() {
        return this.consumoXRegionRepository.findAllData();
    }

    public consumoXRegion addconsumoXRegion(consumoXRegion newconsumoXRegion) {
        return this.consumoXRegionRepository.addconsumoXRegion( newconsumoXRegion );
    }

}
