/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author coron
 */
public class MainLista {
    public static void main(String[] args) {
        ListaOrdenada<Integer> listaOrdenada1 = new ListaOrdenada();
        int suma, cont;
    
        listaOrdenada1.agrega(11);
        listaOrdenada1.agrega(12);
        listaOrdenada1.agrega(13);
        listaOrdenada1.agrega(10);
        
        System.out.println(listaOrdenada1.toString());
    }
}
