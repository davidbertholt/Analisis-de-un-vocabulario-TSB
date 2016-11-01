/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazUsuario;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import tpfinal.Gestor;

/**
 *
 * @author Lucas
 */
public class TpFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File f = new File("D:\\UTN\\CURSANDO\\DSI\\TPI 2016\\netBeans\\TpFinal\\src\\a.txt");
        File fa = new File("D:\\UTN\\CURSANDO\\DSI\\TPI 2016\\netBeans\\TpFinal\\src\\c.txt");
        File fs = new File("D:\\UTN\\CURSANDO\\DSI\\TPI 2016\\netBeans\\TpFinal\\src\\b.txt");
        File faa = new File("D:\\UTN\\CURSANDO\\DSI\\TPI 2016\\netBeans\\TpFinal\\src\\d.txt");
        List<File> lista = new ArrayList<>();
        lista.add(f);
        lista.add(fa);
        lista.add(fs);
       // lista.add(faa);
        
        Gestor g = new Gestor(lista);
        
        g.procesarArchivos();
     //   System.out.println("Palabras: " + g.toString());
        //g.mostrarMapa();
       // System.out.println(g.cantidadDePalabras());
        //System.out.println(g.cantidadDePalabras());
        
    }
    
}
