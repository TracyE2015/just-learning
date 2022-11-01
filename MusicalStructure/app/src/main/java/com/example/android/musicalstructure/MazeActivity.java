package com.example.android.musicalstructure;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class MazeActivity extends AppCompatActivity{

    public static final String TITLE_SONG = "TITLE_SONG";
    public static final String ARTIST_NAME = "ARTIST_NAME";
    public static final String ALBUM = "ALBUM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_list);

        ArrayList<SongStructure> viewHolders = new ArrayList<>();
        viewHolders.add(new SongStructure("Joy and Pain","Maze", "Joy and Pain"));
        viewHolders.add(new SongStructure("Happy Feelins","Maze", "Maze"));
        viewHolders.add(new SongStructure("Love Is The Key","Maze", "We Are One"));
        viewHolders.add(new SongStructure("We Are One'","Maze", "We Are One"));
        viewHolders.add(new SongStructure("While I'm Alone","Maze","Maze"));
        viewHolders.add(new SongStructure("Back In Stride","Maze", "Can't Stop the Love"));
        viewHolders.add(new SongStructure("Golden Time of Day","Maze","Golden Time of Day" ));
        viewHolders.add(new SongStructure("Can't Get Over You","Maze", "Silky Soul"));

        // Get play button drawable
        Resources res = getResources();
        Drawable drawable = res.getDrawable(R.drawable.play_btn);

        /* Create an {@link MusicAdapter}, whose data source is a list of {@link ViewHolder}s. The
         * adapter knows how to create list items for each item in the list.
         */
        final MusicAdapter adapter = new MusicAdapter(this, viewHolders);

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
