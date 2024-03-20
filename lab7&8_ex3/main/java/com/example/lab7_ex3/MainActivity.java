package com.example.lab7_ex3;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private XO game;
    private ImageView[][] imageViews;
    private TextView messageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        game = new XO();
        imageViews = new ImageView[XO.SIZE][XO.SIZE];
        messageView = findViewById(R.id.textViewA);

        for (int i = 0; i < XO.SIZE; i++) {
            for (int j = 0; j < XO.SIZE; j++) {
                int resId = getResources().getIdentifier("imageView_" + i + j, "id", getPackageName());
                imageViews[i][j] = findViewById(resId);
                imageViews[i][j].setOnClickListener(this);
            }
        }

        updateMessage("Start of the game");
    }


    @Override
    public void onClick(View v) {
        // Find which ImageView was clicked
        for (int i = 0; i < XO.SIZE; i++) {
            for (int j = 0; j < XO.SIZE; j++) {
                if (v == imageViews[i][j]) {
                    if (game.isValidMove(i, j)) {
                        // Update game board and UI
                        game.makeMove(i, j);
                        updateUI();
                        // Check for win or draw
                        if (game.checkWin()) {
                            updateMessage("Player " + game.getCurrentPlayer() + " wins!");
                            SystemClock.sleep(5000);
                            resetGame();
                        } else if (game.checkDraw()) {
                            updateMessage("It's a draw!");
                            resetGame();
                        } else {
                            updateMessage("Player " + game.getCurrentPlayer() + "'s turn");
                        }
                    } else {
                        Toast.makeText(this, "Invalid move!", Toast.LENGTH_SHORT).show();
                    }
                    return;
                }
            }
        }
    }


    private void updateUI() {
        // Update ImageViews based on game board
        for (int i = 0; i < XO.SIZE; i++) {
            for (int j = 0; j < XO.SIZE; j++) {
                char symbol = game.getBoard()[i][j];
                int resId = (symbol == 'X') ? R.drawable.img_1 : (symbol == 'O') ? R.drawable.img_2 : 0;
                imageViews[i][j].setImageResource(resId);
            }
        }
    }

    private void updateMessage(String message) {
        messageView.setText(message);
    }

    private void resetGame() {
        // Reset the game board and UI
        game = new XO();
        updateUI();
        updateMessage("Start of the game");
    }

}