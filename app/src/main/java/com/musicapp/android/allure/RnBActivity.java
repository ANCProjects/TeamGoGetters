package com.musicapp.android.allure;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class RnBActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sound_list);

        // Create an ArrayList of words

        final ArrayList<Sound> sounds = new ArrayList<Sound>();
        // words.add("one");
        //This is for a single output for more than one we use an object to specify it.

        sounds.add(new Sound("charlie","We don't talk anymore",R.raw.charlie_puth, R.drawable.music_icon));
        sounds.add(new Sound("Olamide ft. Don Jazzy","Skelemba", R.raw.ola_don, R.drawable.music_icon));

        // Array Adapter
//        ArrayAdapter<Word> itemsAdapter = new ArrayAdapter<Word>(this, R.layout.list_item, words);

        // Custom ArrayAdapter.
        // Overriding getView method.
        SoundAdapter adapter = new SoundAdapter(this, sounds, R.color.category_rnb);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        //Release media player if it currently exist because we are about tp
        //Play a different audio file
        releaseMediaPlayer();


        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Word} object at the given position the user clicked on
                Sound sound = sounds.get(position);

                //Release media player if it currently exist because we are about tp
                //Play a different audio file
                releaseMediaPlayer();

                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                mMediaPlayer = MediaPlayer.create(RnBActivity.this, sound.getAudioResourceId());

                // Start the audio file
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }
    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
}
