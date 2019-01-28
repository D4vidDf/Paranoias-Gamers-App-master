package net.com.daviddf.paranoiasgamers.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.fragment.app.Fragment;

import net.com.daviddf.paranoiasgamers.R;

import java.util.HashMap;

public class instagram extends Fragment {

    public HashMap<Integer, instagram> beginTransaction;

    public static final String TAG = "TimeLineActivity";

    private static final String baseURl = "https://www.grahamsnaps.com";

    private static final String widgetInfo = "<!-- GrahamSnaps Widget Embed -->" +
            "<div id=\"gs-grid\" class=\"gs-oD6e2p0rI81udA\"></div>" + "<script>(function(a,b,c,d,e){if(!(e in a)){a.gs=function(){a.gs.q.push(arguments);};a.gs.q=[];}var f=b.createElement(c);f.src=d;f.async=!0;var g=b.getElementsByTagName(c)[0];g.parentNode.insertBefore(f,g);})(window,document,\"script\",\"https://cdn.grahamsnaps.com/js/grid.js\",\"gs\");gs(\"Grid\", \"oD6e2p0rI81udA\");</script>";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public WebView mWebView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_instagram, container, false);


        WebView webView = (WebView) v.findViewById(R.id.timeline_webview);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadDataWithBaseURL(baseURl,widgetInfo, "text/html", "UTF-8", null);
        return v;
    }

}
