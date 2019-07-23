package com.tecnologiatransaccional.othello10.Tablero;

import com.tecnologiatransaccional.othello10.Fichas.Fichas;
import com.tecnologiatransaccional.othello10.Jugador.Jugador;

public class Tablero {
    private Fichas[][] fichas = new Fichas[8][8];
    private Jugador mJugador1 = new Jugador(Fichas.NEGRA);
    private Jugador mJugador2 = new Jugador(Fichas.BLANCA);
    private Jugador jugadorActual;

    public Tablero() {
        iniciar();
    }

    private void iniciar() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                fichas[i][j] = Fichas.NINGUNA;
            }
        }

        jugadorActual = mJugador1;

        posicionFicha(3, 4);
        siguienteTurno();
        posicionFicha(3, 3);
        siguienteTurno();
        posicionFicha(4, 3);
        siguienteTurno();
        posicionFicha(4, 4);
        siguienteTurno();
    }

    public void posicionFicha(int fila, int columna) {
        if (fichas[fila][columna] == Fichas.NINGUNA) {
            if (jugadorActual.getFichas() == Fichas.BLANCA)
                fichas[fila][columna] = Fichas.BLANCA;
            else if (jugadorActual.getFichas() == Fichas.NEGRA)
                fichas[fila][columna] = Fichas.NEGRA;
        }
    }

    public void siguienteTurno() {
        this.jugadorActual = (this.jugadorActual == mJugador1) ? mJugador2 : mJugador1;
    }
}
