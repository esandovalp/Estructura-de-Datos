
package com.mycompany.conjuntos;

import java.util.Iterator;

public class ConjuntoA <T> implements ConjuntoADT<T> {
    private T[] conjunto;
    private int cardinalidad;
    private final int MAX = 20;

    public ConjuntoA() {
        conjunto = (T[]) new Object[MAX];
        cardinalidad = 0;
    }
    
    public ConjuntoA(int max) {
        conjunto = (T[]) new Object[max];
        cardinalidad = 0;
    }
    
    public Iterator<T> iterator(){
        return new IteradorArreglo(conjunto, cardinalidad);
    }
    
    public boolean contiene(T dato) {
        Iterator<T> it = iterator();
        boolean encontro = false;
        
        while( it.hasNext() && !encontro)
            encontro = it.next().equals(dato);
        
        return encontro;
    }

    public boolean agrega(T dato) {
        boolean resp;
        
        resp = contiene(dato);
        
        if (!resp) {
            if (cardinalidad == conjunto.length) 
                expande();
            conjunto[cardinalidad] = dato;
            cardinalidad++;
        }
        return !resp;
    }
    
    public void expande() {
        T conjuntoMasGrande[] = (T[]) new Object[MAX * 2];
        
        for (int j = 0; j < cardinalidad; j++ ) {          
            conjuntoMasGrande[j] = conjunto[j];
        }
        
        conjunto = conjuntoMasGrande;
    }

    @Override
    public T elimina(T dato) {  // quita de un arreglo desordenado 
        T eliminado;
        int pos;
        
        pos = buscaElemento(dato);
        if (pos >= 0){
            eliminado = conjunto[pos];
            conjunto[pos] = conjunto[cardinalidad - 1];
            conjunto[cardinalidad - 1] = null;
            cardinalidad--;
        } else
            eliminado = null;
        
        return eliminado;
    }

    private int buscaElemento(T aBuscar){
        int i = 0;
        
        while (i < cardinalidad && !conjunto[i].equals(aBuscar)){
            i++;
        }
        if(i == cardinalidad)
            i = -1;
        return i;
    }
        
    
    @Override
    public boolean estaVacio() {
        return cardinalidad == 0;
    }

    @Override
    public int getCardinalidad() {
        return this.cardinalidad;
    }

    @Override
    public ConjuntoADT<T> union(ConjuntoADT<T> otro) {
        if (otro == null)
            throw new RuntimeException("No es un conjunto");
        
        ConjuntoADT<T> conjUnion = new ConjuntoA();
        
        if (cardinalidad > otro.getCardinalidad()){
            copia(conjUnion);
            copia(otro, conjUnion);
        } else{
            copiaDelOtroAUnion(otro, conjUnion);
            copia(this,conjUnion);
        }
        return conjUnion;
    }
    
    private void copiaDelOtroAUnion(ConjuntoADT<T> otro,ConjuntoADT<T> conjUnion){
        ConjuntoA temp = (ConjuntoA)conjUnion;

        for (T elemen: otro){
            temp.conjunto[temp.cardinalidad] = elemen;      // porque temp.cardinalidad es 0
            temp.cardinalidad++;
        }
    }
    private void copia(ConjuntoADT<T> des){
        ConjuntoA temp = (ConjuntoA)des;
        
        for (int i = 0; i < cardinalidad; i++)
            temp.conjunto[i] = conjunto[i];         // el temp.conjunto[i] porque conjunto[i] es el arreglo
    }
    
    private void copia(ConjuntoADT<T> orig, ConjuntoADT<T> des){
        for (T elemento: orig)
            des.agrega(elemento);
        
    }
    
    public String toString(){
        return toString(0, new StringBuilder());
    }
    
    private String toString(int pos, StringBuilder sB ){
        if (pos == cardinalidad){
            return sB.toString();
        } else {
            sB.append(conjunto[pos]).append(" ");
            return toString(pos + 1, sB);
        }
    }

    @Override
    public ConjuntoADT<T> interseccion(ConjuntoADT<T> otro) {
        ConjuntoADT<T> auxG, auxC;
        
        if(otro == null)
            throw new RuntimeException("Esta vacio");
        if (cardinalidad < otro.getCardinalidad()){
            auxG = otro;
            auxC = this;
        }
        else {
            auxG = this;
            auxC = otro;
        }
        
        return interseccion(auxG, auxC);
    }
    
    public ConjuntoADT<T> interseccion(ConjuntoADT<T> grande, ConjuntoADT<T> chico) {
        ConjuntoA intersectados = new ConjuntoA(this.cardinalidad);
        
        for (T element : chico) {
            if (grande.contiene(element)){
                intersectados.conjunto[intersectados.cardinalidad] = element;
                intersectados.cardinalidad++;
            }
        }
        
        return intersectados;
        
    }


    @Override
    public ConjuntoADT<T> diferencia(ConjuntoADT<T> otro) {
        ConjuntoA subt = new ConjuntoA();
        
        for (T element : this) {
            if (!otro.contiene(element)){
                subt.conjunto[subt.cardinalidad] = element;
                subt.cardinalidad++;
            }
        }
        
        return subt;
    }
    
    
    public static void main(String[] args) {
        ConjuntoADT<Integer> conj1 = new ConjuntoA();
        ConjuntoADT<Integer> conj2 = new ConjuntoA();
        ConjuntoADT<Integer> conj3 = new ConjuntoA();
        
        conj1.agrega(2);
        conj1.agrega(3);
        conj1.agrega(1);
        conj1.agrega(5);
        conj1.agrega(8);
        
        conj2.agrega(9);
        conj2.agrega(3);
        conj2.agrega(2);

        
        System.out.println(conj1.toString());
        System.out.println(conj2.toString());
        
        ConjuntoADT<Integer> inter = conj1.interseccion(conj2);
        
        System.out.println(inter.toString()); // deberia de imprimir 2 y 3
        System.out.println(conj1.diferencia(conj2).toString());
        
        
    }
}
