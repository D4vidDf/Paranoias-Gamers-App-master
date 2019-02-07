package net.com.daviddf.paranoiasgamers.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import net.com.daviddf.paranoiasgamers.R;
import net.com.daviddf.paranoiasgamers.models.YoutubeCommentModel;

import java.util.ArrayList;

/**
 * Created by Suman Dey(MONSTER TECHNO) on 1/4/18.
 */

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.YoutubeCommentHolder> {

    private ArrayList<YoutubeCommentModel> dataSet;
    @SuppressLint("StaticFieldLeak")
    private static Context mContext = null;

    public CommentAdapter(Context mContext, ArrayList<YoutubeCommentModel> data) {
        this.dataSet = data;
        CommentAdapter.mContext = mContext;
    }

    @Override
    public CommentAdapter.YoutubeCommentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.youtube_comment_layout, parent, false);
        return new YoutubeCommentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull YoutubeCommentHolder holder, int position) {
        TextView textViewName = holder.textViewName;
        TextView feedback = holder.feedback;
        ImageView imageView = holder.imageViewIcon;
        YoutubeCommentModel object = dataSet.get(position);
        textViewName.setText(object.getTitle());
        feedback.setText(object.getComment());
        try {
            if (object.getThumbnail() != null) {
                if (object.getThumbnail().startsWith("http")) {
                    Picasso.with(mContext)
                            .load(object.getThumbnail())
                            .into(imageView);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    static class YoutubeCommentHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView feedback;
        ImageView imageViewIcon;

        YoutubeCommentHolder(View itemView) {
            super(itemView);
            this.textViewName =  itemView.findViewById(R.id.textViewName);
            this.imageViewIcon =  itemView.findViewById(R.id.profile_image);
            this.feedback =  itemView.findViewById(R.id.feedback);

        }

    }

}


