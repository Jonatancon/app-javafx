/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.modelo;

import java.util.ArrayList;

/**
 *
 * @author Andres
 */
public class Persona {

    private int cedula;
    private String nombre;
    private ArrayList<Factura> facturasSinPagar;

    public Persona(int cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.facturasSinPagar = new ArrayList<Factura>();
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Factura> getFacturasSinPagar() {
        return facturasSinPagar;
    }

    public void setFacturasSinPagar(ArrayList<Factura> facturasSinPagar) {
        this.facturasSinPagar = facturasSinPagar;
    }
    
    
    

}
