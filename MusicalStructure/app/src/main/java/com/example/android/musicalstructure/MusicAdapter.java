package com.example.android.musicalstructure;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MusicAdapter extends ArrayAdapter<SongStructure> {

    public MusicAdapter(Activity context, ArrayList<SongStructure> songStructures) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, songStructures);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.music_item, parent, false);
        }

        // Get the {@link SongStructure} object located at this position in the list
        SongStructure currentMusic = getItem(position);

        // Find the TextView in the music_item.xml layout with the ID version_name
        TextView titleTextView = listItemView.findViewById(R.id.title_text_view);

        // Get the title name from the current SongStructure object and
        // set this text on the title TextView
        titleTextView.setText(currentMusic.getTitle());

        // Find the TextView in the music_item.xml layout with the ID author
        TextView authorTextView = listItemView.findViewById(R.id.artist_text_view);

        // Get the artist name from the current SongStructure object and
        // set this text on the artist TextView
        authorTextView.setText(currentMusic.getArtist());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
