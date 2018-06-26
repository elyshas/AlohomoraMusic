package com.example.android.alohomoramusic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

/**
 * Created by elysh on 6/16/2018.
 */

// INITIAL APP PAGE, LINKING TO ARTIST#ACTIVITY AND ACTIVITY_MAIN.XML
public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_main);

            //Wolf Children Album
            TextView wolfChildrenAlbum = findViewById(R.id.wolfChildren);

            wolfChildrenAlbum.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {

                    Intent wolfChildrenIntent = new Intent(MainActivity.this, Artist1Activity.class);

                    startActivity(wolfChildrenIntent);
                }
            });

            //Iron & Wine Album
            TextView ironAndWineAlbum = findViewById(R.id.ironAndWine);

            ironAndWineAlbum.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {

                    Intent ironAndWineIntent = new Intent(MainActivity.this, Artist2Activity.class);

                    startActivity(ironAndWineIntent);
                }
            });


            //Type O Negative Album
            TextView typeONegativeAlbum = findViewById(R.id.typeONegative);

            typeONegativeAlbum.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {

                    Intent typeONegativeIntent = new Intent(MainActivity.this, Artist3Activity.class);

                    startActivity(typeONegativeIntent);
                }
            });


            //Eluveitie Album
            TextView eluveitieAlbum = findViewById(R.id.eluveitie);

            eluveitieAlbum.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {

                    Intent eluveitieIntent = new Intent(MainActivity.this, Artist4Activity.class);

                    startActivity(eluveitieIntent);
                }
            });

        }

}
