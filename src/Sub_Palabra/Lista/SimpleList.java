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
import java.io.File;
import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;
public class SimpleList implements Iterable, Serializable
{
      private Node frente;
      
      private int cantidad;
      
      public SimpleList ()
      {
          frente = null;
          cantidad = 0;
      }

    public int getCantidad() {
        return cantidad;
    }
      
      
      public void add( int index, Detalle x )
      {
          if( ! isHomogeneus( x ) ) { throw new ClassCastException( "Objeto incompatible" ); }
          if( index < 0 || index > size() ) { throw new IndexOutOfBoundsException( "Indice fuera del rango" ); }

          Node nuevo = new Node( x, frente );
          if( index == 0 ) { frente = nuevo; }
          else
          {
            Node p = frente;
            for( int i = 0; i < index - 1; i++ ) { p = p.getNext(); }
            nuevo.setNext( p.getNext() );
            p.setNext( nuevo );
          }         
          
          cantidad++;
      }    
      
      public void addFirst( Detalle x )
      {
            if ( ! isHomogeneus( x ) ) return;
            
            Node p = new Node(x, frente);
            frente = p;
            cantidad++;
      }  
      
      public void procesarPalabra(String palabra, File archivo){
          
            Node p = frente, q = null;
            boolean banderaCicloPalabraIgual = true;
            boolean banderaCicloOrden = true;
            
            while ( p != null && banderaCicloPalabraIgual && banderaCicloOrden )
            {
                if(palabra.compareToIgnoreCase(p.getInfo().getPalabra().getNombre() ) == 0){
                    p.getInfo().aumentarFrecuencia();
                    banderaCicloPalabraIgual = false;
                }
                
                if(palabra.compareToIgnoreCase(p.getInfo().getPalabra().getNombre() ) < 0){
                    banderaCicloOrden = false;
                }
                
                q = p;
                p = p.getNext();
            }
            
            if(!banderaCicloOrden){
            Detalle x = new Detalle(palabra, archivo);
            Node nuevo = new Node( x, null );
            nuevo.setNext( p );
            if( q != null ) q.setNext( nuevo );
            else frente = nuevo;
            cantidad++;  
            } 
      }
      
      public void addInOrder(Detalle x)
      {
            
            
            Node nuevo = new Node( x, null );
            Node p = frente, q = null;
            while ( p != null && x.getPalabra().getNombre().compareToIgnoreCase(p.getInfo().getPalabra().getNombre() ) >= 0 )
            {
                q = p;
                p = p.getNext();
            }
            nuevo.setNext( p );
            if( q != null ) q.setNext( nuevo );
            else frente = nuevo;
            cantidad++;
      }             
      
      
      public void addLast( Detalle x )
      {
            if ( ! isHomogeneus( x ) ) return;
            
            Node nuevo = new Node( x, null );
            Node p = frente;
            while ( p != null && p.getNext() != null ) { p = p.getNext(); }
            if( p != null ) p.setNext( nuevo );
            else frente = nuevo;
            cantidad++;
      }  
      
      public void clear( )
      {
         frente = null; 
         cantidad = 0;
      }
      
      public boolean contains( Detalle x )
      {
          if ( ! isHomogeneus( x ) ) return false;
          
          Node p = frente;
          while ( p != null && x.compareTo( p.getInfo() ) != 0 ) { p = p.getNext(); }   
          return ( p != null );
      }

      public Comparable get( int index )
      {
          if( index < 0 || index >= size() ) throw new IndexOutOfBoundsException( "Indice fuera del rango" );
         
          Node p = frente;
          for( int i = 0; i < index; i++ ) { p = p.getNext(); }
          return p.getInfo();
      }
      
      public Comparable getFirst()
      {
         if (frente == null) throw new NoSuchElementException("Error: la lista esta vacia...");
         return frente.getInfo();
      }
      
      public Comparable getLast()
      {
         if (frente == null) throw new NoSuchElementException("Error: la lista esta vacia...");
         Node p = frente;
         while( p.getNext() != null ) { p = p.getNext(); }
         return p.getInfo();
      }
      
      public int indexOf( Comparable x )
      {
            if ( ! isHomogeneus( x ) )  return -1;
            
            int c = 0;
            for ( Node p = frente; p != null; p = p.getNext() )
            {
                if( x.compareTo( p.getInfo() ) == 0 ) return c;
                c++;
            }
            return -1;
      }
      
      public boolean isEmpty()
      {
         return (frente == null);    
      }

      @Override
      public Iterator iterator()
      {
        return new SimpleListIterator();  
      }
      
      public Comparable remove( int index )
      {
          if( index < 0 || index >= size() ) throw new IndexOutOfBoundsException( "Indice fuera del rango" );

          Node p = frente, q = null;
          for( int i = 0; i < index; i++ ) 
          {
              q = p;
              p = p.getNext();
          }
          
          Comparable x = p.getInfo();
          if( q == null ) frente = p.getNext();
          else q.setNext( p.getNext() );
          
          cantidad--;
          return x; 
      }

