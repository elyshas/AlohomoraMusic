package com.example.android.alohomoramusic;
/**WORK IN PROGRESS - NOT PART OF GRADED PROJECT!**/
//TODO: Link to XML, selected song should gain working play, pause, next, and previous buttons. Needs to also have a back button to take user to main page. Needs to also stop playing if user leaves.

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by elysh on 6/26/2018.
 */

//public class SelectedArtistActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.currentlyPlaying);
//
//        TextView selectedSongInAlbum = findViewById(R.id.selected_song);
//
//
//        selectedSongInAlbum.setOnClickListener(new OnClickListener() {
//
//        ImageView albumImageView = new ImageView(this);//use getActivity() on fragment
////      albumImageView.setBackgroundColor(Color.parseColor("#212121"));
//        albumImageView.setImageBitmap(BitmapFactory.decodeResource(
//
//            getResources(),
//
//            R.drawable.??));
//
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(MainActivity.this, SelectedArtistActivity.class);
//                if (getIntent() != null) {
//                    intent.putExtra("position", position);
//                    intent.putExtra("testItem", artists.get(position));
//                }
//                startActivity(intent);
//            }
//        });
//
//
//    }
//}
