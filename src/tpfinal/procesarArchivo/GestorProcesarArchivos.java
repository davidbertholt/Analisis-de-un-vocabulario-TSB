/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.procesarArchivo;

import java.io.File;
import java.util.List;
import tpfinal.Maestro;

/**
 *
 * @author Lucas
 */
public class GestorProcesarArchivos {
    private File archivo;
    private CortarRenglones primeraEtapa;
    private CortarPalabraPorPalabra segundaEtapa;

    public GestorProcesarArchivos(File archivo) {
        this.archivo = archivo;
        this.primeraEtapa = new CortarRenglones(archivo);
        this.segundaEtapa = new CortarPalabraPorPalabra();
    }
    
    public Maestro procesarArchivo(){
        Maestro contenedorAux = new Maestro();
        List<String> renglones;
        
        renglones = primeraEtapa.run();
        
        
        return contenedorAux;
    }
    
    
    
    
}
