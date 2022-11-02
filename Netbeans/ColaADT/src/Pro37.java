
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Pro37 {
    // se puede usar un arraylist y usar el sort 
    public static void ordenaCola(ColaADT<Persona> cola) {
        
        ArrayList<Persona> arr = new ArrayList();
        
        while(!cola.estaVacia())
            arr.add(cola.saca());
        
        Persona mayor;
        
        for (int i = 0 ; i < arr.size() ; i++)
            for (int j = i + 1; j < arr.size() ; j++) 
                if (arr.get(i).calculaEdad() < arr.get(j).calculaEdad()){
                    mayor = arr.get(j);
                    arr.set(j, arr.get(i));
                    arr.set(i,mayor);
                }
        
        for (int i = 0; i < arr.size(); i++)
            cola.agrega(arr.get(i));
     }

    public static void ordenaCola2(ColaADT<Persona> cola) {
        
        ArrayList<Persona> arr = new ArrayList();
        
        while(!cola.estaVacia())
            arr.add(cola.saca());
        
        Collections.sort(arr);
        
        for(int i=0;i<arr.size();i++)
            cola.agrega(arr.get(i));
        
     }    
    public static void main(String[] args) {
        ColaADT<Persona> cola = new ColaA();
        
        Persona p1 = new Persona("01 03 2002");
        Persona p2 = new Persona("01 03 1997");
        Persona p3 = new Persona("01 03 1960");
        Persona p4 = new Persona("01 03 2005");
        Persona p5 = new Persona("01 03 1975");
        
        Persona[] personas = new Persona[5];
        
        personas[0] = p1;
        personas[1] = p2;
        personas[2] = p3;
        personas[3] = p4;
        personas[4] = p5;
        
        Arrays.sort(personas);
        
        for (Persona persona : personas) 
            System.out.print(persona + "  ");
        
        System.out.print("\n");
        
        cola.agrega(p1);
        cola.agrega(p2);
        cola.agrega(p3);
        cola.agrega(p4);
        cola.agrega(p5);
        
        System.out.println("\n"  + cola.toString());
        
        ordenaCola(cola);
        
        System.out.println("\n"  + cola.toString());

    }
}
