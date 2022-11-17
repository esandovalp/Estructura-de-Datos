
package ee;

public class EE <T>  {
    private Nodo<T> primero;

    public EE() {
        this.primero = null;    // esta vacia 
    }
    
    public boolean estaVacia(){
        return primero == null;
    }
    
    public void agregaInicio(T dato){
        Nodo<T> nuevo = new Nodo(dato);
        nuevo.setSig(primero);
        primero = nuevo;
    }
    
    @Override
    public String toString(){
        return toString(new StringBuilder(), primero);
    }
    
    private String toString(StringBuilder sB, Nodo<T> actual){
        if (actual == null)
            return sB.toString();
        else {
            sB.append(actual.getDato()).append(" ");
            return toString(sB,actual.getSig());
        }
    }
    
    public void agregaFinal(T dato){
        if (this.estaVacia())
            agregaInicio(dato);
        else
            agregaFinal(primero,dato);
    }
    
    private void agregaFinal(Nodo<T> actual, T dato){
        if (actual.getSig() == null) {  // es el ultimo nodo
            Nodo<T> nuevo = new Nodo(dato);
            actual.setSig(nuevo);
        } else
            agregaFinal(actual.getSig(), dato);
    }
    
    public T quitaPrimero(){
        T resultado = null;
        
        if (!this.estaVacia()){
            resultado = primero.getDato();
            Nodo<T> temporal = primero;
            primero = primero.getSig();
            temporal.setSig(null);
        }
        
        return resultado;
    }
    
    public T quitaUltimo(){
        T resultado = null;
        
        if (!this.estaVacia()) {
            Nodo<T> ant = null;
            Nodo<T> actual = primero;
            
            while (actual.getSig() != null){
                ant = actual;
                actual = actual.getSig();
            }
            
            resultado = actual.getDato();
            
            if (ant == null) // una EE que tiene solo un nodo 
                primero = null; // la EE quedo vacia
            else 
                ant.setSig(null);
        }
         return resultado;   
    }
    
    public int buscaElemento(T elemento){
        return buscaElemento(elemento, primero, 0);
    }
    
    private int buscaElemento(T elemento, Nodo<T> actual, int i){
        if (actual == null)        // vemos si termina la busqueda o la EE esta vacia 
            return -1;
        else {
            if (actual.getDato().equals(elemento))
                return i;
            else 
                return buscaElemento(elemento, actual.getSig(), i+1);
        }
    }
    
    public boolean buscaElementoBooleano(T elemento){
        return buscaElementoBooleano(elemento, primero);
    }
    
    private boolean buscaElementoBooleano(T elemento, Nodo<T> actual){
        if (actual == null)        // vemos si termina la busqueda o la EE esta vacia 
            return false;
        else {
            if (actual.getDato().equals(elemento))
                return true;
            else 
                return buscaElementoBooleano(elemento, actual.getSig());
        }
    }
    
    public T eliminaElemento(T elemento){
        T dato = null;
        
        if (!this.estaVacia()){
            Nodo<T> actual = primero;
            Nodo<T> ant = null;
            
            while (actual.getSig() != null && !actual.getDato().equals(elemento)) {
                ant = actual;
                actual = actual.getSig();
            }
                
            dato = actual.getDato();
            
            if (ant == null)
                quitaPrimero();
            else if (actual.getDato().equals(elemento)){
                ant.setSig(actual.getSig());
                actual.setSig(null);
            }
        }
        
        return dato;
    }
    
    public boolean eliminaSiguienteDe(T info) {
        boolean resp = false;
        
        if (!this.estaVacia()) {
            Nodo<T> actual = primero;
            Nodo<T> temp;

            while (actual.getSig() != null && !actual.getDato().equals(info)){
                actual = actual.getSig();
            }
            
            if (actual.getDato().equals(info)){
                temp = actual.getSig();
                actual.setSig(temp.getSig());
                temp.setSig(null);
                resp = true;
            }
        }
        
       return resp;
    }
    
    public boolean eliminaAnteriorA(T info) {
        boolean resp = false;
        
        if (!this.estaVacia()) {
            Nodo<T> ant = null;
            Nodo<T> actual = primero;
            Nodo<T> temp;
            
            while (actual.getSig() != null && !actual.getSig().getDato().equals(info)){
                ant = actual;
                actual = actual.getSig();
            }

            temp = actual.getSig();
            
            if (ant == null || temp == null)  
                resp = false;
            
            else if (temp.equals(info) || actual.getDato() != null){
                ant.setSig(actual.getSig());
                actual.setSig(null);
                resp = true;
            }
            
        }
        
        return resp;
    }
    
