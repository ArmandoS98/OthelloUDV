package com.tecnologiatransaccional.othello10;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.tecnologiatransaccional.othello10.Fichas.Fichas;
import com.tecnologiatransaccional.othello10.TableroLogica.TableroLogica;

import java.util.Objects;

/******************************************************************************
 Proyecto Othello
 Desarrollado por: Alvaro Sosa y Armando Santos
 06.08.2019-14:18
 Version 1.0
 *******************************************************************************/

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    //Incializadion del trablero
    private TableroLogica tableroLogica = new TableroLogica();

    private Vibrator mVibrator;

    private ImageButton jugadorActual;
    private TextView mTextViewContadorFichaBlanca;
    private TextView mTextViewContadorFichaNegra;
    private TextView mTextViewFichaBlanca;
    private TextView mTextViewFichaNegra;
    private Dialog shwDialog;

    private ImageButton[][] imageButtons = new ImageButton[8][8];
    private int[][] idviews = {
            {R.id.board11, R.id.board12, R.id.board13, R.id.board14, R.id.board15, R.id.board16, R.id.board17, R.id.board18},
            {R.id.board21, R.id.board22, R.id.board23, R.id.board24, R.id.board25, R.id.board26, R.id.board27, R.id.board28},
            {R.id.board31, R.id.board32, R.id.board33, R.id.board34, R.id.board35, R.id.board36, R.id.board37, R.id.board38},
            {R.id.board41, R.id.board42, R.id.board43, R.id.board44, R.id.board45, R.id.board46, R.id.board47, R.id.board48},
            {R.id.board51, R.id.board52, R.id.board53, R.id.board54, R.id.board55, R.id.board56, R.id.board57, R.id.board58},
            {R.id.board61, R.id.board62, R.id.board63, R.id.board64, R.id.board65, R.id.board66, R.id.board67, R.id.board68},
            {R.id.board71, R.id.board72, R.id.board73, R.id.board74, R.id.board75, R.id.board76, R.id.board77, R.id.board78},
            {R.id.board81, R.id.board82, R.id.board83, R.id.board84, R.id.board85, R.id.board86, R.id.board87, R.id.board88}};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarComponentes();
    }

    private void inicializarComponentes() {
        mVibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        shwDialog = new Dialog(this);

        mTextViewContadorFichaBlanca = findViewById(R.id.whiteNum);
        mTextViewContadorFichaNegra = findViewById(R.id.blackNum);
        mTextViewFichaNegra = findViewById(R.id.tvtPrimerJugador);
        mTextViewFichaBlanca = findViewById(R.id.tvtSegundoJugador);
        jugadorActual = findViewById(R.id.current);
        cambiar(jugadorActual);
        /**
         * TODO: Realizo la inicializacion de los componentes, y creo junto con ello el evento Onclick
         * el cual es el responsable de cada vez que precionamos en la parte visual.
         */
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                imageButtons[i][j] = findViewById(idviews[i][j]);
                imageButtons[i][j].setOnClickListener(this);
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.board11:
                verificarPosicionB(0, 0);
                break;

            case R.id.board12:
                verificarPosicionB(0, 1);
                break;

            case R.id.board13:
                verificarPosicionB(0, 2);
                break;

            case R.id.board14:
                verificarPosicionB(0, 3);
                break;

            case R.id.board15:
                verificarPosicionB(0, 4);
                break;

            case R.id.board16:
                verificarPosicionB(0, 5);
                break;

            case R.id.board17:
                verificarPosicionB(0, 6);
                break;

            case R.id.board18:
                verificarPosicionB(0, 7);
                break;

            case R.id.board21:
                verificarPosicionB(1, 0);
                break;

            case R.id.board22:
                verificarPosicionB(1, 1);
                break;

            case R.id.board23:
                verificarPosicionB(1, 2);
                break;

            case R.id.board24:
                verificarPosicionB(1, 3);
                break;

            case R.id.board25:
                verificarPosicionB(1, 4);
                break;

            case R.id.board26:
                verificarPosicionB(1, 5);
                break;

            case R.id.board27:
                verificarPosicionB(1, 6);
                break;

            case R.id.board28:
                verificarPosicionB(1, 7);
                break;

            case R.id.board31:
                verificarPosicionB(2, 0);
                break;

            case R.id.board32:
                verificarPosicionB(2, 1);
                break;

            case R.id.board33:
                verificarPosicionB(2, 2);
                break;

            case R.id.board34:
                verificarPosicionB(2, 3);
                break;

            case R.id.board35:
                verificarPosicionB(2, 4);
                break;

            case R.id.board36:
                verificarPosicionB(2, 5);
                break;

            case R.id.board37:
                verificarPosicionB(2, 6);
                break;

            case R.id.board38:
                verificarPosicionB(2, 7);
                break;

            case R.id.board41:
                verificarPosicionB(3, 0);
                break;

            case R.id.board42:
                verificarPosicionB(3, 1);
                break;

            case R.id.board43:
                verificarPosicionB(3, 2);
                break;

            case R.id.board44:
                verificarPosicionB(3, 3);
                break;

            case R.id.board45:
                verificarPosicionB(3, 4);
                break;

            case R.id.board46:
                verificarPosicionB(3, 5);
                break;

            case R.id.board47:
                verificarPosicionB(3, 6);
                break;

            case R.id.board48:
                verificarPosicionB(3, 7);
                break;

            case R.id.board51:
                verificarPosicionB(4, 0);
                break;

            case R.id.board52:
                verificarPosicionB(4, 1);
                break;

            case R.id.board53:
                verificarPosicionB(4, 2);
                break;

            case R.id.board54:
                verificarPosicionB(4, 3);
                break;

            case R.id.board55:
                verificarPosicionB(4, 4);
                break;

            case R.id.board56:
                verificarPosicionB(4, 5);
                break;

            case R.id.board57:
                verificarPosicionB(4, 6);
                break;

            case R.id.board58:
                verificarPosicionB(4, 7);
                break;

            case R.id.board61:
                verificarPosicionB(5, 0);
                break;

            case R.id.board62:
                verificarPosicionB(5, 1);
                break;

            case R.id.board63:
                verificarPosicionB(5, 2);
                break;

            case R.id.board64:
                verificarPosicionB(5, 3);
                break;

            case R.id.board65:
                verificarPosicionB(5, 4);
                break;

            case R.id.board66:
                verificarPosicionB(5, 5);
                break;

            case R.id.board67:
                verificarPosicionB(5, 6);
                break;

            case R.id.board68:
                verificarPosicionB(5, 7);
                break;

            case R.id.board71:
                verificarPosicionB(6, 0);
                break;

            case R.id.board72:
                verificarPosicionB(6, 1);
                break;

            case R.id.board73:
                verificarPosicionB(6, 2);
                break;

            case R.id.board74:
                verificarPosicionB(6, 3);
                break;

            case R.id.board75:
                verificarPosicionB(6, 4);
                break;

            case R.id.board76:
                verificarPosicionB(6, 5);
                break;

            case R.id.board77:
                verificarPosicionB(6, 6);
                break;

            case R.id.board78:
                verificarPosicionB(6, 7);
                break;

            case R.id.board81:
                verificarPosicionB(7, 0);
                break;

            case R.id.board82:
                verificarPosicionB(7, 1);
                break;

            case R.id.board83:
                verificarPosicionB(7, 2);
                break;

            case R.id.board84:
                verificarPosicionB(7, 3);
                break;

            case R.id.board85:
                verificarPosicionB(7, 4);
                break;

            case R.id.board86:
                verificarPosicionB(7, 5);
                break;

            case R.id.board87:
                verificarPosicionB(7, 6);
                break;

            case R.id.board88:
                verificarPosicionB(7, 7);
                break;
        }
    }

    /**
     * Este metodo es el encargado de recibir la posicion de la cual se seleccion en la parte grafica,
     * recibe como parametro la fila y la columna de la view actual.
     *
     * @param fila
     * @param columna
     */
    private void verificarPosicionB(int fila, int columna) {
        if (tableroLogica.verificarDisponibles() != 0 && hayMovimientos()) {
            if (tableroLogica.verificarMovimientos(fila, columna)) {
                tableroLogica.volearFicha(fila, columna);
                tableroLogica.posicionFicha(fila, columna);
                dibujarTablero();
                cambiar(jugadorActual);
                mTextViewContadorFichaBlanca.setText(String.valueOf(tableroLogica.contador(Fichas.BLANCA)));
                mTextViewContadorFichaNegra.setText(String.valueOf(tableroLogica.contador(Fichas.NEGRA)));

                if (tableroLogica.verificarDisponibles() != 0) {
                    tableroLogica.siguienteTurno();
                    cambiar(jugadorActual);
                    mVibrator.vibrate(100);

                    if (!hayMovimientos())
                        mostrarGanador();
                }

                if (tableroLogica.verificarDisponibles() == 0)
                    mostrarGanador();
            }
        } else {
            Toast.makeText(MainActivity.this, "Nuevo Juego", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * En esta parte colocamos la logica para poder identificar al ganador y que nos retorne un
     * mensaje de salida el cual varia dependiendo cual usuario es el ganador.
     */
    private void mostrarGanador() {
        if (tableroLogica.contador(Fichas.NEGRA) > tableroLogica.contador(Fichas.BLANCA)) {
            mTextViewFichaNegra.setTextColor(getResources().getColor(R.color.colorGanador));
            mTextViewContadorFichaNegra.setTextColor(getResources().getColor(R.color.colorGanador));
            ganador("Ficha Negra");
        } else if (tableroLogica.contador(Fichas.NEGRA) < tableroLogica.contador(Fichas.BLANCA)) {
            mTextViewFichaBlanca.setTextColor(getResources().getColor(R.color.colorGanador));
            mTextViewContadorFichaBlanca.setTextColor(getResources().getColor(R.color.colorGanador));
            ganador("Ficha Blanca");
        } else if (tableroLogica.contador(Fichas.NEGRA) == tableroLogica.contador(Fichas.BLANCA)) {
            mTextViewFichaNegra.setTextColor(getResources().getColor(R.color.colorEmpate));
            mTextViewFichaBlanca.setTextColor(getResources().getColor(R.color.colorEmpate));
            mTextViewContadorFichaNegra.setTextColor(getResources().getColor(R.color.colorEmpate));
            mTextViewContadorFichaBlanca.setTextColor(getResources().getColor(R.color.colorEmpate));
        }
    }

    /**
     * En esta seccion del codigo tenemos la logica la cual cambia la ficha del jugador en el recuad-
     * ro que dice "Ficha Turno" en la parte gradica es solo una validacion.
     *
     * @param current
     */
    private void cambiar(ImageButton current) {
        if (tableroLogica.getJugadorActual().getFichas() == Fichas.NEGRA) {
            current.setImageResource(R.drawable.ficha_negra);
            current.setBackgroundResource(R.drawable.ficha_color2);
        } else if (tableroLogica.getJugadorActual().getFichas() == Fichas.BLANCA) {
            current.setImageResource(R.drawable.ficha_blanca);
            current.setBackgroundResource(R.drawable.ficha_color1);
        } else
            current.setImageResource(R.drawable.transparent);
    }


    /**
     * la funcion encargada de dibujarnos el tablero despues de cada movimiento que haga el usuario
     */
    private void dibujarTablero() {
        for (int fila = 0; fila < 8; fila++) {
            for (int columna = 0; columna < 8; columna++) {
                if (tableroLogica.getFichas()[fila][columna] == Fichas.NEGRA)
                    imageButtons[fila][columna].setImageResource(R.drawable.ficha_negra);
                else if (tableroLogica.getFichas()[fila][columna] == Fichas.BLANCA)
                    imageButtons[fila][columna].setImageResource(R.drawable.ficha_blanca);
                else if (tableroLogica.getFichas()[fila][columna] == Fichas.NINGUNA)
                    imageButtons[fila][columna].setImageResource(R.drawable.transparent);
            }
        }
    }

    /**
     * Funcion que me permitive visualizar si hay mas movimiento que el usuario puede realizar.
     *
     * @return
     */
    private boolean hayMovimientos() {
        for (int fila = 0; fila < 8; fila++) {
            for (int columna = 0; columna < 8; columna++) {
                if (tableroLogica.verificarMovimientos(fila, columna))
                    return true;
            }
        }
        return false;
    }

    /*private void verPosiblesMovimientos() {
        for (int fila = 0; fila < 8; fila++) {
            for (int columna = 0; columna < 8; columna++) {
                if (tableroLogica.getFichas()[fila][columna] == Fichas.NINGUNA && tableroLogica.verificarMovimientos(fila, columna))
                    if (tableroLogica.getJugadorActual().getFichas() == Fichas.NEGRA)
                        imageButtons[fila][columna].setImageResource(R.drawable.black_chess_t);
                    else if (tableroLogica.getJugadorActual().getFichas() == Fichas.BLANCA)
                        imageButtons[fila][columna].setImageResource(R.drawable.white_chess_t);
            }
        }
    }*/

    private void ganador(String text) {
        shwDialog.setContentView(R.layout.dialgo_ganador);
        TextView mTextView = shwDialog.findViewById(R.id.txt_ganador);
        mTextView.setText(text);
        Objects.requireNonNull(shwDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        shwDialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.reiniciar:
                tableroLogica.iniciar();
                cambiar(jugadorActual);
                dibujarTablero();

                mTextViewContadorFichaBlanca.setText(String.valueOf(tableroLogica.contador(Fichas.BLANCA)));
                mTextViewContadorFichaNegra.setText(String.valueOf(tableroLogica.contador(Fichas.NEGRA)));

                break;

            case 2:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
