package org.emmanuel_numar_acceso_agua;

import org.emmanuel_numar_acceso_agua.excepcion.ConsumoNoEncontradoExcepcion;
import org.emmanuel_numar_acceso_agua.model.consumoXRegion;
import org.emmanuel_numar_acceso_agua.repository.consumoXRegionInMemomyRepositoryImpl;
import org.emmanuel_numar_acceso_agua.service.AccesoAlAguaRecordService;
import org.emmanuel_numar_acceso_agua.service.AccesoAlAguaRecordServiceImpl;

import java.text.MessageFormat;
import java.time.LocalDate;

public class ApplicationRunner {
  public static void main(String[] args) {

    AccesoAlAguaRecordService accesoAlAguaRecordService =
        new AccesoAlAguaRecordServiceImpl(new consumoXRegionInMemomyRepositoryImpl());

    System.out.println("\nLas regiones de Colombia antes de ingresar Orinoquía son: ");
    accesoAlAguaRecordService.mostrarNombreRegion();

    consumoXRegion consumo = new consumoXRegion( "Orinoquía",20000000F, 2000000 );
    accesoAlAguaRecordService.addconsumoXRegion( consumo );

    System.out.println("\nLas regiones de Colombia despues de ingresar Orinoquía son: ");
    accesoAlAguaRecordService.mostrarNombreRegion();

    System.out.println();
    System.out.println("\nLa población nacional de Colombia es: "+ accesoAlAguaRecordService.poblacionColombia());

    System.out.println("\nEl consumo de agua potable a nivel Colombia es: "+ accesoAlAguaRecordService.consumoAguaColombia()+" Lts");

    System.out.println("\nEl consumo promedio de agua nacional por individuo es: "+ accesoAlAguaRecordService.hallarPromConsPersonaNacional()+" lts");

    System.out.println("\nLa región con menos acceso al agua potable es: "+ accesoAlAguaRecordService.hallarRegionConMenorAccesoAlAgua());

    System.out.println("\nEl consumo regional por persona es: ");
    accesoAlAguaRecordService.hallarConsumoPersonaXRegion();
    System.out.println("La región que menos agua potable consume por persona es: "+ accesoAlAguaRecordService.hallarRegionConMenorConsuXPersona());

    System.out.println("\nLa región que mas agua potable consume por persona es: "+ accesoAlAguaRecordService.hallarRegionConMayorConsuXPersona());

    System.out.println("\nConsultar una region que no existe");
    String nombreRegion = "Antioquia";
    try {
      System.out.println(accesoAlAguaRecordService.getconsumoXRegion( nombreRegion ));
    }
    catch (ConsumoNoEncontradoExcepcion e) {
      System.out.println(MessageFormat.format("No se encontró una region con ese nombre {0} ", nombreRegion));
    }
  }
}
