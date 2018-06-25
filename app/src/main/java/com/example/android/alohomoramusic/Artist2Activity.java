package com.example.android.alohomoramusic;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ListView;
import java.util.ArrayList;

/**
 * Created by elysh on 6/20/2018.
 */

public class Artist2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artist_options);

        ImageView imageHeaderView = new ImageView(this);//use getActivity() on fragment
        imageHeaderView.setBackgroundColor(Color.parseColor("#212121"));
        imageHeaderView.setImageBitmap(BitmapFactory.decodeResource(getResources(),
                R.drawable.iron_and_wine_shepherds_dog_album));

        ArrayList<Artist> songList = new ArrayList<>();

        songList.add(new Artist ("Pagan Angel/Borrowed Car", "Iron & Wine", "4:33 min"));
        songList.add(new Artist ("White Tooth Man", "Iron & Wine", "3:57 min"));
        songList.add(new Artist ("Lovesong of the Buzzard", "Iron & Wine", "4:26 min"));
        songList.add(new Artist ("Carousel", "Iron & Wine", "4:02 min"));
        songList.add(new Artist ("House by the Sea", "Iron & Wine", "4:22 min"));
        songList.add(new Artist ("Innocent Bones", "Iron & Wine", "3:43 min"));
        songList.add(new Artist ("Wolves", "Iron & Wine", "4:57 min"));
        songList.add(new Artist ("Resurrection Fern", "Iron & Wine", "4:50 min"));
        songList.add(new Artist ("Boy With a Coin", "Iron & Wine", "4:06 min"));
        songList.add(new Artist ("The Devil Never Sleeps", "Iron & Wine", "2:07 min"));
        songList.add(new Artist ("Peace Beneath the City", "Iron & Wine", "4:45 min"));
        songList.add(new Artist ("Flightless Bird, Amer. Mouth", "Iron & Wine", "4:11 min"));
        songList.add(new Artist ("Carried Home", "Iron & Wine", "6:28 min"));
        songList.add(new Artist ("Kingdom of the Animals", "Iron & Wine", "5:06 min"));

        ArtistAdapter adapter = new ArtistAdapter(this, songList);

        ListView listView = findViewById(R.id.list);
        listView.addHeaderView(imageHeaderView);
        listView.setAdapter(adapter);

    }
}
