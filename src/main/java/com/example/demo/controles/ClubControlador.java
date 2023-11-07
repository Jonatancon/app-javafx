package com.example.demo.controles;

import com.example.demo.modelo.Club;

public class ClubControlador {
    private Club club;

    public Club getClub() {
        if (club==null){
            return new Club();
        }
        return club;
    }
}
