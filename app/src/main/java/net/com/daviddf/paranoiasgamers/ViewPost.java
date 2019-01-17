package net.com.daviddf.paranoiasgamers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;

import com.google.android.material.appbar.AppBarLayout;
import com.squareup.picasso.Picasso;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import static org.jsoup.Jsoup.parse;

public class ViewPost extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener {
    private static final int PERCENTAGE_TO_SHOW_IMAGE = 20;
    String title;
    private View mFab;
    private int mMaxScrollSize;
    private boolean mIsImageHidden;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_post);
        title = getIntent().getStringExtra("Title");
        String content = getIntent().getStringExtra("Content");

        mFab = findViewById(R.id.flexible_example_fab);
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start();
            }
        });
        TextView txttitle = findViewById(R.id.posttitle);
        txttitle.setText(title);
        TextView txtcontent = findViewById(R.id.postcontent);
        Document doc = parse(content);
        StringBuilder temp = new StringBuilder();
        for (Element element : doc.select("p")) {
            temp.append(element.text()).append("\n");

        }
        txtcontent.setText(temp.toString());


        Toolbar toolbar = findViewById(R.id.flexible_example_toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();

                return;
            }
        });
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Noticias");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        AppBarLayout appbar = findViewById(R.id.flexible_example_appbar);
        appbar.addOnOffsetChangedListener(this);

        ImageView imageView = findViewById(R.id.postimage);
        Picasso.with(this)
                .load(getIntent().getStringExtra("Image"))
                .placeholder(R.drawable.placeholder)
                .fit()
                .centerCrop()
                .into(imageView);


    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        if (mMaxScrollSize == 0)
            mMaxScrollSize = appBarLayout.getTotalScrollRange();

        int currentScrollPercentage = (Math.abs(i)) * 100
                / mMaxScrollSize;

        if (currentScrollPercentage >= PERCENTAGE_TO_SHOW_IMAGE) {
            if (!mIsImageHidden) {
                mIsImageHidden = true;

                ViewCompat.animate(mFab).scaleY(0).scaleX(0).start();
            }
        }

        if (currentScrollPercentage < PERCENTAGE_TO_SHOW_IMAGE) {
            if (mIsImageHidden) {
                mIsImageHidden = false;
                ViewCompat.animate(mFab).scaleY(1).scaleX(1).start();
            }
        }
    }

    public void start() {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, getIntent().getStringExtra("Link"));
        sendIntent.setType("text/plain");
        if (sendIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(Intent.createChooser(sendIntent, "Compartir con"));
        } else {
            Toast.makeText(this, "No es posible compartir", Toast.LENGTH_SHORT).show();
        }

    }
}