/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sub_Palabra;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class Detalle implements Comparable<Detalle>{
    private int frecuencia;
    private List<File> archivo;
    private Palabra palabra;

    public Detalle(String palabra, File archivo) {
        this.frecuencia = 1;
        this.archivo = new ArrayList<>();
        this.archivo.add(archivo);
        this.palabra = new Palabra(palabra);
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }

  

    public void agregarArchivo(File archivo) {
        this.archivo.add(archivo);
    }

    public Palabra getPalabra() {
        return palabra;
    }

    public void setPalabra(Palabra palabra) {
        this.palabra = palabra;
    }
    
    public boolean esMismaPalabra(String palabraNueva){
        return this.palabra.esIgual(palabraNueva); 
    }
    
    public void aumentarFrecuencia(){
        frecuencia++;
    }

    @Override
    public int compareTo(Detalle o) {
        return palabra.getNombre().compareToIgnoreCase(o.getPalabra().getNombre());
    }

    public int cantidadDeArchivos(){
        return archivo.size();
    }

    @Override
    public String toString() {
    return palabra.getNombre() + " - Frecuencia: " + frecuencia;
    }    
    
    public boolean esPalabraAlfabetoMayorIgual(String x){
       return  palabra.esPalabraAlfabetoMayorIgual(x);
    }
    
    public void compararArchivos(File nuevo){
        boolean control = false;
        for (File file : archivo) {
            if(nuevo==file){
                control = true;
                break;
            }
        }
        if(control){
            archivo.add(nuevo);
        }
    }
    
    public File getArchivo(){
        return archivo.get(0);
    }
    
    public void sumarFrecuencias(int nueva){
        frecuencia+=nueva;
    }
}
