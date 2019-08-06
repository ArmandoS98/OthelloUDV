package com.tecnologiatransaccional.othello10.Jugador;

import com.tecnologiatransaccional.othello10.Fichas.Fichas;

/******************************************************************************
 Proyecto Othello
 Desarrollado por: Alvaro Sosa y Armando Santos
 06.08.2019-14:18
 Version 1.0
 *******************************************************************************/

public class Jugador {
    private Fichas fichas;

    public Jugador(Fichas fichas) {
        this.fichas = fichas;
    }

    public Fichas getFichas() {
        return fichas;
    }

    public void setFichas(Fichas fichas) {
        this.fichas = fichas;
    }
}
