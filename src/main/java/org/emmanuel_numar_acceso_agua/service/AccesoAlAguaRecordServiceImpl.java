package org.emmanuel_numar_acceso_agua.service;

import java.util.List;
import org.emmanuel_numar_acceso_agua.model.DataRegion;
import org.emmanuel_numar_acceso_agua.repository.DataRegionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class AccesoAlAguaRecordServiceImpl implements AccesoAlAguaRecordService {

    private static final Logger logger = LoggerFactory.getLogger(AccesoAlAguaRecordServiceImpl.class);
    private final DataRegionRepository dataRegionRepository;

    public AccesoAlAguaRecordServiceImpl(DataRegionRepository dataRegionRepository) {
        this.dataRegionRepository = dataRegionRepository;
    }

    @Override
    public String MostrarNombreRegion() {
        List<DataRegion> data = this.dataRegionRepository.findAllGrades();
        for (var DataRegion : data ) {
            System.out.println(DataRegion.nombreRegion());
        }
        return null;
    }
    public Integer PoblacionColombia(){
        List<DataRegion> data = this.dataRegionRepository.findAllGrades();
        int sumaPoblacion = 0;
        for (var DataRegion : data){
            sumaPoblacion += DataRegion.poblacionRegion();
        }
    return sumaPoblacion;
    }

    public double ConsumoAguaColombia()
    {
        List<DataRegion> data = this.dataRegionRepository.findAllGrades();
        double sumaConsumo = 0;
        for (var DataRegion : data){
            sumaConsumo += DataRegion.consumoXRegion();
        }
        return sumaConsumo;
    }

    public double HallarPromConsPersonaNacional()
    {
        double promedioPersona;
        promedioPersona = ConsumoAguaColombia()/PoblacionColombia();

        return promedioPersona;
    }

    public String HallarRegionConMenorAccesoAlAgua()
    {
        List<DataRegion> data = this.dataRegionRepository.findAllGrades();
        double aux = 999999999;
        String menosAcceso = "";
        for (var DataRegion : data ) {
            if (DataRegion.consumoXRegion() < aux){
                aux = DataRegion.consumoXRegion();
                menosAcceso = DataRegion.nombreRegion();
            }
        }
        return menosAcceso;
    }

    public void HallarConsumoPersonaXRegion()
    {
        List<DataRegion> data = this.dataRegionRepository.findAllGrades();
        float consumoXPersona;
        for (var DataRegion : data) {
            consumoXPersona = DataRegion.consumoXRegion() / DataRegion.poblacionRegion();
            System.out.println("En la region " + DataRegion.nombreRegion() + " se consume: " + consumoXPersona + " Lt por persona.");
            System.out.println();
        }
    }

    public String HallarRegionConMenorConsuXPersona()
    {
        List<DataRegion> data = this.dataRegionRepository.findAllGrades();
        float consumoXPersona, menorConsumo = 999999999;
        String menorconsuRegion = "";
        for (var DataRegion : data) {
            consumoXPersona = DataRegion.consumoXRegion() / DataRegion.poblacionRegion();
            if (consumoXPersona < menorConsumo) {
                menorConsumo = consumoXPersona;
                menorconsuRegion = DataRegion.nombreRegion();
            }
        }
        return menorconsuRegion;
    }

    public String HallarRegionConMayorConsuXPersona()
    {
        List<DataRegion> data = this.dataRegionRepository.findAllGrades();
        float consumoXPersona, mayorConsumo = 0;
        String mayorconsuRegion = "";
        for (var DataRegion : data) {
            consumoXPersona = DataRegion.consumoXRegion() / DataRegion.poblacionRegion();
            if (consumoXPersona > mayorConsumo){
                mayorConsumo = consumoXPersona;
                mayorconsuRegion = DataRegion.nombreRegion();
            }
        }
        return mayorconsuRegion;
    }

}
