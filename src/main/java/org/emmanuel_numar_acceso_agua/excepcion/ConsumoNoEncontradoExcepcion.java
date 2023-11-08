package org.emmanuel_numar_acceso_agua.excepcion;

import java.text.MessageFormat;

public class ConsumoNoEncontradoExcepcion extends Exception{

    public ConsumoNoEncontradoExcepcion(String nombreRegion) {
        super( MessageFormat.format( "No se encontró una region con ese nombre {0}", nombreRegion ) );
    }
}
