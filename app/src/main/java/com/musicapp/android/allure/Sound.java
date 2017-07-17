package com.musicapp.android.allure;

/**
 * Created by MOJISOLA on 26/06/2017.
 */

// {@Link Word} represents a vocabulary word that the user wants to learn.
// It contains a default translation and a miwok translation for that word.

public class Sound {

    /** Title of the song*/
    private String mSongTitle;

    /** Artist of the song*/
    private String mSongArtist;

    /** Miwok audio translation for the word*/
    private int  mAudioResourceId;

    /** Diagram representation for each word*/
    private int mImageResourceId = NO_IMAGE_PROVIDED ;

    private static final int NO_IMAGE_PROVIDED = -1;

             /**
  +     * Create a new Word object.
  +     *
  +     * @param defaultTranslation is the word in a language that the user is already familiar with
  +     *                           (such as English)
  +     * @param miwokTranslation is the word in the Miwok language
  +     */

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

      /** Get the song title*/
    public String getSongArtist(){
        return mSongArtist;
    }
    /**
     * Get the Miwok translation of the word.
     */
      public int getImageResourceId() {
               return mImageResourceId;
                }

    /**
     * Get the Miwok Audio translation of the word.
     */
      public int getAudioResourceId() {
              return mAudioResourceId;
               }

     /**
      * Returns whether or not there is an image for this word
     */
      public boolean hasImage() {
            return mImageResourceId != NO_IMAGE_PROVIDED;
    }

//    @Override
//    public String toString() {
//        return "Word{" +
//                "mDefaultTranslation='" + mDefaultTranslation + '\'' +
//                ", mMiwokTranslation='" + mMiwokTranslation + '\'' +
//                ", mAudioResourceId=" + mAudioResourceId +
//                ", mImageResourceId=" + mImageResourceId +
//                '}';
//    }
}
