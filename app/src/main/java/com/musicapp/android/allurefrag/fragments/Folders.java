package com.musicapp.android.allurefrag.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.musicapp.android.allurefrag.R;


public class Folders extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View foldersLayout = inflater.inflate(R.layout.folders, container, false);
        return foldersLayout;
    }

}
