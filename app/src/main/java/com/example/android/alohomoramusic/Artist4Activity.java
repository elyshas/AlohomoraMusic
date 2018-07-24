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

public class Artist4Activity extends AppCompatActivity {

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

        //** Eluveitie Album art was taken from Google Images **//
        ImageView imageHeaderView = new ImageView(this);//use getActivity() on fragment
        imageHeaderView.setBackgroundColor(Color.parseColor("#212121"));
        imageHeaderView.setImageBitmap(BitmapFactory.decodeResource(getResources(),
                R.drawable.eluveitie_origins_album));

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Artist> songList = new ArrayList<>();

        //NOTICE: I do not own any rights to these songs. They were gathered from purchased CDs and are not to be used or distributed publicly - Only used for classroom purposes.
        songList.add(new Artist ("Origins", "Eluveitie", "2:13 min", R.raw.e_origins));
        songList.add(new Artist ("The Nameless", "Eluveitie", "4:13 min", R.raw.e_the_nameless));
        songList.add(new Artist ("From Darkness", "Eluveitie", "4:12 min", R.raw.e_from_darkness));
        songList.add(new Artist ("Celtos", "Eluveitie", "3:58 min", R.raw.e_celtos));
        songList.add(new Artist ("Virunus", "Eluveitie", "4:52 min", R.raw.e_virunus));
        songList.add(new Artist ("Nothing", "Eluveitie", "0:58 min", R.raw.e_nothing_intermezzo));
        songList.add(new Artist ("Call Of The Mountains", "Eluveitie", "4:14 min", R.raw.e_the_call_of_the_mountains));
        songList.add(new Artist ("Sucellos", "Eluveitie", "5:06 min", R.raw.e_sucellos));
        songList.add(new Artist ("Inception", "Eluveitie", "3:47 min", R.raw.e_inception));
        songList.add(new Artist ("Vianna", "Eluveitie", "3:37 min", R.raw.e_vianna));
        songList.add(new Artist ("The Silver Sister", "Eluveitie", "4:15 min", R.raw.e_the_silver_sister));
        songList.add(new Artist ("King", "Eluveitie", "4:33 min", R.raw.e_king));
        songList.add(new Artist ("The Day Of Strife", "Eluveitie", "3:50 min", R.raw.e_the_day_of_strife));
        songList.add(new Artist ("Ogmios", "Eluveitie", "0.29 min", R.raw.e_ogmios_intermezzo));
        songList.add(new Artist ("Carry The Torch", "Eluveitie", "4:37 min", R.raw.e_carry_the_torch));
        songList.add(new Artist ("Eternity", "Eluveitie", "2:34 min", R.raw.e_eternity));

        ArtistAdapter adapter = new ArtistAdapter(this, songList);

        final ListView listView = findViewById(R.id.list);
        listView.addHeaderView(imageHeaderView, null, false);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                releaseMediaPlayer();

                Artist song = (Artist) listView.getItemAtPosition(position);
                Log.d("Artist4Activity", "Song clicked!!! Position: " + position + " song: " + song.getSongName());
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

                    mMediaPlayer = MediaPlayer.create(Artist4Activity.this, song.getAudioResourceId());

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
