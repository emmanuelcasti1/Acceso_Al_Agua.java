package org.emmanuel_numar_acceso_agua.service;

import java.text.DecimalFormat;
import java.util.List;
import org.emmanuel_numar_acceso_agua.model.DataRegion;
import org.emmanuel_numar_acceso_agua.repository.DataRegionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AcademicRecordServiceImpl implements AcademicRecordService {

    private static final Logger logger = LoggerFactory.getLogger(AcademicRecordServiceImpl.class);
    private final DataRegionRepository dataRegionRepository;

    public AcademicRecordServiceImpl(DataRegionRepository dataRegionRepository) {
        this.dataRegionRepository = dataRegionRepository;
    }

    @Override
    public void MostrarNombreRegion() {
        List<DataRegion> data = this.dataRegionRepository.findAllGrades();
        for (var DataRegion : data ) {
            System.out.println(DataRegion.nombreRegion());
        }
    }
    public Integer PoblacionColombia(){
        List<DataRegion> data = this.dataRegionRepository.findAllGrades();
        int sumaPoblacion = 0;
        for (var DataRegion : data){
            sumaPoblacion += DataRegion.poblacionRegion();
        }
    return sumaPoblacion;
    }

    public double ConsumoAguaColombia(){
        List<DataRegion> data = this.dataRegionRepository.findAllGrades();
        double sumaConsumo = 0;
        for (var DataRegion : data){
            sumaConsumo += DataRegion.consumoXRegion();
        }
        return sumaConsumo;
    }



  @Override
      public Integer sumNumberOfGrades() {
          System.out.println("Sumando el número de calificaciones");
          logger.info("Sumando el número de calificaciones");
          logger.warn("Sumando el número de calificaciones");
          logger.error("Sumando el número de calificaciones");

          List<DataRegion> gradeList = this.dataRegionRepository.findAllGrades();

          int sum = gradeList.size();
          logger.info("Total number of grades: " + sum);
          return sum;

      }

}
