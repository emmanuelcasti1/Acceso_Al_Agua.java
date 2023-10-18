package org.emmanuel_numar_acceso_agua.service;

import static org.junit.jupiter.api.Assertions.*;

import org.emmanuel_numar_acceso_agua.repository.DataRegionRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AccesoAlAguaRecordServiceImplTest {

  private AccesoAlAguaRecordService accesoAlAguaRecordService;

  @BeforeEach
  void setUp() {
    this.accesoAlAguaRecordService = new AccesoAlAguaRecordServiceImpl(new DataRegionRepositoryImpl());
  }



  @Test
  void poblacionColombia() {
    Integer poblacion = this.accesoAlAguaRecordService.PoblacionColombia();

    assertNotNull(poblacion); // Se verifica que la poblacion no sea nulo
    assertEquals(52712323, poblacion); // Se verifica que la poblacion sea  = 52712323
  }

  @Test
  void consumoAguaColombia() {
    /*
     El consumo nacional está dado por los siguientes datos:
      "Caribe", 35500600
      "Andina",150000000
      "Orinoquía",20000000
      "Amazonía",5000000
      "Insular",1000000
      "Pacífica",10000000
      * Para hallar el consumo lo unico que deberia
       hacer el método es sumar los diferentes consumos nacionales.
     * */
    Double consumo = this.accesoAlAguaRecordService.ConsumoAguaColombia();

    assertNotNull(consumo); // Se verifica que el consumo no sea nulo
    assertEquals(2.215006E8, consumo); // Se verifica que la suma sea (consumo) = 2.215006E8
  }

  @Test
  void hallarPromConsPersonaNacional() {
    Double promedio = this.accesoAlAguaRecordService.HallarPromConsPersonaNacional();

    assertNotNull(promedio); // Se verifica que el consumo promedio no sea nulo
    assertEquals(4.202064856826742, promedio); // Se verifica que el promedio sea igual a  = 4.202064856826742
  }

  @Test
  void hallarRegionConMenorAccesoAlAgua() {
    String menorAcceso = this.accesoAlAguaRecordService.HallarRegionConMenorAccesoAlAgua();

    assertNotNull(menorAcceso); // Se verifica que el menorAcceso no sea nulo
    assertEquals("Insular",menorAcceso); // Se verifica que la region con menor acceso sea = "insular"
  }

  @Test
  void hallarRegionConMenorConsuXPersona() {
    String consumo = this.accesoAlAguaRecordService.HallarRegionConMenorConsuXPersona();

    assertNotNull(consumo); // Se verifica que el consumo no sea nulo
    assertEquals("Caribe", consumo); // Se verifica que la region con menor consumo sea = "Caribe"
  }

  @Test
  void hallarRegionConMayorConsuXPersona() {
    String consumo = this.accesoAlAguaRecordService.HallarRegionConMayorConsuXPersona();

    assertNotNull(consumo); // Se verifica que el consumo no sea nulo
    assertEquals("Orinoquía", consumo); // Se verifica que la region con menor consumo sea = "Orinoquía
  }
}
