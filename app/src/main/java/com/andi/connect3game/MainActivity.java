package com.andi.connect3game;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int[][] winningPostions = new int[][]{
        {0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}
    };

    int activePlayer = 0;
    int []gameState = new int[]{2,2,2,2,2,2,2,2,2};

    public void dropIn(View view) {

        ImageView counter = (ImageView) view;
        counter.setTranslationY(-1500);
        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if (gameState[tappedCounter] == 2) {

            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.yellow);
                gameState[tappedCounter] = activePlayer;
                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.red);
                gameState[tappedCounter] = activePlayer;
                tappedCounter = 0;
                activePlayer = 0;
            }

            counter.animate().translationYBy(1500).rotation(3600).setDuration(500);

            for (int[] winPos : winningPostions) {
                if (gameState[winPos[0]] == gameState[winPos[1]] && gameState[winPos[1]] == gameState[winPos[2]] && gameState[winPos[0]] != 2) {

                    if (activePlayer == 1)
                        Toast.makeText(this, "Yellow won", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "winner is yellow", Toast.LENGTH_SHORT).show();
                }
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
