package com.musicapp.android.allure;

import android.app.Activity;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.musicapp.android.allure.R;
import com.musicapp.android.allure.Sound;

import java.util.ArrayList;

/**
 * Created by MOJISOLA on 26/06/2017.
 */

public class SoundAdapter extends ArrayAdapter<Sound> {

    /** Resource id for the background colour for this list of sounds */

    private int mColorResourceId;

    private static final String LOG_TAG = SoundAdapter.class.getSimpleName();

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     * @param context, The current context. Used to inflate the layout file.
     * @param sounds A List of Sound objects to display in a list
     */

    public SoundAdapter(Activity context, ArrayList<Sound> sounds, int colorResourceId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.

        super(context, 0, sounds);
        mColorResourceId = colorResourceId;
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Sound} object located at this position in the list
        Sound currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID songtitle_textview
        TextView songTitleTextView = (TextView) listItemView.findViewById(R.id.songtitle_textview);

        // Get the version name from the current Sound object and
        // set this text on the name TextView
        songTitleTextView.setText(currentWord.getSongTitle());


        // Find the TextView in the list_item.xml layout with the ID songartist_textview
        TextView songArtistTextView = (TextView) listItemView.findViewById(R.id.songartist_textview);

        // Get the version name from the current Sound object and
        // set this text on the name TextView
        songArtistTextView.setText(currentWord.getSongArtist());

        // Find the ImageView in the list_item.xml layout with the ID music_imageview
        ImageView musicImageView = (ImageView) listItemView.findViewById(R.id.music_imageview);

        if(currentWord.hasImage()) {
            // Get the version name from the current Sound object and
            // set this text on the name TextView
            musicImageView.setImageResource(currentWord.getImageResourceId());
            musicImageView.setVisibility(View.VISIBLE);
        }
        else{
           musicImageView.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
                View textContainer = listItemView.findViewById(R.id.text_container);
                // Find the color that the resource ID maps to
                        int color = ContextCompat.getColor(getContext(), mColorResourceId);
                // Set the background color of the text container View
                        textContainer.setBackgroundColor(color);


        return listItemView;
    }
}
