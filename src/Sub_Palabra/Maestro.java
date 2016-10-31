/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sub_Palabra;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.transformation.SortedList;

/**
 *
 * @author Lucas
 */
public class Maestro {
    private List<Detalle> detallepalabras;
    
    public Maestro() {
    detallepalabras = new ArrayList<Detalle>();
    }
    
    public void procesarPalabra(String palabra, File archivo){
        boolean bandera = true;
        for (Detalle Detallepalabra : detallepalabras) {
            if(Detallepalabra.existePalabra(palabra)){
                bandera = false;
                break;
            }
        }
        
        if(bandera){
           
        }
    }
}
