package com.example.gcet.UI.About;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.gcet.R;


public class AboutFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_about, container, false);
        ProgressBar progressBar=getActivity().findViewById(R.id.pbmain);
        progressBar.setVisibility(View.VISIBLE);

        return  view;
    }
}