
package infijapostfija;

import java.util.Stack;


public class InfijaPostfija {
  
    private static boolean esSimbolo(char n){ 
        boolean resp=false;
        
        if(n=='*'||n=='/'|| n=='+'||n=='-'||n=='('||n==')') 
            resp=true;
        
        return resp;
    }
    
    
    private static boolean operador(char n){ //pregunta si el caracter es un operador
        boolean resp=false;
        if(n=='*'||n=='/'|| n=='+'||n=='-')
            resp=true;
        return resp;
    }
    
    private static int estableceJerarquia(char n){
        int resp=0;
        
        if(n=='+'||n=='-')
            resp=1;
        if(n=='*'||n=='/')
            resp=2;
        
        return resp;
    }
    
    private static String postfijo(String cadena){ 
        Stack<Character>pila=new Stack();
        StringBuilder resp=new StringBuilder();
        char simbolo;
        
        for(int i=0;i<cadena.length();i++){
            
            simbolo=cadena.charAt(i); //guarda cada elemento de la cadena dada
            if(!esSimbolo(simbolo)){ //pregunta si no es un símbolo
                resp.append(simbolo);
            }else{
                if(simbolo!='('){
                    resp.append(" "); //Si el simbolo no es un parentesis izquierdo se agrega un espacio para separar numeros y operadores
                }
                if(simbolo=='('){
                    pila.push(simbolo);
                }else{
                   if(operador(simbolo)){
                       try{
                           while(estableceJerarquia(simbolo)<=estableceJerarquia(pila.peek())){ //se toma en cuenta la jerarquia de los operadores para sacar de la pila 
                               resp.append(pila.pop());
                           }
                       }catch(Exception e){ //en caso de que se marque error
                           
                       }
                       pila.push(simbolo);
                   }else{
                       while(pila.peek()!='('){
                           resp.append(pila.pop());
                       }
                       pila.pop();
                   }
                }   
            }     
        }
        while(!pila.isEmpty()){
            resp.append(" ");
            resp.append(pila.pop());
        }
        return resp.toString() + " "; //se regresa la expresion en postfija en forma de cadena
    }
    
    public static void main(String[] args) {
        String cad = "(3.0 + 0.5) * (2.0 + 4)^2";
        
        System.out.println(postfijo(cad));
        
    }
    
}
