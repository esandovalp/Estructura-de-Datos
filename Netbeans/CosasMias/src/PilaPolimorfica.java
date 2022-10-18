
import java.util.Stack;


public class PilaPolimorfica {
    
    public static <T> void elimina(Stack<T> pila) {
       Stack<T> temp = new Stack();
       T viv;
       boolean band = false;
       
       while(!pila.isEmpty()) {
           viv = pila.pop();
           
           if(!viv instanceof Casa || viv.getAcabados() != 3 || !((Casa)viv).getJardin()) {
               temp.push(viv);
           } else
               band = true;
           
           copiaPila(temp, pila); // aqui la regresa a su estado normal, 
           
           if(band)
               throw new RuntimeException("");
       }
       
       
    }
    
    public static 
    
    
    public static void main(String[] args) {
        
    }
}
