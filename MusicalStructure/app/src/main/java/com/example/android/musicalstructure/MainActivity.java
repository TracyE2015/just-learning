package com.example.android.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Toolbar myToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Set a click listener on the Earth Wind and Fire View
        TextView ewf = (TextView) findViewById(R.id.ewf);
        ewf.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent ewfIntent = new Intent(MainActivity.this, EarthWindFireActivity.class);
                startActivity(ewfIntent);
            }
        });

        // Set a click listener on the Maze View
        TextView maze = (TextView) findViewById(R.id.maze);
        maze.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent mazeIntent = new Intent(MainActivity.this, MazeActivity.class);
                startActivity(mazeIntent);
            }
        });

        // Set a click listener on the Spinners View
        TextView spinners = (TextView) findViewById(R.id.spinners);
        spinners.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent spinnersIntent = new Intent(MainActivity.this, SpinnersActivity.class);
                startActivity(spinnersIntent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

  }
