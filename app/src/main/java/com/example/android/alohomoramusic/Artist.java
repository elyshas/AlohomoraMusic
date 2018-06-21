package com.example.android.alohomoramusic;

/**
 * Created by elysh on 6/16/2018.
 */

public class Artist {

    /** Was English translation for the word (position bottom)*/
    private String mSongName;

    /** Was Miwok translation for the word (position top)*/
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
