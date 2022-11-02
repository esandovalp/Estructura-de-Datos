
package pilas;

public class Pro4EE2P {
//    4. Programar un método recursivo que verifique si dos pilas genéricas son iguales.
    
    public static <T> boolean revisaPilasGenericas(PilaADT<T> pila1, PilaADT<T> pila2) {
       
        if (pila1.isEmpty() && pila2.isEmpty()  ) 
            return true;
        else if (!pila1.isEmpty() && !pila2.isEmpty() && pila1.pop().equals(pila2.pop()) == true)
            return revisaPilasGenericas(pila1,pila2);
        else
            return false;
    }
    
    public static void main(String[] args) {
        PilaADT<Integer> pila1 = new PilaA();
        PilaADT<Integer> pila2 = new PilaA();
        
        pila1.push(1);
        pila1.push(2);
        pila1.push(3);
        pila1.push(4);
        
        pila2.push(1);
        pila2.push(2);
        pila2.push(3);
        pila2.push(4);
        
        System.out.println("Las pilas son iguales: " + revisaPilasGenericas(pila1,pila2));
    }
}
