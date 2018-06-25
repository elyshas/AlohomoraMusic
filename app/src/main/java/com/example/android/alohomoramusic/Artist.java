package com.example.android.alohomoramusic;

/**
 * Created by elysh on 6/16/2018.
 */

// WORKS WITH ARTIST#ACTIVITY TO EXTEND LIST INFORMATION/FORMAT
public class Artist {

    private String mSongName;

    private String mArtistName;

    private String mSongTime;

    public Artist(String SongName, String ArtistName, String SongTime) {
        mSongName = SongName;
        mArtistName = ArtistName;
        mSongTime = SongTime;
    }

    public String getSongName() {
        return mSongName;
    }

    public String getArtistName() {
        return mArtistName;
    }

    public String getSongTime() { return mSongTime;
    }

}
