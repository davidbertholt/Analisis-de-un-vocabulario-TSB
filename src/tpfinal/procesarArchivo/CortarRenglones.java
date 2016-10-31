/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.procesarArchivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class CortarRenglones {
    private File archivo;

    public CortarRenglones(File archivo) {
        this.archivo = archivo;
    }

   public List<String> run() {
        List<String> listaAux = new ArrayList<>();
        
        try{    
        
        File f = archivo;
   
        FileReader in;
    
        BufferedReader ifile;
        
        in = new FileReader(f);
        ifile = new BufferedReader(in);
                               
       

       // El metodo readLine retorna el String leido, 
       // o null si encontro el final del archivo
       String linea = ifile.readLine();
       int i=0 ;
        while(linea!=null)
       {
           
        
            
         listaAux.add(linea);
         
         
         i++;
        
         linea = ifile.readLine();
       }
            System.out.println("********************FIN********************++");
       ifile.close();
       in.close();
      }
       catch(IOException e)
      {
         System.out.println("Error: " + e.getMessage() + " (al operar con el archivo)");
      }
      catch(NullPointerException e)
      {
         System.out.println("Ocurrio un error (" + e.getMessage() + ") con el programa. Revise");
      }
      catch(Exception e)
      {
         System.out.println("Ocurrio un error (" + e.getMessage() + ") con el programa. Revise");
      }
        
        return listaAux;
    }
    
    
}
