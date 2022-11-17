
package ee;

import java.util.Iterator;

public class ConjuntoE <T> implements ConjuntoEDT<T> {
    private EE<T> conjunto;
    
    public ConjuntoE(){
        conjunto = new EE();
    }

    public int getCardinalidad() {
        return conjunto.cuentaElementos();
    }
    
    public boolean contiene(T dato){  // Se pudo hacer con búsq secuencial en el arreglo
        Iterator<T> it = iterator();
        boolean encontro = false;
        
        while (it.hasNext() && !encontro)
            encontro = it.next().equals(dato);
        return encontro;    
    }

    public boolean estaVacio(){
    	return conjunto.estaVacia();
    }
    
    public boolean agrega(T dato){
        conjunto.agregaFinal(dato);
        return true;
    }

    public T elimina(T dato){
        return conjunto.eliminaElemento(dato);
    }
    
    public String toString(){
        return conjunto.toString();
    }
    
    public ConjuntoEDT<T> union(ConjuntoEDT<T> otro){
        if (otro == null)
            throw new RuntimeException("No es un conjunto");
        
        otro = new ConjuntoE();
        
            if (this.getCardinalidad() > otro.getCardinalidad()){
                this.conjunto.merge(otro.conjunto);
            }
            else {
                otro.conjunto.merge(this);
            }
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
