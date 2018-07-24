package com.example.android.alohomoramusic;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by elysh on 6/25/2018.
 */
//*** Sections of code and processes mimicked from Udacity's project (Miwok Translation App) ***//

public class Artist3Activity extends AppCompatActivity {

    //**Playback of sound files **/
    private MediaPlayer mMediaPlayer;
    //**Audio focus when playing sound files**
    private AudioManager mAudioManager;
    //**Listener triggered when audio focus changes**
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }
        }
    };

    //***Listener triggered when the MediaPlayer finishes playing audio file***
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artist_options);

        //** Type O Negative Album art was taken from Google Images **//
        ImageView imageHeaderView = new ImageView(this);//use getActivity() on fragment
        imageHeaderView.setBackgroundColor(Color.parseColor("#212121"));
        imageHeaderView.setImageBitmap(BitmapFactory.decodeResource(getResources(),
                R.drawable.type_o_negative_october_rust_album));

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Artist> songList = new ArrayList<>();

        //NOTICE: I do not own any rights to these songs. They were gathered from purchased CDs and are not to be used or distributed publicly - Only used for classroom purposes.
        songList.add(new Artist ("Bad Ground", "Type O Negative", "0:38 min", R.raw.ton_bad_round));
        songList.add(new Artist ("Untitled", "Type O Negative", "0:21 min", R.raw.ton_untitled_intro));
        songList.add(new Artist ("Love You To Death", "Type O Negative", "7:09 min", R.raw.ton_love_you_to_death));
        songList.add(new Artist ("Be My Druidess", "Type O Negative", "5:26 min", R.raw.ton_my_druidess));
        songList.add(new Artist ("Green Man", "Type O Negative", "5:48 min", R.raw.ton_green_man));
        songList.add(new Artist ("Red Water", "Type O Negative", "6:49 min", R.raw.ton_red_water));
        songList.add(new Artist ("My Girlfriend's Girlfriend", "Type O Negative", "3:47 min", R.raw.ton_my_girlfriends_girlfriend));
        songList.add(new Artist ("Die With Me", "Type O Negative", "7:13 min", R.raw.ton_die_with_me));
        songList.add(new Artist ("Burnt Flowers Fallen", "Type O Negative", "6:10 min", R.raw.ton_burnt_flowers_fallen));
        songList.add(new Artist ("In Praise OF Bacchus", "Type O Negative", "7:37 min", R.raw.ton_in_praise_of_bacchus));
        songList.add(new Artist ("Cinnamon Girl", "Type O Negative", "4:01 min", R.raw.ton_cinnamon_girl));
        songList.add(new Artist ("Glorious Liberation", "Type O Negative", "1:07 min", R.raw.ton_the_glorious_liberation_of_the_peoples_technocratic_republic));
        songList.add(new Artist ("Wolf Moon", "Type O Negative", "6:38 min", R.raw.ton_wolf_moon));
        songList.add(new Artist ("Haunted", "Type O Negative", "10:07 min", R.raw.ton_haunted));

        ArtistAdapter adapter = new ArtistAdapter(this, songList);

        final ListView listView = findViewById(R.id.list);
        listView.addHeaderView(imageHeaderView, null, false);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                releaseMediaPlayer();

                Artist song = (Artist) listView.getItemAtPosition(position);
                Log.d("Artist3Activity", "Song clicked!!! Position: " + position + " song: " + song.getSongName());
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

                    mMediaPlayer = MediaPlayer.create(Artist3Activity.this, song.getAudioResourceId());

                    mMediaPlayer.start();

                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    //**Cleanup by releasing resources**
    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }
}
