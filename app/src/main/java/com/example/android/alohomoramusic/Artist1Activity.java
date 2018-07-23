package com.example.android.alohomoramusic;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import java.util.ArrayList;

//*** Sections of code and processes mimicked from Udacity's project (Miwok Translation App) ***//

/**
 * Created by elysh on 6/16/2018.
 */

public class Artist1Activity extends AppCompatActivity {

    /**ADD TO OTHER ALBUM ACTIVITIES**/
    /**Playback of sound files **/
    private MediaPlayer mMediaPlayer;
    /**ADD TO OTHER ALBUM ACTIVITIES**/
    /**Audio focus when playing sound files**/
    private AudioManager mAudioManager;
    /**ADD TO OTHER ALBUM ACTIVITIES**/
    /**Listener triggered when audio focus changes**/
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
    /**ADD TO OTHER ALBUM ACTIVITIES**/
    /***Listener triggered when the MediaPlayer finishes playing audio file*/
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

        //** Wolf Children Album art was taken from Google Images **//
        ImageView imageHeaderView = new ImageView(this);//use getActivity() on fragment
        imageHeaderView.setBackgroundColor(Color.parseColor("#212121"));
        imageHeaderView.setImageBitmap(BitmapFactory.decodeResource(getResources(),
                R.drawable.wolf_children_album));

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Artist> songList = new ArrayList<>();

        //NOTICE: I do not own any rights to these songs. They were gathered from purchased CDs and are not to be used or distributed publicly - Only used for classroom purposes.
        songList.add(new Artist("First Echo", "Wolf Children", "1:30 min", R.raw.wc_first_echo));
        songList.add(new Artist("Circulation", "Wolf Children", "1:51 min", R.raw.wc_circulation));
        songList.add(new Artist("Lullaby in the Peaceful Light", "Wolf Children", "3:57 min", R.raw.wc_lullaby_in_peaceful_light));
//        songList.add(new Artist("Cradle of Myriad Stars", "Wolf Children", "1:35 min", R.raw.wc_cradle_of_myriad_stars));
//        songList.add(new Artist("Maternity Sky", "Wolf Children", "4:26 min", R.raw.wc_maternity_sky));
//        songList.add(new Artist("Bud", "Wolf Children", "0:43 min", R.raw.wc_bud));
//        songList.add(new Artist("Nene", "Wolf Children", "2:37 min", R.raw.wc_nene));
//        songList.add(new Artist("Newborn, Naked Morning", "Wolf Children", "2:14 min", R.raw.wc_newborn_naked_morning));
//        songList.add(new Artist("Oyoste Aina", "Wolf Children", "3:02 min", R.raw.wc_oyoste_aina));
//        songList.add(new Artist("Gasabura Taata", "Wolf Children", "1:24 min", R.raw.wc_gasabura_taata));
//        songList.add(new Artist("Tanememi", "Wolf Children", "4:40 min", R.raw.wc_tanememi));
//        songList.add(new Artist("Kito Kito", "Wolf Children", "2:08 min", R.raw.wc_kito_kito));
//        songList.add(new Artist("Hifumi", "Wolf Children", "1:20 min", R.raw.wc_hifumi));
//        songList.add(new Artist("The Day I Got the Sun", "Wolf Children", "2:01 min", R.raw.wc_the_day_i_got_sun));
//        songList.add(new Artist("All the Warm Lives", "Wolf Children", "2:14 min", R.raw.wc_all_the_warm_lives));
//        songList.add(new Artist("Bosomed String", "Wolf Children", "1:13 min", R.raw.wc_bosomed_string));
//        songList.add(new Artist("Weave Your World", "Wolf Children", "2:11 min", R.raw.wc_weave_your_world));
//        songList.add(new Artist("Tender Smile", "Wolf Children", "1:28 min", R.raw.wc_tender_smile));
//        songList.add(new Artist("A Boy and a Mountain", "Wolf Children", "3:24 min", R.raw.wc_a_boy_and_a_mountain));
//        songList.add(new Artist("Ame tsuchi hito inu", "Wolf Children", "1:46 min", R.raw.wc_ame_tsuchi_hito_inu));
//        songList.add(new Artist("You Are My Beautiful Song", "Wolf Children", "1:44 min", R.raw.wc_you_are_my_beautiful_song));
//        songList.add(new Artist("Rainbow Mane", "Wolf Children", "3:55 min", R.raw.wc_rainbow_mane));
//        songList.add(new Artist("Home After Rain", "Wolf Children", "4:52 min", R.raw.wc_home_after_rain));
//        songList.add(new Artist("Mother's Song", "Wolf Children", "5:11 min", R.raw.wc_mothers_song));

        ArtistAdapter adapter = new ArtistAdapter(this, songList);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(adapter); listView.addHeaderView(imageHeaderView, null, false);

        /**ADD TO OTHER ALBUM ACTIVITIES**/
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Log.d("Artist1Activity", "Song clicked!!!");
                releaseMediaPlayer();

                Artist song = songList.get(position);

                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

                    mMediaPlayer = MediaPlayer.create(Artist1Activity.this, song.getAudioResourceId());

                    mMediaPlayer.start();

                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });
    }

    /**ADD TO OTHER ALBUM ACTIVITIES**/
    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    /**ADD TO OTHER ALBUM ACTIVITIES**/
    /**Cleanup by releasing resources**/
    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }
}
