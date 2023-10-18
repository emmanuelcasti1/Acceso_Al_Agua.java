package org.emmanuel_numar_acceso_agua.service;

public interface AccesoAlAguaRecordService {
  String MostrarNombreRegion();
  Integer PoblacionColombia();
  double ConsumoAguaColombia();
  double HallarPromConsPersonaNacional();
  String HallarRegionConMenorAccesoAlAgua();
  void HallarConsumoPersonaXRegion();
  String HallarRegionConMenorConsuXPersona();
  String HallarRegionConMayorConsuXPersona();

}
