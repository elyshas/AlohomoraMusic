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

public class Artist3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artist_options);

        ImageView imageHeaderView = new ImageView(this);//use getActivity() on fragment
        imageHeaderView.setBackgroundColor(Color.parseColor("#212121"));
        imageHeaderView.setImageBitmap(BitmapFactory.decodeResource(getResources(),
                R.drawable.type_o_negative_october_rust_album));

        ArrayList<Artist> songList = new ArrayList<>();

        songList.add(new Artist ("Bad Ground", "Type O Negative", "0:38 min"));
        songList.add(new Artist ("Untitled", "Type O Negative", "0:21 min"));
        songList.add(new Artist ("Love You To Death", "Type O Negative", "7:09 min"));
        songList.add(new Artist ("Be My Druidess", "Type O Negative", "5:26 min"));
        songList.add(new Artist ("Green Man", "Type O Negative", "5:48 min"));
        songList.add(new Artist ("Red Water", "Type O Negative", "6:49 min"));
        songList.add(new Artist ("My Girlfriend's Girlfriend", "Type O Negative", "3:47 min"));
        songList.add(new Artist ("Die With Me", "Type O Negative", "7:13 min"));
        songList.add(new Artist ("Burnt Flowers Fallen", "Type O Negative", "6:10 min"));
        songList.add(new Artist ("In Praise OF Bacchus", "Type O Negative", "7:37 min"));
        songList.add(new Artist ("Cinnamon Girl", "Type O Negative", "4:01 min"));
        songList.add(new Artist ("Glorious Liberation", "Type O Negative", "1:07 min"));
        songList.add(new Artist ("Wolf Moon", "Type O Negative", "6:38 min"));
        songList.add(new Artist ("Haunted", "Type O Negative", "10:07 min"));

        ArtistAdapter adapter = new ArtistAdapter(this, songList);

        ListView listView = findViewById(R.id.list);
        listView.addHeaderView(imageHeaderView);
        listView.setAdapter(adapter);

    }
}