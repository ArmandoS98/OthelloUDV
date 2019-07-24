package com.tecnologiatransaccional.othello10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tecnologiatransaccional.othello10.Fichas.Fichas;
import com.tecnologiatransaccional.othello10.Tablero.Tablero;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private int[][] idviews = {
            {R.id.board11, R.id.board12, R.id.board13, R.id.board14, R.id.board15, R.id.board16, R.id.board17, R.id.board18},
            {R.id.board21, R.id.board22, R.id.board23, R.id.board24, R.id.board25, R.id.board26, R.id.board27, R.id.board28},
            {R.id.board31, R.id.board32, R.id.board33, R.id.board34, R.id.board35, R.id.board36, R.id.board37, R.id.board38},
            {R.id.board41, R.id.board42, R.id.board43, R.id.board44, R.id.board45, R.id.board46, R.id.board47, R.id.board48},
            {R.id.board51, R.id.board52, R.id.board53, R.id.board54, R.id.board55, R.id.board56, R.id.board57, R.id.board58},
            {R.id.board61, R.id.board62, R.id.board63, R.id.board64, R.id.board65, R.id.board66, R.id.board67, R.id.board68},
            {R.id.board71, R.id.board72, R.id.board73, R.id.board74, R.id.board75, R.id.board76, R.id.board77, R.id.board78},
            {R.id.board81, R.id.board82, R.id.board83, R.id.board84, R.id.board85, R.id.board86, R.id.board87, R.id.board88}};

    private ImageButton[][] imageButtons = new ImageButton[8][8];

    private int hint_button = 0; // Default turn-off

    private ImageButton current;
    private TextView whiteCount;
    private TextView blackCount;

    //Incializadion del trablero
    private Tablero tablero = new Tablero();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        whiteCount = findViewById(R.id.whiteNum);
        blackCount = findViewById(R.id.blackNum);

      /*  Button newGame = findViewById(R.id.newGame);
        newGame.setOnClickListener(this);

        Button hint = findViewById(R.id.hint);
        hint.setOnClickListener(this);*/

        current = findViewById(R.id.current);

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
                chessAction(0, 0);
                break;

            case R.id.board12:
                chessAction(0, 1);
                break;

            case R.id.board13:
                chessAction(0, 2);
                break;

            case R.id.board14:
                chessAction(0, 3);
                break;

            case R.id.board15:
                chessAction(0, 4);
                break;

            case R.id.board16:
                chessAction(0, 5);
                break;

            case R.id.board17:
                chessAction(0, 6);
                break;

            case R.id.board18:
                chessAction(0, 7);
                break;

            case R.id.board21:
                chessAction(1, 0);
                break;

            case R.id.board22:
                chessAction(1, 1);
                break;

            case R.id.board23:
                chessAction(1, 2);
                break;

            case R.id.board24:
                chessAction(1, 3);
                break;

            case R.id.board25:
                chessAction(1, 4);
                break;

            case R.id.board26:
                chessAction(1, 5);
                break;

            case R.id.board27:
                chessAction(1, 6);
                break;

            case R.id.board28:
                chessAction(1, 7);
                break;

            case R.id.board31:
                chessAction(2, 0);
                break;

            case R.id.board32:
                chessAction(2, 1);
                break;

            case R.id.board33:
                chessAction(2, 2);
                break;

            case R.id.board34:
                chessAction(2, 3);
                break;

            case R.id.board35:
                chessAction(2, 4);
                break;

            case R.id.board36:
                chessAction(2, 5);
                break;

            case R.id.board37:
                chessAction(2, 6);
                break;

            case R.id.board38:
                chessAction(2, 7);
                break;

            case R.id.board41:
                chessAction(3, 0);
                break;

            case R.id.board42:
                chessAction(3, 1);
                break;

            case R.id.board43:
                chessAction(3, 2);
                break;

            case R.id.board44:
                chessAction(3, 3);
                break;

            case R.id.board45:
                chessAction(3, 4);
                break;

            case R.id.board46:
                chessAction(3, 5);
                break;

            case R.id.board47:
                chessAction(3, 6);
                break;

            case R.id.board48:
                chessAction(3, 7);
                break;

            case R.id.board51:
                chessAction(4, 0);
                break;

            case R.id.board52:
                chessAction(4, 1);
                break;

            case R.id.board53:
                chessAction(4, 2);
                break;

            case R.id.board54:
                chessAction(4, 3);
                break;

            case R.id.board55:
                chessAction(4, 4);
                break;

            case R.id.board56:
                chessAction(4, 5);
                break;

            case R.id.board57:
                chessAction(4, 6);
                break;

            case R.id.board58:
                chessAction(4, 7);
                break;

            case R.id.board61:
                chessAction(5, 0);
                break;

            case R.id.board62:
                chessAction(5, 1);
                break;

            case R.id.board63:
                chessAction(5, 2);
                break;

            case R.id.board64:
                chessAction(5, 3);
                break;

            case R.id.board65:
                chessAction(5, 4);
                break;

            case R.id.board66:
                chessAction(5, 5);
                break;

            case R.id.board67:
                chessAction(5, 6);
                break;

            case R.id.board68:
                chessAction(5, 7);
                break;

            case R.id.board71:
                chessAction(6, 0);
                break;

            case R.id.board72:
                chessAction(6, 1);
                break;

            case R.id.board73:
                chessAction(6, 2);
                break;

            case R.id.board74:
                chessAction(6, 3);
                break;

            case R.id.board75:
                chessAction(6, 4);
                break;

            case R.id.board76:
                chessAction(6, 5);
                break;

            case R.id.board77:
                chessAction(6, 6);
                break;

            case R.id.board78:
                chessAction(6, 7);
                break;

            case R.id.board81:
                chessAction(7, 0);
                break;

            case R.id.board82:
                chessAction(7, 1);
                break;

            case R.id.board83:
                chessAction(7, 2);
                break;

            case R.id.board84:
                chessAction(7, 3);
                break;

            case R.id.board85:
                chessAction(7, 4);
                break;

            case R.id.board86:
                chessAction(7, 5);
                break;

            case R.id.board87:
                chessAction(7, 6);
                break;

            case R.id.board88:
                chessAction(7, 7);
                break;
        }
    }

    private void chessAction(int fila, int columna) {
        if (tablero.verificarDisponibles() != 0 && hayMovimientos()) {
            if (tablero.verificarMovimientos(fila, columna)) {
                tablero.volearFicha(fila, columna);
                tablero.posicionFicha(fila, columna);
                dibujarTablero();

                whiteCount.setText("BLANCO : " + tablero.contador(Fichas.BLANCA));
                blackCount.setText("NEGRO  : " + tablero.contador(Fichas.NEGRA));

                if (tablero.verificarDisponibles() != 0) {
                    tablero.siguienteTurno();
                    cambiar(current);

                    if (!hayMovimientos())
                        mostrarGanador();
                }

                if (tablero.verificarDisponibles() == 0)
                    mostrarGanador();


            }
        } else {
            Toast.makeText(MainActivity.this, "Nuevo Juego", Toast.LENGTH_SHORT).show();
        }
    }

    private void mostrarGanador() {
        if (tablero.contador(Fichas.NEGRA) > tablero.contador(Fichas.BLANCA)) {
            Toast.makeText(this, "FICHAS NEGRAS GANA", Toast.LENGTH_LONG).show();
        } else if (tablero.contador(Fichas.NEGRA) < tablero.contador(Fichas.BLANCA)) {
            Toast.makeText(this, "FICHAS BLANCAS GANA", Toast.LENGTH_LONG).show();
        } else if (tablero.contador(Fichas.NEGRA) == tablero.contador(Fichas.BLANCA)) {
            Toast.makeText(this, "EMPATE", Toast.LENGTH_LONG).show();
        }
    }

    private void cambiar(ImageButton current) {
        if (tablero.getJugadorActual().getFichas() == Fichas.NEGRA)
            current.setImageResource(R.drawable.ficha_negra);
        else if (tablero.getJugadorActual().getFichas() == Fichas.BLANCA)
            current.setImageResource(R.drawable.ficha_blanca);
        else
            current.setImageResource(R.drawable.transparent);
    }

    private void dibujarTablero() {
        for (int fila = 0; fila < 8; fila++) {
            for (int columna = 0; columna < 8; columna++) {
                if (tablero.getFichas()[fila][columna] == Fichas.NEGRA)
                    imageButtons[fila][columna].setImageResource(R.drawable.ficha_negra);
                else if (tablero.getFichas()[fila][columna] == Fichas.BLANCA)
                    imageButtons[fila][columna].setImageResource(R.drawable.ficha_blanca);
                else if (tablero.getFichas()[fila][columna] == Fichas.NINGUNA)
                    imageButtons[fila][columna].setImageResource(R.drawable.transparent);
            }
        }
    }

    private boolean hayMovimientos() {
        for (int fila = 0; fila < 8; fila++) {
            for (int columna = 0; columna < 8; columna++) {
                if (tablero.verificarMovimientos(fila, columna))
                    return true;
            }
        }
        return false;
    }

    private void verPosiblesMovimientos() {
        for (int fila = 0; fila < 8; fila++) {
            for (int columna = 0; columna < 8; columna++) {
                if (tablero.getFichas()[fila][columna] == Fichas.NINGUNA && tablero.verificarMovimientos(fila, columna))
                    if (tablero.getJugadorActual().getFichas() == Fichas.NEGRA)
                        imageButtons[fila][columna].setImageResource(R.drawable.black_chess_t);
                    else if (tablero.getJugadorActual().getFichas() == Fichas.BLANCA)
                        imageButtons[fila][columna].setImageResource(R.drawable.white_chess_t);
            }
        }
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
                tablero.iniciar();
                dibujarTablero();
                current.setImageResource(R.drawable.ficha_negra);

                whiteCount.setText("WHITE : " + tablero.contador(Fichas.BLANCA));
                blackCount.setText("BLACK : " + tablero.contador(Fichas.NEGRA));

                // Reset hint parameter
                hint_button = 0;
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
