package net.com.daviddf.paranoiasgamers;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Informacion extends AppCompatActivity {

    private Button contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);
        Button contact = (Button) findViewById(R.id.contact);
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uritwitter = Uri.parse("http://t.me/pilarico_bot");

                Intent twitter = new Intent(Intent.ACTION_VIEW, uritwitter);

                startActivity(twitter);
            }
        });
    }
}
