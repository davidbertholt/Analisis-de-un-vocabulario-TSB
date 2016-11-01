/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal;

import ProcesarArchivo.GestorProcesarArchivos;
import Sub_Palabra.Maestro;
import java.io.File;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class Gestor {
    private List<File> colaArchivos;
    private GestorProcesarArchivos gestorArchivos;
    private Maestro palabras;
    
    public Gestor(List<File> colaArchivos) {
        this.colaArchivos = colaArchivos;
        this.palabras = new Maestro();
     }
    
    //Cambiar a procesamiento con hilos.
    public void procesarArchivos(){
      /*  List<Maestro> maestros = new ArrayList<>();
        for (File e : archivos) {
            maestros.add(procesarArchivoIndividual(e));
        }*/
        File e = colaArchivos.get(0);
        
        palabras = procesarArchivoIndividual(e);
    }
        
    private Maestro procesarArchivoIndividual(File archivo){
        Maestro aux;
        
        gestorArchivos = new GestorProcesarArchivos(archivo);
        aux = gestorArchivos.procesarArchivo();
        
        return aux;
    }
   
    public int cantidadDePalabras(){
        return palabras.cantidadDePalabras();
    }
    
    public String toString(){
        return palabras.toString();
    }
}
