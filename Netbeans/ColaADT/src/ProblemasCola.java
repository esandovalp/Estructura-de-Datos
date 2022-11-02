
import java.util.Stack;


public class ProblemasCola {
    // Se requiere de un método estático que invierta el orden de los elementos de una estructura tipo cola genérica.
    // Para ello puedes usar cualquier estructura de datos como auxiliar.
    
    // a) Solución iterativa.
    public static <T> void invierteElementosIterativo(ColaADT<T> cola){
        if (cola == null)
            throw new RuntimeException();
        
        Stack<T> aux = new Stack(); 
        
        while (!cola.estaVacia())
            aux.push(cola.saca());
        
        while(!aux.isEmpty())
            cola.agrega(aux.pop());
        
    }
    
    // b) Solución recursiva.
    public static <T> void invierteElementosRecursivo(ColaADT<T> cola){
        if (cola == null)
            throw new RuntimeException();
        
        invierteElementosRecursivo(cola, new Stack());
    }
    
    private static <T> void invierteElementosRecursivo(ColaADT<T> cola, Stack<T> aux){
        
        if (!cola.estaVacia()){
            aux.push(cola.saca());
            invierteElementosRecursivo(cola,aux);
            
        } else 
           invierteElementos(aux,cola); 
        
    }
    
    private static <T> void invierteElementos(Stack<T> aux, ColaADT<T> cola){
        
        if (!aux.isEmpty()){
            cola.agrega(aux.pop());
            invierteElementos(aux,cola);
        }
    }
    
    // 34) Escribe un método estático que quite todos los elementos repetidos de una estructura tipo cola (si la cola tiene elementos repetidos,
    // estos se encuentran en posiciones consecutivas).
    public static <T> void eliminaRepetidos(ColaADT<T> cola){
        if (cola == null)
            throw new RuntimeException();
        
        Stack<T> aux = new Stack();
        Stack<T> aux2 = new Stack();
     
        while(!cola.estaVacia()) {
              aux.push(cola.saca());
              try{
                  if(aux.peek().equals(cola.consultaPrimero()))
                      aux.pop();
              }
              catch (Exception e){}
          }
          
          while(!aux.empty())
              aux2.push(aux.pop());
          
          while(!aux2.empty())
              cola.agrega(aux2.pop());
    
    }
    
    // 35) Escribe un método estático que quite todas las ocurrencias de un cierto objeto de una estructura tipo cola. 
    // Es decir, dado un objeto, si se encuentra en la cola, se deben eliminar todas sus ocurrencias.
    public static <T> void eliminaOcurrencias(ColaADT<T> cola, T objeto){      
       ColaADT<T> aux = new ColaA(); 
        
       while(!cola.estaVacia()){
           if (cola.consultaPrimero().equals(objeto))
               cola.saca();
           else
               aux.agrega(cola.saca());
       }
       
       while(!aux.estaVacia())
           cola.agrega(aux.saca());
    }
    
    
    
    public static void main(String[] args) {
        ColaADT<Integer> cola1 = new ColaA();
        ColaADT<Integer> cola2 = new ColaA();
        ColaADT<Integer> cola3 = new ColaA();
        ColaADT<Integer> colaVacia = null;
        
        //System.out.println("Total elementos cola vacia: " + colaVacia.cuentaElementos());
        
        cola1.agrega(1);
        cola1.agrega(2);
        cola1.agrega(3);
        cola1.agrega(4);
        
        System.out.println("Total elementos en cola1: " + cola1.cuentaElementos());
        System.out.println("Ultimo elemento de la cola1: " + cola1.consultaUltimo());
        
        System.out.println("Cola 1: " + cola1.toString());
        
        invierteElementosIterativo(cola1);
        
        System.out.println("Invierte Iterativo: " + cola1.toString());
        
        cola2.agrega(0);
        cola2.agrega(1);
        cola2.agrega(2);
        cola2.agrega(3);
        
        System.out.println("Total elementos en cola2: " + cola2.cuentaElementos());

        invierteElementosRecursivo(cola2);
        
        System.out.println("Invierte recursivo: " + cola2.toString());
        
        try{
            invierteElementosRecursivo(colaVacia);
        } catch(Exception e){
            
        }
        
        //cola3.agrega(1);
        cola3.agrega(1);
        cola3.agrega(2);
        cola3.agrega(2);
        cola3.agrega(3);
        
        System.out.println("Cola 3 normal: " + cola3.toString());
        
        //invierteElementosRecursivo(cola3);
                
        eliminaRepetidos(cola3);
        
        System.out.println("Cola 3 sin elementos repetidos:\t" + cola3.toString());
        
        ColaADT<Integer> cola4 = new ColaA();
        cola4.agrega(1);
        cola4.agrega(6);
        cola4.agrega(3);
        cola4.agrega(4);
        cola4.agrega(7);

        
        System.out.println("Cola 4 normal:\t" + cola4.toString());
        
        eliminaOcurrencias(cola4,6);
        
        System.out.println("Cola 4 sin el 6:\t" + cola4.toString());
        
        System.out.println("Elimina 4 elementos de cola4: " + cola4.multiQuita(4));
        
        System.out.println("Cola 4 sin los 4 elementos: " + cola4.toString());
    }
}
