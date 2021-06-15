package com.example.gcet.UI.Home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.gcet.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.List;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.ImageViewHolder> {

    Context context;
    List<Integer> imageModelList;

    public SliderAdapter(List<Integer> imageModelList) {
        this.imageModelList = imageModelList;
    }


    public SliderAdapter(HomeFragment homeFragment, List<Integer> images) {
        this.context = homeFragment.getContext();
        this.imageModelList = images;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.slider_item, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder viewHolder, int position) {
        Integer image = imageModelList.get(position);
        viewHolder.imageView.setImageResource(image);
    }

    @Override
    public int getCount() {
        return imageModelList.size();
    }


    public class ImageViewHolder extends SliderViewAdapter.ViewHolder {

        ImageView imageView;

        public ImageViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.sliderImageItem);
        }
    }
}