    // En la clase EE escribe el método: public boolean insertaAntesQue(T refer, T nuevo) que inserta un nodo
    // (con nuevo como información) antes que el nodo dado como referencia (refer). 
    // Regresa true si lo pudo insertar y false en caso contrario.
    public boolean insertaAntesQue(T refer, T nuevo) {
        boolean resp = false;
        
        if (!this.estaVacia()){
            
            if (primero.getDato().equals(refer)){
                Nodo<T> nuevoNodo = new Nodo(nuevo);
                nuevoNodo.setSig(primero);
                primero = nuevoNodo;
                resp = true;
                
            } else {
                Nodo<T> ant = null;
                Nodo<T> actual = primero;
                
                while (actual.getSig() != null && !actual.getDato().equals(refer)){
                    ant = actual;
                    actual = actual.getSig();
                }
                
                if (actual.getDato().equals(refer)){
                    Nodo<T> nuevoNodo = new Nodo(nuevo);
                    ant.setSig(nuevoNodo);
                    nuevoNodo.setSig(actual);
                    resp = true;
                }
            }
             
        }
        
        return resp;
    }
    
    // En la clase EE escribe el método: public int eliminaTodosRepetidosOrdenado() que elimine todos los elementos repetidos de una EE,
    // dejando sólo una ocurrencia de cada dato. Además, regresa como resultado el total de elementos eliminados. 
    // Supón que los elementos de la EE están ordenados y por lo tanto los repetidos ocupan posiciones consecutivas.
       
    
    public int eliminaTodosRepetidosOrdenado() {
        int total = 0;
        
        if (!this.estaVacia()) {
            Nodo<T> actual = primero;
 
            while (actual.getSig() != null){
                if (actual.getDato().equals(actual.getSig().getDato())) {
                    Nodo<T> sigSig = actual.getSig().getSig();
                    actual.setSig(sigSig);
                    total++;
                }
                else {
                    actual = actual.getSig();   
                }
            }
        }
        
        return total;
    }
    
    public int eliminaTodosRepetidoDesordenado() {
        int total = 0;
        Nodo<T> ant;
        Nodo<T> actual = primero;
        Nodo<T> aux;
        
        if (!this.estaVacia()) {
            while (actual.getSig() != null) {
                ant = actual;
                
                while (ant.getSig() != null)
                    if (actual.getDato().equals(ant.getSig().getDato())) {  // romper relación :)
                        ant.setSig(ant.getSig().getSig());
                        total++;
                    } else
                        ant = ant.getSig();
                
                actual = actual.getSig();
            }
        }
        
        return total;
    }
    
    // 45)
    public void mezclaEE(EE<T> otro) {
        if (!this.estaVacia() && !otro.estaVacia()) {
            Nodo<T> actualThis = primero;
            Nodo<T> actualOtro = otro.primero;
            Nodo<T> temp1 = null;
            Nodo<T> temp2 = null;
            
            while (actualThis != null && actualOtro != null) {
                temp1 = actualThis.getSig();
                temp2 = actualOtro.getSig();
                actualThis.setSig(actualOtro);
                actualOtro.setSig(temp1);
                actualThis = temp1;
                actualOtro = temp2;
            }
            
            otro.primero = temp2;
        }
    }
    
    public void merge(EE<T> otro) {
        Nodo<T> thisActual = primero, otroActual = otro.primero;
        Nodo<T> actualSig, otroSig;
  
        // While there are available positions in p;
        while (thisActual != null && otroActual != null) {
  
            // Save next pointers
            actualSig = thisActual.getSig();
            otroSig = otroActual.getSig();
  
            // make otroActual as next of thisActual
            otroActual.setSig(actualSig); // change next pointer of otroActual
            thisActual.setSig(otroActual); // change next pointer of thisActual
  
            // update current pointers for next iteration
            thisActual = actualSig;
            otroActual = otroSig;
       }
        otro.primero = otroActual;
    }
    
    
    public int cuentaElementos(){
        int res = 1;
        
        if (!this.estaVacia()){
            Nodo<T> actual = primero;
            while (actual.getSig() != null) {
                res++;
                actual = actual.getSig();
            }
        }
        
        return res;
    }
}

