package com.example.android.musicalstructure;

/**
 * {@link SongStructure} list the title of the song, artist and album.
 */

public class SongStructure {

    // Title of the song
    private String mTitle;

    // Artist of the song
    private String mArtist;

    // Album title
    private String mAlbumName;

    public SongStructure(String title, String artist, String albumName) {
        mTitle = title;
        mArtist = artist;
        mAlbumName = albumName;
    }

    // Get the title of the song
    public String getTitle() {
        return mTitle;
    }

    // Get the author of the song
    public String getArtist() {
        return mArtist;
    }

    // Get the album title
    public String getmAlbumName() { return mAlbumName; }

}
