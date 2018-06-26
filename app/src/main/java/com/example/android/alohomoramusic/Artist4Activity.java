package com.example.android.alohomoramusic;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by elysh on 6/25/2018.
 */

public class Artist4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artist_options);

        ImageView imageHeaderView = new ImageView(this);//use getActivity() on fragment
        imageHeaderView.setBackgroundColor(Color.parseColor("#212121"));
        imageHeaderView.setImageBitmap(BitmapFactory.decodeResource(getResources(),
                R.drawable.eluveitie_origins_album));

        ArrayList<Artist> songList = new ArrayList<>();

        songList.add(new Artist ("Origins", "Eluveitie", "2:13 min"));
        songList.add(new Artist ("The Nameless", "Eluveitie", "4:13 min"));
        songList.add(new Artist ("From Darkness", "Eluveitie", "4:12 min"));
        songList.add(new Artist ("Celtos", "Eluveitie", "3:58 min"));
        songList.add(new Artist ("Virunus", "Eluveitie", "4:52 min"));
        songList.add(new Artist ("Nothing", "Eluveitie", "0:58 min"));
        songList.add(new Artist ("Call Of The Mountains", "Eluveitie", "4:14 min"));
        songList.add(new Artist ("Sucellos", "Eluveitie", "5:06 min"));
        songList.add(new Artist ("Inception", "Eluveitie", "3:47 min"));
        songList.add(new Artist ("Vianna", "Eluveitie", "3:37 min"));
        songList.add(new Artist ("The Silver Sister", "Eluveitie", "4:15 min"));
        songList.add(new Artist ("King", "Eluveitie", "4:33 min"));
        songList.add(new Artist ("Teh Day Of Strife", "Eluveitie", "3:50 min"));
        songList.add(new Artist ("Ogmios", "Eluveitie", "0.29 min"));
        songList.add(new Artist ("Carry The Torch", "Eluveitie", "4:37 min"));
        songList.add(new Artist ("Eternity", "Eluveitie", "2:34 min"));

        ArtistAdapter adapter = new ArtistAdapter(this, songList);

        ListView listView = findViewById(R.id.list);
        listView.addHeaderView(imageHeaderView);
        listView.setAdapter(adapter);

    }
}