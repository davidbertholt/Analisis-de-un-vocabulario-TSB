/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal;

import ProcesarArchivo.GestorProcesarArchivos;
import Sub_Palabra.Maestro;
import java.io.File;
import java.util.ArrayList;
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
     }
    
    //Cambiar a procesamiento con hilos.
    public void procesarArchivos(){
        List<Maestro> maestros = new ArrayList<>();
        for (File e : colaArchivos) {
            maestros.add(procesarArchivoIndividual(e));
        }
        
        palabras = new Maestro(maestros);
        System.out.println(palabras.getTreeMap().size());
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
    
    @Override
    public String toString(){
        return palabras.toString();
    }
    
    public void mostrarMapa(){
        palabras.mostrarMap();
    }
}
