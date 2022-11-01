package com.example.android.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.android.musicalstructure.EarthWindFireActivity.TITLE_SONG;
import static com.example.android.musicalstructure.EarthWindFireActivity.ARTIST_NAME;
import static com.example.android.musicalstructure.EarthWindFireActivity.ALBUM;


public class NowPlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.now_playing);

        String title = "";
        String artist = "";
        String album = "";

        Intent intent = getIntent();
        if (intent != null) {
           title = intent.getStringExtra(TITLE_SONG);
           artist = intent.getStringExtra(ARTIST_NAME);
           album = intent.getStringExtra(ALBUM);
         }

        TextView titleText = findViewById(R.id.now_playing_title);
        titleText.setText(title);

        TextView artistText = findViewById(R.id.now_playing_artist);
        artistText.setText(artist);

        TextView albumText = findViewById(R.id.now_playing_album);
        albumText.setText(album);

    }
}
