package com.example.gcet.UI.News;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.gcet.Network.GetNews;
import com.example.gcet.Network.POJOModels.ArticlesItem;
import com.example.gcet.Network.POJOModels.Response;
import com.example.gcet.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsFragment extends Fragment {

    private RecyclerView newsRecyclerView;
    private Retrofit retrofit=null;
    private GetNews getNews;
    private List<ArticlesItem> newsItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_news, container, false);
        setRecycler(view);
        retrofitSetup(view);
        return view;
    }

    private void setRecycler(View view) {
        newsRecyclerView=view.findViewById(R.id.newsRecyclerView);
        newsRecyclerView.setHasFixedSize(true);
        newsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void retrofitSetup(View view) {
        retrofit=new Retrofit.Builder()
                .baseUrl("https://newsapi.org/").addConverterFactory(GsonConverterFactory.create()).build();

        getNews=retrofit.create(GetNews.class);
        Call<Response> responseCall=getNews.getResponse();
        responseCall.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                newsItems=response.body().getArticles();
                NewsAdapter adapter=new NewsAdapter(getContext(),newsItems);
                newsRecyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();


            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

                Toast.makeText(getContext(),"Something went wrong, please try again!",Toast.LENGTH_LONG).show();

            }
        });

    }


}