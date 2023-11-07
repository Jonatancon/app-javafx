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
public class Socio extends Persona {

    private double fondosDisponibles;
    private String tipoSuscripcion;
    private ArrayList<PersonaAutorizada> personasAutorizadas;

    public Socio(double fondosDisponibles, String tipoSuscripcion, int cedula, String nombre) {
        super(cedula, nombre);
        this.fondosDisponibles = fondosDisponibles;
        this.tipoSuscripcion = tipoSuscripcion;
        this.personasAutorizadas = new ArrayList<PersonaAutorizada>();
    }

    public double getFondosDisponibles() {
        return fondosDisponibles;
    }

    public void setFondosDisponibles(double fondosDisponibles) {
        this.fondosDisponibles = fondosDisponibles;
    }

    public String getTipoSuscripcion() {
        return tipoSuscripcion;
    }

    public void setTipoSuscripcion(String tipoSuscripcion) {
        this.tipoSuscripcion = tipoSuscripcion;
    }

    public ArrayList<PersonaAutorizada> getPersonasAutorizadas() {
        return personasAutorizadas;
    }

    public void setPersonasAutorizadas(ArrayList<PersonaAutorizada> personasAutorizadas) {
        this.personasAutorizadas = personasAutorizadas;
    }
    
    
    
    
}
