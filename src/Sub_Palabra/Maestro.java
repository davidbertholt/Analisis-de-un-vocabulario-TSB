/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sub_Palabra;

import Sub_Palabra.Lista.SimpleList;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author Lucas
 */
public class Maestro {
    private SimpleList detallepalabras;
    private Map<String, Detalle> treeMap;
    
    public Maestro() {
    detallepalabras = new SimpleList();
    treeMap = new TreeMap<>();
    }
    
    public Maestro(List<Maestro> lista){
        treeMap = new TreeMap<>();
        combinarDetalles(lista);
    }
    
    //Version 1 (Tiempo para procesar a.txt 19 seg)
    public void procesarPalabra2(String palabra, File archivo){
        detallepalabras.procesarPalabra(palabra, archivo);
    }
    
    //Version 2 (Tiempo para procesar a.txt 2 seg)
    public void procesarPalabra(String palabra, File archivo){
        Detalle aux = treeMap.get(palabra);
        if( aux != null) {
            //esto se podria poner en una sola linea de if
            aux.aumentarFrecuencia();
            treeMap.put(palabra, aux);
        }
        else{
            
            aux = new Detalle(palabra, archivo);
            treeMap.put(palabra, aux);
        }
        System.out.println(treeMap.size());
    }
    
    public int cantidadDePalabras(){
        return detallepalabras.getCantidad();
    }
    
    @Override
    public String toString(){
        
        return detallepalabras.toString();
    }

    public Map<String, Detalle> getTreeMap() {
        return treeMap;
    }

    public void setTreeMap(Map<String, Detalle> treeMap) {
        this.treeMap = treeMap;
    }
    
    
    
    public void mostrarMap(){

        Set< String > claves = treeMap.keySet(); // obtiene las claves

            // ordena las claves

        TreeSet< String > clavesOrdenadas = new TreeSet< String >( claves );

        System.out.println( "El mapa contiene:\nClave\t\tValor" );

        // genera la salida para cada clave en el mapa

        for ( String clave : clavesOrdenadas )
            System.out.printf( "%-10s%10s\n", clave, treeMap.get( clave ).getFrecuencia() );

    System.out.println(treeMap.size());
} // fin del método mostrarMap

    private void combinarDetalles(List<Maestro> lista) {
        
        for (Maestro maestro : lista) {
            Map<String, Detalle> mapaIndividual = maestro.getTreeMap();
            
            for (Map.Entry<String, Detalle> entry : mapaIndividual.entrySet()){
              
              if( treeMap.containsKey(entry.getKey())){
                  
                  Detalle detalleGlobal = treeMap.get(entry.getKey());
                  Detalle detalleLocal = mapaIndividual.get(entry.getKey());
                  
                  detalleGlobal.compararArchivos(detalleLocal.getArchivo());
                  detalleGlobal.sumarFrecuencias(detalleLocal.getFrecuencia());
                  treeMap.put(entry.getKey(), detalleGlobal);
                  
              }
              else{
                  treeMap.put(entry.getKey(), entry.getValue());
              }
                
            }
        }
    }
}
