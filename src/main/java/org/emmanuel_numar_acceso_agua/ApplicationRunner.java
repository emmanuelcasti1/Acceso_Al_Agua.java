package org.emmanuel_numar_acceso_agua;

import org.emmanuel_numar_acceso_agua.repository.consumoXRegionRepositoryImpl;
import org.emmanuel_numar_acceso_agua.service.AccesoAlAguaRecordService;
import org.emmanuel_numar_acceso_agua.service.AccesoAlAguaRecordServiceImpl;

public class ApplicationRunner {
  public static void main(String[] args) {

    AccesoAlAguaRecordService accesoAlAguaRecordService =
        new AccesoAlAguaRecordServiceImpl(new consumoXRegionRepositoryImpl());

    System.out.println("Las regiones de Colombia Son: ");
    accesoAlAguaRecordService.mostrarNombreRegion();
    System.out.println();
    System.out.println("\nLa población nacional de Colombia es: "+ accesoAlAguaRecordService.poblacionColombia());

    System.out.println("\nEl consumo de agua potable a nivel Colombia es: "+ accesoAlAguaRecordService.consumoAguaColombia()+" Lts");

    System.out.println("\nEl consumo promedio de agua nacional por individuo es: "+ accesoAlAguaRecordService.hallarPromConsPersonaNacional()+" lts");

    System.out.println("\nLa región con menos acceso al agua potable es: "+ accesoAlAguaRecordService.hallarRegionConMenorAccesoAlAgua());

    System.out.println("\nEl consumo regional por persona es: ");
    accesoAlAguaRecordService.hallarConsumoPersonaXRegion();
    System.out.println("\nLa región que menos agua potable consume por persona es: "+ accesoAlAguaRecordService.hallarRegionConMenorConsuXPersona());

    System.out.println("\nLa región que mas agua potable consume por persona es: "+ accesoAlAguaRecordService.hallarRegionConMayorConsuXPersona());
  }
}
