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
    private File archivo;

    public Archivo(File archivo) {
        this.archivo = archivo;
    }
    
    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
    
    
}
