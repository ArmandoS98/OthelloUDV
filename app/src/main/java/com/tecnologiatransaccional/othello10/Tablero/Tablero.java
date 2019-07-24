package com.tecnologiatransaccional.othello10.Tablero;

import android.util.Log;

import com.tecnologiatransaccional.othello10.Fichas.Fichas;
import com.tecnologiatransaccional.othello10.Jugador.Jugador;

public class Tablero {
    private static final String TAG = "Tablero";
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

    public boolean verificarMovimientos(int filaAcrual, int columnaActual) {
        boolean esPosible = false;

        if (fichas[filaAcrual][columnaActual] != Fichas.NINGUNA)
            return esPosible;

        //TODO: validar en las 8 posiciones posibles
        for (int veryFila = -1; veryFila < 2; veryFila++) {
            for (int veryColumna = -1; veryColumna < 2; veryColumna++) {
                if (veryFila == 0 && veryColumna == 0)
                    continue;

                //verificamos si hay posiciones disponibles cerca de donde nos encontramos
                int nuevaFila = filaAcrual + veryFila;
                int nuevaColumna = columnaActual + veryColumna;

                Log.d(TAG, "1--> : [" + nuevaFila + ", " + nuevaColumna + "]");
                //Buscamos la nueva posicion dentro de nuestro tablero
                if (nuevaFila >= 0 && nuevaFila <= 7 && nuevaColumna >= 0 && nuevaColumna <= 7) {
                    //TODO: validamos que la nueva posicion sea del jugador opuesto al que este jugando actualmente
                    Fichas mFichasNuevaPosicion = this.jugadorActual.getFichas() == Fichas.BLANCA ? Fichas.NEGRA : Fichas.BLANCA;
                    if (fichas[nuevaFila][nuevaColumna] == mFichasNuevaPosicion) {
                        for (int rango = 1; rango < 8; rango++) {
                            int nFila = filaAcrual + rango * veryFila;
                            int nColumna = columnaActual + rango * veryColumna;

                            Log.d(TAG, "2-----> : [" + nFila + ", " + nColumna + "]");

                            //omitimos las posiciones fuera del tablero
                            if (nFila < 0 || nFila > 7 || nColumna < 0 || nColumna > 7)
                                continue;

                            //finalizaoms si encontramos alngun espacion vacio
                            if (fichas[nFila][nColumna] == Fichas.NINGUNA)
                                break;

                            if (fichas[nFila][nColumna] == this.jugadorActual.getFichas()) {
                                esPosible = true;
                                break;
                            }
                        }
                    }
                }
            }
        }

        return esPosible;
    }

    public boolean volearFicha(int filaAcrual, int columnaActual) {
        boolean esPosible = false;

        //TODO: validar en las 8 posiciones posibles
        for (int veryFila = -1; veryFila < 2; veryFila++) {
            for (int veryColumna = -1; veryColumna < 2; veryColumna++) {
                if (veryFila == 0 && veryColumna == 0)
                    continue;

                //verificamos si hay posiciones disponibles cerca de donde nos encontramos
                int nuevaFila = filaAcrual + veryFila;
                int nuevaColumna = columnaActual + veryColumna;

                Log.d(TAG, "1--> : [" + nuevaFila + ", " + nuevaColumna + "]");
                //Buscamos la nueva posicion dentro de nuestro tablero
                if (nuevaFila >= 0 && nuevaFila <= 7 && nuevaColumna >= 0 && nuevaColumna <= 7) {
                    //TODO: validamos que la nueva posicion sea del jugador opuesto al que este jugando actualmente
                    Fichas mFichasNuevaPosicion = this.jugadorActual.getFichas() == Fichas.BLANCA ? Fichas.NEGRA : Fichas.BLANCA;
                    if (fichas[nuevaFila][nuevaColumna] == mFichasNuevaPosicion) {
                        for (int rango = 0; rango < 8; rango++) {
                            int nFila = filaAcrual + rango * veryFila;
                            int nColumna = columnaActual + rango * veryColumna;

                            Log.d(TAG, "2-----> : [" + nFila + ", " + nColumna + "]");

                            //omitimos las posiciones fuera del tablero
                            if (nFila < 0 || nFila > 7 || nColumna < 0 || nColumna > 7)
                                continue;

                            //TODO: Verificamos si podemos voltear fichas en esta posicion
                            if (fichas[nFila][nColumna] == this.jugadorActual.getFichas()) {
                                boolean esPosibleVoltear = true;
                                for (int distan = 1; distan < rango; distan++) {
                                    int pruebaFila = filaAcrual + distan * veryFila;
                                    int pruebaColumna = columnaActual + distan * veryColumna;

                                    if (fichas[pruebaFila][pruebaColumna] != mFichasNuevaPosicion)
                                        esPosibleVoltear = false;
                                }

                                //TODO: Volteamos las encontradas
                                if (esPosibleVoltear) {
                                    for (int voltearCan = 1; voltearCan < rango; voltearCan++) {
                                        int filaFinal = filaAcrual + voltearCan * veryFila;
                                        int columnaFinal = columnaActual + voltearCan * veryColumna;

                                        if (fichas[filaFinal][columnaFinal] == mFichasNuevaPosicion)
                                            fichas[filaFinal][columnaFinal] = this.jugadorActual.getFichas();
                                    }
                                }
                                esPosible = true;
                                break;
                            }
                        }
                    }
                }
            }
        }

        return esPosible;
    }

    public int verificarDisponibles() {
        int vacios = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (fichas[i][j] == Fichas.NINGUNA)
                    vacios++;
            }
        }
        return vacios;
    }

    public Fichas[][] getFichas() {
        return fichas;
    }

    public Jugador getJugadorActual() {
        return jugadorActual;
    }

    public int contador(Fichas ficha) {
        int cantidad = 0;
        for (int fila = 0; fila < 8; fila++) {
            for (int columna = 0; columna < 8; columna++) {
                if (fichas[fila][columna] == ficha)
                    cantidad++;
            }
        }
        return cantidad;
    }
}
