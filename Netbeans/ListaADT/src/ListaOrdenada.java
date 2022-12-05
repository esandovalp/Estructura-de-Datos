
public class ListaOrdenada <T extends Comparable<T>> extends Lista<T> implements ListaOrdenadaADT<T> {
    
    public void agrega(T dato){
        NodoDoble<T> nuevo = new NodoDoble(dato);
        
        if (this.estaVacia()){
            primero = nuevo;
            ultimo = nuevo;
        } else 
            if (primero.getDato().compareTo(dato) >= 0){
                nuevo.setSiguiente(primero);    // no ocupa setAnterior(null) porque el constructor ya lo hace
                primero.setAnterior(nuevo);
                primero = nuevo;
            } else 
                if (ultimo.getDato().compareTo(dato) <= 0){
                    nuevo.setAnterior(ultimo);
                    ultimo.setSiguiente(nuevo);
                    ultimo = nuevo;
                } else {
                    NodoDoble<T> actual = primero.getSiguiente(); 
                    while (actual.getDato().compareTo(dato) < 0)
                        actual = actual.getSiguiente();
                    
                    nuevo.setAnterior(actual.getAnterior());
                    nuevo.setSiguiente(actual);
                    actual.getAnterior().setSiguiente(nuevo);
                    actual.setAnterior(nuevo);
                }
    }
    
    private NodoDoble<T> buscaDato(T dato, NodoDoble<T> actual) {
        if (actual == null || actual.getDato().compareTo(dato) > 0)
            return null;
        else 
            if (actual.getDato().equals(dato))
                return actual;
            else 
                return buscaDato(dato, actual.getSiguiente());
    }
    
    public boolean contiene(T dato){
        boolean resp = false;
        
        if (!this.estaVacia()){
            if (ultimo.getDato().equals(dato))
                resp = true;
            else 
                if (ultimo.getDato().compareTo(dato) > 0)
                    resp = buscaDato(dato, primero) != null;
        }
        
        return resp; 
    }
    
    public T quita(T dato) {
        T resultado = null;
        
        if (!this.estaVacia())
            if (ultimo.getDato().equals(dato))
                resultado = this.quitaUltimo();
            else 
                if (ultimo.getDato().compareTo(dato) > 0){
                    NodoDoble aEliminar = buscaDato(dato, primero);
                    if (aEliminar != null)
                        if (aEliminar == primero)
                            resultado = this.quitaPrimero();
                        else {
                            aEliminar.getAnterior().setSiguiente(aEliminar.getSiguiente());
                            aEliminar.getSiguiente().setAnterior(aEliminar.getAnterior());
                            aEliminar.setAnterior(null);
                            aEliminar.setSiguiente(null);
                        }
                    
                }
        
        return resultado;
    }
    
    public boolean equals(Object obj){
        boolean resp = false;
        
        if(obj != null && obj instanceof ListaOrdenada)
            if (obj == this)
                resp = true;
            else {
                ListaOrdenada otra = (ListaOrdenada) obj;
                
                if (this.estaVacia() && otra.estaVacia())
                    resp = true;
                else
                    if (!this.estaVacia() && !otra.estaVacia())
                        if (primero.getDato().equals(otra.primero.getDato()) && ultimo.getDato().equals(otra.ultimo.getDato())){
                            NodoDoble<T> actualThis = primero.getSiguiente();
                            NodoDoble<T> actualOtra = otra.primero.getSiguiente();
                            
                            while (actualThis != null && actualOtra != null  && actualThis.getDato().equals(actualOtra.getDato())){
                                actualThis = actualThis.getSiguiente();
                                actualOtra = actualOtra.getSiguiente();
                            }
                            
                            resp = actualThis == null && actualOtra == null;
                        }
            }
        
        return resp; 
    }
}
