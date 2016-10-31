/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sub_Palabra.Lista;

/**
 *
 * @author Lucas
 */
import Sub_Palabra.Detalle;
import java.io.Serializable;

public class Node implements Serializable
{
   private Detalle info;
   private Node next;
   
   public Node ( )
   {
   }
   
   public Node (Detalle x, Node p)
   {
     info = x;
     next = p;
   }
   
   public Node getNext()
   {
     return next;
   }
   
   public void setNext(Node p)
   {
     next = p;
   }
   
   public Detalle getInfo()
   {
     return info;
   }
   
   public void setInfo(Detalle p)
   {
     info = p;
   }
   
   
   
   @Override
   public String toString()
   {
     return info.toString();   
   }
}


