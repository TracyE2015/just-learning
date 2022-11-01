package com.example.android.musicalstructure;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import java.io.Serializable;
import java.util.ArrayList;

public class EarthWindFireActivity extends AppCompatActivity {

    public static final String TITLE_SONG = "TITLE_SONG";
    public static final String ARTIST_NAME = "ARTIST_NAME";
    public static final String ALBUM = "ALBUM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_list);

        final ArrayList<SongStructure> songStructure = new ArrayList<>();
        songStructure.add(new SongStructure("That's The Way of The World", "Earth Wind & Fire", "That's The Way of The World"));
        songStructure.add(new SongStructure("Reasons", "Earth Wind & Fire", "That's The Way of The World"));
        songStructure.add(new SongStructure("I'll Write a Song For You", "Earth Wind & Fire", "All N All"));
        songStructure.add(new SongStructure("Love's Holiday", "Earth Wind & Fire", "All N All"));
        songStructure.add(new SongStructure("Sing A Song", "Earth Wind & Fire", "Gratitude"));
        songStructure.add(new SongStructure("Devotion", "Earth Wind & Fire", "Gratitude"));
        songStructure.add(new SongStructure("Shining Star", "Earth Wind & Fire", "Pure Funk"));
        songStructure.add(new SongStructure("Can't Hide Love", "Earth Wind & Fire", "Gratitude"));

        // Get play button drawable
        Resources res = getResources();
        Drawable drawable = res.getDrawable(R.drawable.play_btn);

        /* Create an {@link MusicAdapter}, whose data source is a list of {@link TitleAuthors}s. The
         * adapter knows how to create list items for each item in the list.
         */
        final MusicAdapter adapter = new MusicAdapter(this, songStructure);

        /* Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
         * There should be a {@link ListView} with the view ID called list, which is declared in the
         * music_list.xml layout file.
         */

        ListView listView = findViewById(R.id.list);

        /* Make the {@link ListView} use the {@link MusicAdapter} we created above, so that the
         * {@link ListView} will display list items for each {@link ViewHolder} in the list.
         */
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                SongStructure songItem = (SongStructure) adapter.getItem(i);

                Intent intent = new Intent(getApplicationContext(), NowPlayingActivity.class);
                    intent.putExtra(TITLE_SONG, songItem.getTitle());
                    intent.putExtra(ARTIST_NAME, songItem.getArtist());
                    intent.putExtra(ALBUM, songItem.getmAlbumName());
                    startActivity(intent);

            }
        });

    }

}
