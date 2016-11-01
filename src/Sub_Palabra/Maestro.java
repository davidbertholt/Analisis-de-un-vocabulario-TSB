/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sub_Palabra;

import Sub_Palabra.Lista.SimpleList;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.transformation.SortedList;

/**
 *
 * @author Lucas
 */
public class Maestro {
    private SimpleList detallepalabras;
    
    public Maestro() {
    detallepalabras = new SimpleList();
    }
    
    public void procesarPalabra(String palabra, File archivo){
        detallepalabras.procesarPalabra(palabra, archivo);
    }
    
    public int cantidadDePalabras(){
        return detallepalabras.getCantidad();
    }
    
    public String toString(){
        return detallepalabras.toString();
    }
}
