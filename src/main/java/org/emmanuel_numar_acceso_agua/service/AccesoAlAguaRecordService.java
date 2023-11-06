package org.emmanuel_numar_acceso_agua.service;

public interface AccesoAlAguaRecordService {
  void mostrarNombreRegion();
  int poblacionColombia();
  double consumoAguaColombia();
  double hallarPromConsPersonaNacional();
  String hallarRegionConMenorAccesoAlAgua();
  void hallarConsumoPersonaXRegion();
  String hallarRegionConMenorConsuXPersona();
  String hallarRegionConMayorConsuXPersona();

}
