package com.example.android.alohomoramusic;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import java.util.ArrayList;

/**
 * Created by elysh on 6/16/2018.
 */

public class Artist1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artist_options);

        ImageView imageHeaderView = new ImageView(this);//use getActivity() on fragment
        imageHeaderView.setBackgroundColor(Color.parseColor("#212121"));
        imageHeaderView.setImageBitmap(BitmapFactory.decodeResource(getResources(),
                R.drawable.wolf_children_album));

        ArrayList<Artist> songList = new ArrayList<>();

        songList.add(new Artist ("First Echo", "Wolf Children", "1:30 min"));
        songList.add(new Artist ("Circulation", "Wolf Children", "1:51 min"));
        songList.add(new Artist ("Lullaby in the Peaceful Light", "Wolf Children", "3:57 min"));
        songList.add(new Artist ("Cradle of Myriad Stars", "Wolf Children", "1:35 min"));
        songList.add(new Artist ("Maternity Sky", "Wolf Children", "4:26 min"));
        songList.add(new Artist ("Bud", "Wolf Children", "0:43 min"));
        songList.add(new Artist ("Nene", "Wolf Children", "2:37 min"));
        songList.add(new Artist ("Newborn, Naked Morning", "Wolf Children", "2:14 min"));
        songList.add(new Artist ("Oyoste Aina", "Wolf Children", "3:02 min"));
        songList.add(new Artist ("Gasabura Taata", "Wolf Children", "1:24 min"));
        songList.add(new Artist ("Tanememi", "Wolf Children", "4:40 min"));
        songList.add(new Artist ("Kito Kito", "Wolf Children", "2:08 min"));
        songList.add(new Artist ("Hifumi", "Wolf Children", "1:20 min"));
        songList.add(new Artist ("The Day I Got the Sun", "Wolf Children", "2:01 min"));
        songList.add(new Artist ("All the Warm Lives", "Wolf Children", "2:14 min"));
        songList.add(new Artist ("Bosomed String", "Wolf Children", "1:13 min"));
        songList.add(new Artist ("Weave Your World", "Wolf Children", "2:11 min"));
        songList.add(new Artist ("Tender Smile", "Wolf Children", "1:28 min"));
        songList.add(new Artist ("A Boy and a Mountain", "Wolf Children", "3:24 min"));
        songList.add(new Artist ("Ame tsuchi hito inu", "Wolf Children", "1:46 min"));
        songList.add(new Artist ("You Are My Beautiful Song", "Wolf Children", "1:44 min"));
        songList.add(new Artist ("Rainbow Mane", "Wolf Children", "3:55 min"));
        songList.add(new Artist ("Home After Rain", "Wolf Children", "4:52 min"));
        songList.add(new Artist ("Mother's Song", "Wolf Children", "5:11 min"));

        ArtistAdapter adapter = new ArtistAdapter(this, songList);

        ListView listView = findViewById(R.id.list);
        listView.addHeaderView(imageHeaderView);
        listView.setAdapter(adapter);
    }
}
