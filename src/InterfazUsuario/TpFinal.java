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
        List<File> lista = new ArrayList<>();
        lista.add(f);
        
        Gestor g = new Gestor(lista);
        
        g.procesarArchivos();
        //System.out.println("Palabras: " + g.toString());
        
    }
    
}
