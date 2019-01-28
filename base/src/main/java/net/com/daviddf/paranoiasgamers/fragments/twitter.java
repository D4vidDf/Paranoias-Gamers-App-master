package net.com.daviddf.paranoiasgamers.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.fragment.app.Fragment;

import net.com.daviddf.paranoiasgamers.R;

import java.util.HashMap;

public class twitter extends Fragment {
    public HashMap<Integer, twitter> beginTransaction;
    public static final String TAG = "TimeLineActivity";

    private static final String baseURl = "http://twitter.com";

    private static final String widgetInfo = "<a class=\"twitter-timeline\" data-lang=\"es\" data-dnt=\"true\" data-theme=\"light\" href=\"https://twitter.com/ParanoiasGamers?ref_src=twsrc%5Etfw\">Tweets by ParanoiasGamers</a>" +
            "<script async src=\"https://platform.twitter.com/widgets.js\" charset=\"utf-8\"></script> ";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public WebView mWebView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_twitter, container, false);


        WebView webView = (WebView) v.findViewById(R.id.timeline_webview);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadDataWithBaseURL(baseURl, widgetInfo, "text/html", "UTF-8", null);
        return v;
    }


}
