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
 * Created by elysh on 6/20/2018.
 */
//*** Sections of code and processes mimicked from Udacity's project (Miwok Translation App) ***//

public class Artist2Activity extends AppCompatActivity {

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

        //** Iron and Wine Album art was taken from Google Images **//
        ImageView imageHeaderView = new ImageView(this);//use getActivity() on fragment
        imageHeaderView.setBackgroundColor(Color.parseColor("#212121"));
        imageHeaderView.setImageBitmap(BitmapFactory.decodeResource(getResources(),
                R.drawable.iron_and_wine_shepherds_dog_album));

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Artist> songList = new ArrayList<>();

        //NOTICE: I do not own any rights to these songs. They were gathered from purchased CDs and are not to be used or distributed publicly - Only used for classroom purposes.
        songList.add(new Artist ("Pagan Angel/Borrowed Car", "Iron & Wine", "4:33 min", R.raw.iandw_pagan_angel_borrowed_car));
        songList.add(new Artist ("White Tooth Man", "Iron & Wine", "3:57 min", R.raw.iandw_white_tooth_man));
        songList.add(new Artist ("Lovesong of the Buzzard", "Iron & Wine", "4:26 min", R.raw.iandw_lovesong_of_buzzard));
        songList.add(new Artist ("Carousel", "Iron & Wine", "4:02 min", R.raw.iandw_carousel));
        songList.add(new Artist ("House by the Sea", "Iron & Wine", "4:22 min", R.raw.iandw_house_by_sea));
        songList.add(new Artist ("Innocent Bones", "Iron & Wine", "3:43 min", R.raw.iandw_innocent_bones));
        songList.add(new Artist ("Wolves", "Iron & Wine", "4:57 min", R.raw.iandw_wolves));
        songList.add(new Artist ("Resurrection Fern", "Iron & Wine", "4:50 min", R.raw.iandw_resurrection_fern));
        songList.add(new Artist ("Boy With a Coin", "Iron & Wine", "4:06 min", R.raw.iandw_boy_with_a_coin));
        songList.add(new Artist ("The Devil Never Sleeps", "Iron & Wine", "2:07 min", R.raw.iandw_devil_never_sleeps));
        songList.add(new Artist ("Peace Beneath the City", "Iron & Wine", "4:45 min", R.raw.iandw_peace_beneath_the_city));
        songList.add(new Artist ("Flightless Bird, Amer. Mouth", "Iron & Wine", "4:11 min", R.raw.iandw_flightless_bird_american_mouth));
        songList.add(new Artist ("Carried Home", "Iron & Wine", "6:28 min", R.raw.iandw_carried_home));
        songList.add(new Artist ("Kingdom of the Animals", "Iron & Wine", "5:06 min", R.raw.iandw_kingdom_of_animals));

        ArtistAdapter adapter = new ArtistAdapter(this, songList);

        final ListView listView = findViewById(R.id.list);
        listView.addHeaderView(imageHeaderView, null, false);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                releaseMediaPlayer();

                Artist song = (Artist) listView.getItemAtPosition(position);
                Log.d("Artist2Activity", "Song clicked!!! Position: " + position + " song: " + song.getSongName());
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

                    mMediaPlayer = MediaPlayer.create(Artist2Activity.this, song.getAudioResourceId());

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