      public boolean remove( Comparable x )
      {
          if( ! isHomogeneus( x ) ) return false;
          
          Node p = frente, q = null;
          while( p != null && x.compareTo( p.getInfo() ) != 0  ) 
          {
              q = p;
              p = p.getNext();
          }
          
          if( p == null ) return false;
  
          if( q == null ) frente = p.getNext();
          else q.setNext( p.getNext() );      
          
          cantidad--;
          return true;
      }
      
      public Comparable removeFirst()
      {
         if (frente == null) throw new NoSuchElementException("Error: la lista esta vacia...");
         
         Comparable x = frente.getInfo();
         frente = frente.getNext();
         
         cantidad--;
         return x;
      }

      public boolean removeFirstOccurrence( Comparable x )
      {
          return remove(x);
      }
      
      public Comparable removeLast()
      {
         if (frente == null) throw new NoSuchElementException("Error: la lista esta vacia...");
         
         Node p = frente, q = null;
         while( p.getNext() != null )
         {
            q = p;
            p = p.getNext();
         }
         Comparable x = p.getInfo();
         if( q != null ) q.setNext( p.getNext() );
         else frente = p.getNext();
         
         cantidad--;
         return x;
      }
     
      public Comparable search (Comparable x)
      {
            if ( ! isHomogeneus( x ) )  return null;
            
            for ( Node p = frente; p != null; p = p.getNext() )
            {
                if( x.compareTo( p.getInfo() ) == 0 ) return p.getInfo();
            }
            return null;
      }
            
      public Comparable set( int index, Detalle x )
      {
          if( ! isHomogeneus( x ) ) throw new ClassCastException( "Objeto incompatible" );
          if( index < 0 || index >= size() ) throw new NoSuchElementException( "Indice fuera del rango" );
         
          Node p = frente;
          for( int i = 0; i < index; i++ ) { p = p.getNext(); }
          
          Comparable ant = p.getInfo();
          p.setInfo( x );
          return ant;
      }
      
      public int size()
      {
          return cantidad;
      }
      
    @Override
      public String toString()
      {
             StringBuilder res = new StringBuilder( "[ " );
             for( Node p = frente; p != null;  p = p.getNext() )
             {
                res.append( p.toString() + "\n" );
                if ( p.getNext() != null ) res.append( " - " );
             }
             res.append( " ]" );
             return res.toString();
      }
      
      private boolean isHomogeneus (Comparable x)
      {
            if ( x == null ) return false;
            if ( frente != null && x.getClass() != frente.getInfo().getClass() ) return false;
            return true;
      }
      
      private class SimpleListIterator implements Iterator
      {

          private Node actual;          // patron Iterator: direccion del nodo que toca procesar.
          private Node previo;          // direccion del nodo anterior al actual.
          private boolean  next_invocado;   // true: next fue invocado (usado por remove()...)
        
          public SimpleListIterator()
          {
             actual = null;
             previo = null;
             next_invocado = false;
          }
        
         /**
          * Indica si queda algun objeto en el recorrido del iterador.          *
          * @return true si queda algun objeto en el recorrido - false si no
          * quedan objetos.
          */
         @Override
         public boolean hasNext()
         {
              if (frente == null) { return false; }
              if (actual != null && actual.getNext() == null) { return false; }
              return true;
         }

         /**
          * Retorna el siguiente objeto en el recorrido del iterador.          *
          * @return el siguiente objeto en el recorrido.
          * @throws NoSuchElementException si la lista esta vacia o en la lista
          * no quedan elementos por recorrer.
          */
         @Override
         public Comparable next()
         {
            if (!hasNext()) { throw new NoSuchElementException("No quedan elementos por recorrer"); }

            if (actual == null) { actual = frente; } 
            else
            {
                previo = actual;
                actual = actual.getNext();
            }
            next_invocado = true;
            
            return actual.getInfo();
         }
         
         /**
          * Elimina el ultimo elemento que retorno el iterador. Debe invocarse primero a next(). El iterador 
          * queda posicionado en el elemento anterior al eliminado. 
          * @throws IllegalStateException si se invoca a remove() sin haber invocado a next(), o si 
          * remove fue invocado mas de una vez luego de una invocacion a next().
          */
         @Override
         public void remove()
         {
            if(!next_invocado) { throw new IllegalStateException("Debe invocar a next() antes de remove()..."); }
             
            if (previo == null)
            {
                frente = actual.getNext();
            }
            else
            {
                previo.setNext(actual.getNext());
            }

            actual = previo;
            next_invocado = false;
            cantidad--;
         }
      }
}