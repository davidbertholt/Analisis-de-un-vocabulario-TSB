/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sub_Palabra;

/**
 *
 * @author Lucas
 */
public class Palabra {
    private String nombre;

    public Palabra() {
    }

    public Palabra(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Palabra{" + "nombre=" + nombre + '}';
    }

    boolean esIgual(String palabra) {
        return nombre.equalsIgnoreCase(palabra);
    }
    
    
}
