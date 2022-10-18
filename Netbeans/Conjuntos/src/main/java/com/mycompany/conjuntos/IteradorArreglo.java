/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.conjuntos;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author coron
 */
public class IteradorArreglo <T> implements Iterator<T> {
    private T[] colec;
    private int total, actual;

    public IteradorArreglo(T[] colec, int total) {
        this.colec = colec;
        this.total = total;
        this.actual = 0;
    }

    @Override
    public boolean hasNext() {
        return actual < total;
    }

    @Override
    public T next() {
        
        if (hasNext()){
            T dato = colec[actual];
            actual++;
            return dato;
        }
        else
            throw new NoSuchElementException();
        
    }
    
    
    
}
