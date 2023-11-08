package com.example.demo.controles;

import com.example.demo.modelo.Club;

public class ClubControlador {
    private final Club club;
    private static ClubControlador instancia;

    private ClubControlador() {
        club = new Club();
    }

    public static ClubControlador getInstancia() {
        if (instancia == null) {
            instancia = new ClubControlador();
        }
        return instancia;
    }

    public Club getClub() {
        return club;
    }
}
