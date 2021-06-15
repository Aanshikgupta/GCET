package com.example.gcet.UI.Gallery;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.gcet.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder> {

    Context context;
    List<Gallery> galleryList;

    public GalleryAdapter() {
    }

    public GalleryAdapter(Context context, List<Gallery> galleryList) {
        this.context = context;
        this.galleryList = galleryList;
    }

    @NonNull
    @NotNull
    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(context).inflate(R.layout.gallery_item,parent,false);
       return new GalleryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull GalleryAdapter.GalleryViewHolder holder, int position) {
        Gallery gallery=galleryList.get(position);
        Glide.with(context).load(gallery.getImageUrl()).into(holder.galleryItemImage);


    }

    @Override
    public int getItemCount() {
        return galleryList.size();
    }

    public class GalleryViewHolder extends RecyclerView.ViewHolder {
        ImageView galleryItemImage;
        public GalleryViewHolder(View itemView) {
            super(itemView);
            galleryItemImage=itemView.findViewById(R.id.galleryItemImageView);
        }
    }
}
