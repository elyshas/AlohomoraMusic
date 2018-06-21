package com.example.android.alohomoramusic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

        ArrayList<Artist> artist = new ArrayList<>();

        artist.add(new Artist ("Iron & Wine", "Innocent Bones", "3:50"));
        artist.add(new Artist ("Iron & Wine", "House By The Sea", "4:30"));

        ArtistAdapter adapter = new ArtistAdapter(this, artist);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(adapter);

    }
}
