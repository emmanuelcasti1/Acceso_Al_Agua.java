package org.emmanuel_numar_acceso_agua;

import org.emmanuel_numar_acceso_agua.repository.DataRegionRepositoryImpl;
import org.emmanuel_numar_acceso_agua.service.AccesoAlAguaRecordService;
import org.emmanuel_numar_acceso_agua.service.AccesoAlAguaRecordServiceImpl;

public class ApplicationRunner {
  public static void main(String[] args) {

    AccesoAlAguaRecordService accesoAlAguaRecordService =
        new AccesoAlAguaRecordServiceImpl(new DataRegionRepositoryImpl());

    System.out.println("Las regiones de Colombia Son: ");
    accesoAlAguaRecordService.MostrarNombreRegion();
    System.out.println();
    System.out.println("La poblacion nacional de Colombia es: "+ accesoAlAguaRecordService.PoblacionColombia());
    System.out.println();
    System.out.println("El consumo de agua potable a nivel Colombia es: "+ accesoAlAguaRecordService.ConsumoAguaColombia()+" Lts");
    System.out.println();
    System.out.println("El consumo promedio de agua nacional por individuo es: "+ accesoAlAguaRecordService.HallarPromConsPersonaNacional()+" lts");
    System.out.println();
    System.out.println("La región con menos acceso al agua potable es: "+ accesoAlAguaRecordService.HallarRegionConMenorAccesoAlAgua());
    System.out.println("\nEl consumo regional por persona es: ");
    System.out.println();
    accesoAlAguaRecordService.HallarConsumoPersonaXRegion();
    System.out.println("La region que menos agua potable consume por persona es: "+ accesoAlAguaRecordService.HallarRegionConMenorConsuXPersona());
    System.out.println();
    System.out.println("La region que mas agua potable consume por persona es: "+ accesoAlAguaRecordService.HallarRegionConMayorConsuXPersona());
    System.out.println("\tProfe, no usamos logger para mostrar mensajes porque a nuestro concepto se veia feo a la hora de imprimir. ");
  }
}
