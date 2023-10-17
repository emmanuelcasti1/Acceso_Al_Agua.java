package org.emmanuel_numar_acceso_agua;

import java.security.Provider;
import java.text.MessageFormat;
import org.emmanuel_numar_acceso_agua.repository.DataRegionRepositoryImpl;
import org.emmanuel_numar_acceso_agua.service.AcademicRecordService;
import org.emmanuel_numar_acceso_agua.service.AcademicRecordServiceImpl;

public class ApplicationRunner {
  public static void main(String[] args) {

    AcademicRecordService academicRecordService =
        new AcademicRecordServiceImpl(new DataRegionRepositoryImpl());

    System.out.println(
        MessageFormat.format(
            "Suma de número calificaciones: {0}", academicRecordService.sumNumberOfGrades()));

    System.out.println("Las regiones de Colombia Son: ");
    academicRecordService.MostrarNombreRegion();
    System.out.println();
    System.out.println("La poblacion nacional de Colombia es: "+academicRecordService.PoblacionColombia());
    System.out.println();
    System.out.println("El consumo de agua potable a nivel Colombia es: "+(academicRecordService.ConsumoAguaColombia()));
  }
}
