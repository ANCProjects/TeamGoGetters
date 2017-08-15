package com.musicapp.android.allurefrag.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.musicapp.android.allurefrag.R;
import com.musicapp.android.allurefrag.classes.Song;
import java.util.ArrayList;

public class SongsRecyclerAdapter extends RecyclerView.Adapter<SongsRecyclerAdapter.Holder> {

    private Context context;
    private ArrayList<Song> songs;
    private OnItemClickListener onItemClickListener;

    public SongsRecyclerAdapter(Context context, ArrayList<Song> songs){
        this.context = context;
        this.songs = songs;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cardView = (CardView) LayoutInflater.from(context)
                .inflate(R.layout.lists_item, parent, false);
        return new Holder(cardView);
    }

    @Override
    public void onBindViewHolder(final Holder holder, int position) {
        Song currentSong = songs.get(position);
        holder.songArtist.setText(currentSong.getSongArtist());
        holder.songTitle.setText(currentSong.getSongTitle());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickListener != null){
                    onItemClickListener.onItemClick(holder.getAdapterPosition());
                }
            }
        });
    }

    @Override
    public int getItemCount() {

        return songs.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    static class Holder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView songTitle, songArtist;
        CardView cardView;

        Holder(CardView cardView) {
            super(cardView);
            imageView = (ImageView) cardView.findViewById(R.id.music_image_view);
            songTitle = (TextView) cardView.findViewById(R.id.song_title_text_view);
            songArtist = (TextView) cardView.findViewById(R.id.song_artist_text_view);
            this.cardView = cardView;
        }
    }

    interface OnItemClickListener{
        void onItemClick(int position);
    }

}
