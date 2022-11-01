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

public class SpinnersActivity extends AppCompatActivity{

    public static final String TITLE_SONG = "TITLE_SONG";
    public static final String ARTIST_NAME = "ARTIST_NAME";
    public static final String ALBUM = "ALBUM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_list);

        ArrayList<SongStructure> viewHolders = new ArrayList<>();
        viewHolders.add(new SongStructure("Games People Play","The Spinners", "The Rubberband Man"));
        viewHolders.add(new SongStructure("I'll Be Around","The Spinners", "Spinners"));
        viewHolders.add(new SongStructure("One of a Kind","The Spinners", "Spinners"));
        viewHolders.add(new SongStructure("Mighty Love","The Spinners", "Mighty Love"));
        viewHolders.add(new SongStructure("Love Don't Love Nobody","The Spinners","Mighty Love"));
        viewHolders.add(new SongStructure("Ghetto Child","The Spinners", "Spinners"));
        viewHolders.add(new SongStructure("Sadie","The Spinners", "The Rubberband Man"));
        viewHolders.add(new SongStructure("The Rubberband Man","The Spinners","The Rubberband Man"));

        // Get play button drawable
        Resources res = getResources();
        Drawable drawable = res.getDrawable(R.drawable.play_btn);

        /* Create an {@link MusicAdapter}, whose data source is a list of {@link TitleAuthors}s. The
         * adapter knows how to create list items for each item in the list.
         */
        final MusicAdapter adapter = new MusicAdapter(this, viewHolders);

        /* Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
         * There should be a {@link ListView} with the view ID called list, which is declared in the
         * music_list.xml layout file.
         */

        ListView listView  = findViewById(R.id.list);

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
