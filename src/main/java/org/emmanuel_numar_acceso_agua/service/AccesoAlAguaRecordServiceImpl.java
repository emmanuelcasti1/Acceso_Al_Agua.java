package org.emmanuel_numar_acceso_agua.service;

import java.util.List;
import org.emmanuel_numar_acceso_agua.model.consumoXRegion;
import org.emmanuel_numar_acceso_agua.repository.consumoXRegionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class AccesoAlAguaRecordServiceImpl implements AccesoAlAguaRecordService {

    private static final Logger logger = LoggerFactory.getLogger(AccesoAlAguaRecordServiceImpl.class);
    private final consumoXRegionRepository consumoXRegionRepository;

    public AccesoAlAguaRecordServiceImpl(consumoXRegionRepository consumoXRegionRepository) {
        this.consumoXRegionRepository = consumoXRegionRepository;
    }

    @Override
    public void mostrarNombreRegion() {
        List<consumoXRegion> consumoXRegionList = this.consumoXRegionRepository.findAllData();
        for (var consumoXRegion : consumoXRegionList ) {
            System.out.println(consumoXRegion.nombre());
        }
    }
    public int poblacionColombia(){
        List<consumoXRegion> consumoXRegionList = this.consumoXRegionRepository.findAllData();
        int sumaPoblacion = 0;
        for (var consumoXRegion : consumoXRegionList){
            sumaPoblacion += consumoXRegion.poblacion();
        }
        return sumaPoblacion;
    }

    public double consumoAguaColombia()
    {
        List<consumoXRegion> consumoXRegionList = this.consumoXRegionRepository.findAllData();
        double sumaConsumo = 0;
        for (var consumoXRegion : consumoXRegionList){
            sumaConsumo += consumoXRegion.consumo();
        }
        return sumaConsumo;
    }

    public double hallarPromConsPersonaNacional() {
        double promedioPersona;
        promedioPersona = consumoAguaColombia()/poblacionColombia();

        return promedioPersona;
    }

    public String hallarRegionConMenorAccesoAlAgua()
    {
        List<consumoXRegion> consumoXRegionList = this.consumoXRegionRepository.findAllData();
        double aux = 999999999;
        String menosAcceso = "";
        for (var consumoXRegion : consumoXRegionList ) {
            if (consumoXRegion.consumo() < aux){
                aux = consumoXRegion.consumo();
                menosAcceso = consumoXRegion.nombre();
            }
        }
        return menosAcceso;
    }

    public void hallarConsumoPersonaXRegion()
    {
        List<consumoXRegion> consumoXRegionList = this.consumoXRegionRepository.findAllData();
        float consumoXPersona;
        for (var consumoXRegion : consumoXRegionList) {
            consumoXPersona = consumoXRegion.consumo() / consumoXRegion.poblacion();
            System.out.println("En la region " + consumoXRegion.nombre() + " se consume: " + consumoXPersona + " Lt por persona.");
            System.out.println();
        }
    }

    public String hallarRegionConMenorConsuXPersona()
    {
        List<consumoXRegion> consumoXRegionList = this.consumoXRegionRepository.findAllData();
        float consumoXPersona, menorConsumo = 999999999;
        String menorconsuRegion = "";
        for (var consumoXRegion : consumoXRegionList) {
            consumoXPersona = consumoXRegion.consumo() / consumoXRegion.poblacion();
            if (consumoXPersona < menorConsumo) {
                menorConsumo = consumoXPersona;
                menorconsuRegion = consumoXRegion.nombre();
            }
        }
        return menorconsuRegion;
    }

    public String hallarRegionConMayorConsuXPersona()
    {
        List<consumoXRegion> consumoXRegionList = this.consumoXRegionRepository.findAllData();
        float consumoXPersona, mayorConsumo = 0;
        String mayorconsuRegion = "";
        for (var consumoXRegion : consumoXRegionList) {
            consumoXPersona = consumoXRegion.consumo() / consumoXRegion.poblacion();
            if (consumoXPersona > mayorConsumo){
                mayorConsumo = consumoXPersona;
                mayorconsuRegion = consumoXRegion.nombre();
            }
        }
        return mayorconsuRegion;
    }

}
