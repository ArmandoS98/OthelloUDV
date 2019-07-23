package com.tecnologiatransaccional.othello10.Jugador;

import com.tecnologiatransaccional.othello10.Fichas.Fichas;

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
