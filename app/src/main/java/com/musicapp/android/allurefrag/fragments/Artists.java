package com.musicapp.android.allurefrag.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.musicapp.android.allurefrag.R;


public class Artists extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View artistsLayout = inflater.inflate(R.layout.artists, container, false);
        return artistsLayout;
    }
}
