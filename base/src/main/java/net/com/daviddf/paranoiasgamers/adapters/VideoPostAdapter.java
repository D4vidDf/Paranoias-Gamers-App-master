package net.com.daviddf.paranoiasgamers.adapters;

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
import net.com.daviddf.paranoiasgamers.interfaces.OnItemClickListener;
import net.com.daviddf.paranoiasgamers.models.YoutubeDataModel;

import java.util.ArrayList;

/**
 * Created by Suman Dey(MONSTER TECHNO) on 12/18/17.
 */

public class VideoPostAdapter extends RecyclerView.Adapter<VideoPostAdapter.YoutubePostHolder> {

    private ArrayList<YoutubeDataModel> dataSet;
    private Context mContext = null;
    private final OnItemClickListener listener;


    public VideoPostAdapter(Context mContext, ArrayList<YoutubeDataModel> dataSet, OnItemClickListener listener) {
        this.dataSet = dataSet;
        this.mContext = mContext;
        this.listener = listener;

    }

    @NonNull
    @Override
    public YoutubePostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.youtube_post_layout,parent,false);
        return new YoutubePostHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull YoutubePostHolder holder, int position) {

        //set the views here
        TextView textViewTitle;
        textViewTitle = holder.textViewTitle;
        TextView textViewDes;
        textViewDes = holder.textViewDes;
        TextView textViewDate;
        textViewDate = holder.textViewDate;
        ImageView ImageThumb;
        ImageThumb = holder.ImageThumb;

        YoutubeDataModel object = dataSet.get(position);
        textViewTitle.setText(object.getTitle());
        textViewDate.setText(object.getPublishedAt());
        holder.bind(dataSet.get(position), listener);

        //TODO: image will be downloaded from url
        Picasso.with(mContext).load(object.getThumbnail()).into(ImageThumb);



    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class YoutubePostHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle;
        TextView textViewDes;
        TextView textViewDate;
        ImageView ImageThumb;

        YoutubePostHolder(View itemView) {
            super(itemView);
            this.textViewTitle   = itemView.findViewById(R.id.textViewTitle);
            this.textViewDes     = itemView.findViewById(R.id.textViewDes);
            this.textViewDate    = itemView.findViewById(R.id.textViewDate);
            this.ImageThumb      = itemView.findViewById(R.id.ImageThumb);

        }

        public void bind(final YoutubeDataModel item, final OnItemClickListener listener) {
            itemView.setOnClickListener(v -> listener.onItemClick(item));
        }
    }
}
