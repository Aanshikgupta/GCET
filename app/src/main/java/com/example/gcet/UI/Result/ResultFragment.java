package com.example.gcet.UI.Result;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.gcet.R;


public class ResultFragment extends Fragment {

    private WebView webView;
    private ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_result, container, false);
        progressBar=((AppCompatActivity) getActivity()).findViewById(R.id.pbmain);
        progressBar.setVisibility(View.VISIBLE);
        webView=view.findViewById(R.id.resultWebView);
        WebSettings settings= webView.getSettings();
        webView.getSettings().setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://erp.aktu.ac.in/WebPages/OneView/OneView.aspx");
        progressBar.setVisibility(View.GONE);
        return view;
    }
}