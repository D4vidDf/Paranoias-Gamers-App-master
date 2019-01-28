package net.com.daviddf.paranoiasgamers.fragments;


import android.app.Dialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.prof.rssparser.Article;
import com.prof.rssparser.Parser;

import net.com.daviddf.paranoiasgamers.R;
import net.com.daviddf.paranoiasgamers.adapters.ArticleAdapter;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class Noticias extends Fragment {


    private View view;
    private ArticleAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private ProgressBar progressBar;
    private String urlString = "https://paranoiasgamers.com/?feed=rss2";

    public Noticias() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_noticias, container, false);

        initView(view);
        return view;
    }

    private void initView(View view) {
        mRecyclerView = view.findViewById(R.id.list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setHasFixedSize(true);
        mSwipeRefreshLayout = view.findViewById(R.id.container);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary, R.color.colorPrimaryDark);
        mSwipeRefreshLayout.canChildScrollUp();
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {

                mAdapter.clearData();
                mAdapter.notifyDataSetChanged();
                mSwipeRefreshLayout.setRefreshing(true);
                loadFeed();
            }
        });

        progressBar = view.findViewById(R.id.progressBar);
        if (!isNetworkAvailable()) {

            Dialog builder = new Dialog(Objects.requireNonNull(getContext()));
            builder.setContentView(R.layout.losconnection);
            ImageButton imageButton = (ImageButton) builder.findViewById(R.id.image);
            builder.show();

        } else {
            isNetworkAvailable();
            loadFeed();
        }

    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) Objects.requireNonNull(getContext()).getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


    @Override
    public void onResume() {

        super.onResume();
        if (mAdapter != null)
            mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroy() {

        super.onDestroy();
        if (mAdapter != null)
            mAdapter.clearData();
    }

    private void loadFeed() {

        if (!mSwipeRefreshLayout.isRefreshing())
            progressBar.setVisibility(View.VISIBLE);

        Parser parser = new Parser();
        parser.execute(urlString);
        parser.onFinish(new Parser.OnTaskCompleted() {
            //what to do when the parsing is done
            @Override
            public void onTaskCompleted(ArrayList<Article> list) {
                //list is an Array List with all article's information
                //set the adapter to recycler view
                mAdapter = new ArticleAdapter(list, R.layout.template_post, Objects.requireNonNull(getActivity()).getApplicationContext());
                mRecyclerView.setAdapter(mAdapter);
                progressBar.setVisibility(View.GONE);
                mSwipeRefreshLayout.setRefreshing(false);

            }

            //what to do in case of error
            @Override
            public void onError() {

                Objects.requireNonNull(getActivity()).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setVisibility(View.GONE);
                        mSwipeRefreshLayout.setRefreshing(false);
                        Dialog builder = new Dialog(Objects.requireNonNull(getContext()));
                        builder.setContentView(R.layout.errorload);
                        ImageButton imageButton = (ImageButton) builder.findViewById(R.id.image);
                        builder.show();
                    }
                });
            }
        });
    }
}
