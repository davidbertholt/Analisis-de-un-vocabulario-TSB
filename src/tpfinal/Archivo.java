/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal;

import java.io.File;

/**
 *
 * @author Lucas
 */
public class Archivo {
    private String nombre;
    private File archivo;

    public Archivo(String nombre) {
        this.nombre = nombre;
    }

    public Archivo(String nombre, File archivo) {
        this.nombre = nombre;
        this.archivo = archivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
    
    
}
