/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class Detalle {
    private int frecuencia;
    private List<Archivo> archivo;
    private Palabra palabra;

    public Detalle(int frecuencia, Palabra palabra) {
        this.frecuencia = frecuencia;
        this.archivo = new ArrayList<>();
        this.palabra = palabra;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }

    public List getArchivo() {
        return archivo;
    }

    public void agregarArchivo(Archivo archivo) {
        this.archivo.add(archivo);
    }

    public Palabra getPalabra() {
        return palabra;
    }

    public void setPalabra(Palabra palabra) {
        this.palabra = palabra;
    }
    
    
}
