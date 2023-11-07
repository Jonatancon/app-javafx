/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.modelo;

/**
 *
 * @author Andres
 */
public class PersonaAutorizada extends Persona {
    private Socio socioAutoriza;

    public PersonaAutorizada(Socio socioAutoriza, int cedula, String nombre) {
        super(cedula, nombre);
        this.socioAutoriza = socioAutoriza;
    }

    public Socio getSocioAutoriza() {
        return socioAutoriza;
    }

    public void setSocioAutoriza(Socio socioAutoriza) {
        this.socioAutoriza = socioAutoriza;
    }
    
    
    
}
