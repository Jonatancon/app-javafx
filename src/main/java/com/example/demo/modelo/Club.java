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
public class Club {

    private ArrayList<Socio> listaSocios;


    public Club() {
        this.listaSocios = new ArrayList<Socio>();

    }

    public ArrayList<Socio> getListaSocios() {
        return listaSocios;
    }

    public void setListaSocios(ArrayList<Socio> listaSocios) {
        this.listaSocios = listaSocios;
    }

}
