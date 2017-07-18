package com.musicapp.android.allure;

/**
 * Created by MOJISOLA on 26/06/2017.
 */

// {@Link Sound} represents a list of songs the user want to play.
// It contains a song title and the artist name.

public class Sound {

    /** Title of the song*/
    private String mSongTitle;

    /** Artist of the song*/
    private String mSongArtist;

    /** Play the music*/
    private int  mAudioResourceId;

    /** Diagram representation for each sound*/
    private int mImageResourceId = NO_IMAGE_PROVIDED ;

    private static final int NO_IMAGE_PROVIDED = -1;

        /**Create a new Sound object.
        @param songArtist is the artist of the song playing
       @param songTitle is the title of the song playing
       */

    public Sound(String songArtist, String songTitle, int audioResourceId) {
                 mAudioResourceId = audioResourceId;
                 mSongArtist = songArtist;
                 mSongTitle = songTitle;
             }

    public Sound(String songArtist, String songTitle, int audioResourceId, int imageResourceId) {
                    mAudioResourceId = audioResourceId;
                    mSongArtist = songArtist;
                    mSongTitle = songTitle;
                    mImageResourceId = imageResourceId;
                }

      /** Get the song title*/
     public String getSongTitle(){
          return mSongTitle;
      }

      /** Get the song artist name*/
    public String getSongArtist(){
        return mSongArtist;
    }
    /**
     * Get the music icon
     */
      public int getImageResourceId() {
               return mImageResourceId;
                }

    /**
     * Get the song to play
     */
      public int getAudioResourceId() {
              return mAudioResourceId;
               }

     /**
      * Returns whether or not there is an image for this sound
     */
      public boolean hasImage() {
            return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
