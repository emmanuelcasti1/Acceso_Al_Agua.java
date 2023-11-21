package org.emmanuel_numar_acceso_agua.controller;


import org.emmanuel_numar_acceso_agua.model.consumoXRegion;
import org.emmanuel_numar_acceso_agua.repository.ConsumoXRegionUsingFileRepositoryImpl;
import org.emmanuel_numar_acceso_agua.service.AccesoAlAguaRecordService;
import org.emmanuel_numar_acceso_agua.service.AccesoAlAguaRecordServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consumo/")
@CrossOrigin(origins = "*")
public class ConsumoController {
    AccesoAlAguaRecordService accesoAlAguaRecordService = new AccesoAlAguaRecordServiceImpl(new ConsumoXRegionUsingFileRepositoryImpl());
    @GetMapping
    public List<consumoXRegion> listConsumos(){

        System.out.println("listando estadísticas");
        List<consumoXRegion> consumoXRegionList =   accesoAlAguaRecordService.listAllConsumos();

        return consumoXRegionList;
    }

    @PostMapping
    public ResponseEntity<consumoXRegion> addconsumoXRegion(@RequestBody consumoXRegion newconsumoXRegion){
        System.out.println("Agregando consumo");
        consumoXRegion ConsumoXRegion = accesoAlAguaRecordService.addconsumoXRegion(newconsumoXRegion );
        return ResponseEntity.status( HttpStatus.OK).body( ConsumoXRegion);
    }


}
