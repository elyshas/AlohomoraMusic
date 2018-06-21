package com.example.android.alohomoramusic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        ArrayList<Artist> artist = new ArrayList<>();

        artist.add(new Artist ("Wolf Children", "Atarashii Asa", "2:15"));
        artist.add(new Artist ("Wolf Children", "Ki Toki To", "2:09"));

        ArtistAdapter adapter = new ArtistAdapter(this, artist);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(adapter);

    }

}
