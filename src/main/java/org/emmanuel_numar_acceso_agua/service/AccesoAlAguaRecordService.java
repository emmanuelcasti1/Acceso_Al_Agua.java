package org.emmanuel_numar_acceso_agua.service;

import org.emmanuel_numar_acceso_agua.excepcion.ConsumoNoEncontradoExcepcion;
import org.emmanuel_numar_acceso_agua.model.consumoXRegion;

import java.util.List;

public interface AccesoAlAguaRecordService {
  void mostrarNombreRegion();
  int poblacionColombia();
  double consumoAguaColombia();
  double hallarPromConsPersonaNacional();
  String hallarRegionConMenorAccesoAlAgua();
  consumoXRegion getconsumoXRegion(String nombre) throws ConsumoNoEncontradoExcepcion;
  void hallarConsumoPersonaXRegion();
  String hallarRegionConMenorConsuXPersona();
  String hallarRegionConMayorConsuXPersona();
  List<consumoXRegion> listAllConsumos();
  consumoXRegion addconsumoXRegion(consumoXRegion newconsumoXRegion);

}
