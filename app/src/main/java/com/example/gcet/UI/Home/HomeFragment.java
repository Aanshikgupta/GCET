package com.example.gcet.UI.Home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.gcet.R;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {
    public HomeFragment() {
    }

    private SliderView slider;
    private ImageView mapView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        setSlider(view);
        return view;
    }

    private void setSlider(View view) {
        slider = view.findViewById(R.id.slider);
        List<Integer> images = new ArrayList<>();
        images.add(R.drawable.gcetimg);
        images.add(R.drawable.gcetimg2);
        images.add(R.drawable.gcetimg3);
        images.add(R.drawable.gcetimg4);
        SliderAdapter adapter = new SliderAdapter(this, images);
        slider.setSliderAdapter(adapter);
    }


}