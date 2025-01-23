package com.example.scorekeeper;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class MainActivity extends AppCompatActivity {

    private int scoreTeam1 = 0;
    private int scoreTeam2 = 0;

    private TextView scoreText1;
    private TextView scoreText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreText1 = findViewById(R.id.team1_score);
        scoreText2 = findViewById(R.id.team2_score);

        ImageButton team1Increase = findViewById(R.id.team1_increase);
        ImageButton team1Decrease = findViewById(R.id.team1_decrease);
        ImageButton team2Increase = findViewById(R.id.team2_increase);
        ImageButton team2Decrease = findViewById(R.id.team2_decrease);

        team1Increase.setOnClickListener(view -> {
            scoreTeam1++;
            updateScore(scoreText1, scoreTeam1);
        });

        team1Decrease.setOnClickListener(view -> {
            if (scoreTeam1 > 0) scoreTeam1--;
            updateScore(scoreText1, scoreTeam1);
        });

        team2Increase.setOnClickListener(view -> {
            scoreTeam2++;
            updateScore(scoreText2, scoreTeam2);
        });

        team2Decrease.setOnClickListener(view -> {
            if (scoreTeam2 > 0) scoreTeam2--;
            updateScore(scoreText2, scoreTeam2);
        });
    }

    //actualizar puntos
    private void updateScore(TextView textView, int score) {
        textView.setText(String.valueOf(score));
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.night_mode) {
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            recreate();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}





