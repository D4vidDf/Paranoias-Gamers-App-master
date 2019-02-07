package net.com.daviddf.paranoiasgamers.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.RecyclerView;

import com.prof.rssparser.Article;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import net.com.daviddf.paranoiasgamers.R;
import net.com.daviddf.paranoiasgamers.ViewPost;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * Created by odera on 2/18/2018.
 */
public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {



    WebView articleView;

    private ArrayList<Article> articles;

    private int rowLayout;

    private Context mContext;



    public ArticleAdapter(ArrayList<Article> list, int rowLayout, Context context) {



        this.articles = list;

        this.rowLayout = rowLayout;

        this.mContext = context;

    }





    @Override

    public long getItemId(int item) {

        // TODO Auto-generated method stub

        return item;

    }



    public void clearData() {

        if (articles != null)

            articles.clear();

    }



    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(rowLayout, viewGroup, false);

        return new ViewHolder(v);

    }



    public Palette createPaletteSync(Bitmap bitmap) {

        Palette p = Palette.from(bitmap).generate();

        return p;

    }





    @SuppressLint("SimpleDateFormat")
    @Override

    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int position) {



        final Article currentArticle = articles.get(position);



        Locale.setDefault(Locale.getDefault());

        Date date = currentArticle.getPubDate();

        SimpleDateFormat sdf = new SimpleDateFormat();

        sdf = new SimpleDateFormat("dd MMMM yyyy");

        final String pubDateString = sdf.format(date);



        viewHolder.title.setText(currentArticle.getTitle());



        //load the image. If the parser did not find an image in the article, it set a placeholder.

        Picasso.with(mContext)

                .load(currentArticle.getImage())
                .placeholder(R.drawable.placeholder)
                .fit()
                .into(viewHolder.image, new Callback() {

                    @Override

                    public void onSuccess() {

                        BitmapDrawable drawable;



                        drawable = (BitmapDrawable) viewHolder.image.getDrawable();

                        final Bitmap bitmap = drawable.getBitmap();







                    }



                    @Override

                    public void onError() {



                    }

                });





        viewHolder.category.setText("# " + currentArticle.getCategories().get(0));

        System.out.println(stripHtml(currentArticle.getDescription()));





        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {



            @Override

            public void onClick(View view) {



                String title = currentArticle.getTitle();

                String content = currentArticle.getContent();



                Intent intent = new Intent(mContext, ViewPost.class);

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                intent.putExtra("Title", title);

                intent.putExtra("Content", content);

                intent.putExtra("Image", currentArticle.getImage());

                intent.putExtra("Link", currentArticle.getLink());



                mContext.startActivity(intent);





            }

        });



    }



    @Override

    public int getItemCount() {



        return articles == null ? 0 : articles.size();



    }



    public String stripHtml(String html) {

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {

            return String.valueOf(Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY));

        } else {

            return String.valueOf(Html.fromHtml(html));

        }

    }



    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;



        ImageView image;

        TextView category;

        CardView card;



        public ViewHolder(View itemView) {



            super(itemView);



            title = itemView.findViewById(R.id.postTitle);



            image = itemView.findViewById(R.id.postCoverImage);

            category = itemView.findViewById(R.id.postCategory);

            card = itemView.findViewById(R.id.mylayout);



        }

    }

}