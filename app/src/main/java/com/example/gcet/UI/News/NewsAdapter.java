package com.example.gcet.UI.News;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.gcet.Network.POJOModels.ArticlesItem;
import com.example.gcet.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {


    Context context;
    List<ArticlesItem> articlesItems;

    public NewsAdapter(Context context, List<ArticlesItem> articlesItems) {
        this.context = context;
        this.articlesItems = articlesItems;
    }

    @NonNull
    @NotNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.news_item,parent,false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull NewsAdapter.NewsViewHolder holder, int position) {
        ArticlesItem articlesItem=articlesItems.get(position);
        holder.newsItemTitle.setText(articlesItem.getTitle());
        holder.newsItemDesc.setText(articlesItem.getDescription());
        String imgUrl=articlesItem.getUrlToImage();
        if(!(imgUrl==null || imgUrl.equalsIgnoreCase("")))
        Glide.with(context).load(imgUrl).into(holder.newsItemImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(articlesItem.getUrl()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articlesItems.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder{

        ImageView newsItemImage;
        TextView newsItemTitle,newsItemDesc;


        public NewsViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            newsItemDesc=itemView.findViewById(R.id.newsItemDesc);
            newsItemTitle=itemView.findViewById(R.id.newsItemTitle);
            newsItemImage=itemView.findViewById(R.id.newsItemImage);
        }
    }
}
