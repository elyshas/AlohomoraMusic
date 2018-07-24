package com.example.android.alohomoramusic;

//*** Sections of code and processes mimicked from Udacity's project (Miwok Translation App) ***//

/**
 * Created by elysh on 6/16/2018.
 */

// WORKS WITH ARTIST#ACTIVITY TO EXTEND LIST INFORMATION/FORMAT
public class Artist {

    private String mSongName;

    private String mArtistName;

    private String mSongTime;

    private int mAudioResourceId;

    public Artist(String SongName, String ArtistName, String SongTime, int audioResourceId) {
        mSongName = SongName;
        mArtistName = ArtistName;
        mSongTime = SongTime;
        mAudioResourceId = audioResourceId;
    }

    public String getSongName() {
        return mSongName;
    }

    public String getArtistName() {
        return mArtistName;
    }

    public String getSongTime() { return mSongTime; }

    public int getAudioResourceId() {
        return mAudioResourceId;
    }

}
