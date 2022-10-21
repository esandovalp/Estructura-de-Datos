/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.conjuntos;

/**
 *
 * @author INTEL
 */
public class Alumno {
    private double prom;
    private int clave;

    public Alumno(int clave, double prom) {
        this.prom = prom;
        this.clave = clave;
    }

    public double getProm() {
        return prom;
    }

    @Override
    public String toString() {
        return "Alumno(" + "prom=" + prom + ", clave=" + clave + ")";
    }
    
}
