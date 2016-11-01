/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProcesarArchivo;

import java.io.File;
import java.util.List;
import Sub_Palabra.Maestro;

/**
 *
 * @author Lucas
 */
public class CortarPalabraPorPalabra {
    
    public Maestro run(List<String> lista, File archivo){
        Maestro contenedor = new Maestro();
        
        for (String renglon : lista) {
            char[] renglonAux = convertirStrintAChar(renglon);
            contenedor = valuarArray(renglonAux, contenedor, archivo);
        }
        
        return contenedor;
    }
    
    
    
    private char[] convertirStrintAChar(String linea) {
       char[] aCaracteres = linea.toCharArray();
       
       return aCaracteres;
    }
    
    public Maestro valuarArray(char[] cadena, Maestro maestro, File archivo) {
       String aux = "";
       
       for (char c : cadena) {
           
           if(validarCaracter(c)){
              
              aux = formatoPalabra(aux);
               maestro.procesarPalabra(aux, archivo);
               aux = "";
           }else{
               aux+=c;
           }
       }
       aux = formatoPalabra(aux);
       maestro.procesarPalabra(aux, archivo);
       
       return maestro;
   }
    
    private boolean validarCaracter(char c){
        return (c == ' ');
    }
    
    private String formatoPalabra(String palabra){
        palabra = quitarSignos(palabra);
        palabra = palabra.toUpperCase();
        return palabra;
    }
    
    private static String quitarSignos(String hilera1) {
     // return hilera1.replaceAll("\\p{Punct}", ""); 
    return hilera1.replaceAll("[^\\dA-Za-z ]", "");
}
}
