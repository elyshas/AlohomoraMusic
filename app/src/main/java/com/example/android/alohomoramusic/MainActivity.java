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

public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_main);

            TextView wolfChildrenAlbum = (TextView) findViewById(R.id.wolfChildren);

            wolfChildrenAlbum.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {

                    Intent wolfChildrenIntent = new Intent(MainActivity.this, Artist1Activity.class);

                    startActivity(wolfChildrenIntent);
                }
            });

            TextView ironAndWineAlbum = (TextView) findViewById(R.id.ironAndWine);

            ironAndWineAlbum.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {

                    Intent ironAndWineIntent = new Intent(MainActivity.this, Artist2Activity.class);

                    startActivity(ironAndWineIntent);
                }
            });

        }

}
