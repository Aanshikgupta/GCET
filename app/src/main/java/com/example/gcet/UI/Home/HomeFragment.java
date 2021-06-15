package com.example.gcet.UI.Home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.gcet.R;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {
    public HomeFragment() {
    }

    private SliderView slider;
    private ImageView mapView;
    private ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        progressBar=((AppCompatActivity) getActivity()).findViewById(R.id.pbmain);

        progressBar.setVisibility(View.VISIBLE);
        setSlider(view);
        mapView=view.findViewById(R.id.map);
        mapView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.google.com/maps/d/u/0/viewer?mid=1_xhn2GW2vjr8FFkQ_77oI_HJIwM&ll=28.457129410164796%2C77.49778125768853&z=16"));
                startActivity(intent);
            }
        });
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
        progressBar.setVisibility(View.GONE);
    }


}