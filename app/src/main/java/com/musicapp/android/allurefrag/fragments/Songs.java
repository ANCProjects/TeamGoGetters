package com.musicapp.android.allurefrag.fragments;

import android.support.v7.widget.RecyclerView;
import com.musicapp.android.allurefrag.classes.Song;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.widget.DividerItemDecoration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.musicapp.android.allurefrag.R;
import com.musicapp.android.allurefrag.adapters.SongsRecyclerAdapter;
import java.util.ArrayList;



public class Songs extends Fragment implements LoaderManager.LoaderCallbacks<ArrayList<Song>> {

    private ArrayList<Song> songs;
    private static final int LOADER_ID = 1000;

    private RecyclerView recyclerView;

    private RelativeLayout relativeLayout;

//    private ProgressBar progressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.songs, container, false);

        relativeLayout = (RelativeLayout) view.findViewById(R.id.relative_layout);

        recyclerView = (RecyclerView) view.findViewById(R.id.list_of_song_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));


        ArrayList<Song> songs = new ArrayList<>();
        SongsRecyclerAdapter adapter = new SongsRecyclerAdapter(getActivity(), songs);
        recyclerView.setAdapter(adapter);
        LoaderManager loaderManager = getLoaderManager();
        Loader<ArrayList<Song>> loader = loaderManager.getLoader(LOADER_ID);

        if (loader == null){
            loaderManager.initLoader(LOADER_ID, null, this).forceLoad();
        } else {
            loaderManager.restartLoader(LOADER_ID, null, this).forceLoad();
        }

        return view;
    }

    @Override
    public Loader<ArrayList<Song>> onCreateLoader(int id, Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<ArrayList<Song>> loader, ArrayList<Song> data) {

    }

    @Override
    public void onLoaderReset(Loader<ArrayList<Song>> loader) {

    }
}