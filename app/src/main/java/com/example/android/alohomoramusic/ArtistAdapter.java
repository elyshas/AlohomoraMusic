package com.example.android.alohomoramusic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by elysh on 6/16/2018.
 */
//WORKS WITH SELECTED_ARTIST.XML
public class ArtistAdapter extends ArrayAdapter<Artist> {

    public ArtistAdapter(Context context, ArrayList<Artist> artist) {
        super(context, 0, artist);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.selected_artist, parent, false);
        }

        Artist currentArtist = getItem(position);

        TextView artistTextView = listItemView.findViewById(R.id.artist);

        artistTextView.setText(currentArtist.getArtistName());

        TextView songTextView = listItemView.findViewById(R.id.song);

        songTextView.setText(currentArtist.getSongName());

        TextView timeTextView = listItemView.findViewById(R.id.time);

        timeTextView.setText(currentArtist.getSongTime());

        return listItemView;
    }
}
