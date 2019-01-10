package net.com.daviddf.paranoiasgamers;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //id
        CardView amigos = (CardView) findViewById(R.id.amigos);
        CardView donaciones = (CardView) findViewById(R.id.donaciones);
        CardView twitter = (CardView) findViewById(R.id.witter);
        CardView facebook = (CardView) findViewById(R.id.facebook);
        CardView telegram = (CardView) findViewById(R.id.telegram);
        CardView instagram = (CardView) findViewById(R.id.instagram);
        CardView web = (CardView) findViewById(R.id.web);
        CardView chat = (CardView) findViewById(R.id.chat);
        CardView apps = (CardView) findViewById(R.id.apps);
        CardView info = (CardView) findViewById(R.id.informacion);

        //acciones
        amigos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri amigos = Uri.parse("https://foro.paranoiasgamers.com");

                Intent amigoss = new Intent(Intent.ACTION_VIEW, amigos);

                startActivity(amigoss);
            }
        });
        donaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 final Dialog builder = new Dialog(menu.this);
                builder.setContentView(R.layout.popup);
                TextView title = (TextView) builder.findViewById(R.id.title);
                ImageButton imageButton = (ImageButton) builder.findViewById(R.id.image);
                builder.show();
                Button clickButton = (Button) builder.findViewById(R.id.buyButtondon);
                clickButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Uri donar = Uri.parse("https://paypal.me/DavidDominguezfondo");

                        Intent donador = new Intent(Intent.ACTION_VIEW, donar);

                        startActivity(donador);
                    }
                });

            }

        });
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uritwitter = Uri.parse("https://twitter.com/ParanoiasGamers");

                Intent twitter = new Intent(Intent.ACTION_VIEW, uritwitter);

                startActivity(twitter);

            }
        });
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri urifacebook = Uri.parse("https://www.facebook.com/paranoiasgamersyt/\n");

                Intent facebook = new Intent(Intent.ACTION_VIEW, urifacebook);

                startActivity(facebook);

            }
        });
        telegram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uritelegram = Uri.parse("https://t.me/paranoiasgamers");

                Intent telegram = new Intent(Intent.ACTION_VIEW, uritelegram);

                startActivity(telegram);

            }
        });
        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uriinstagram = Uri.parse("https://www.instagram.com/paranoiasgamers/");

                Intent instagram = new Intent(Intent.ACTION_VIEW, uriinstagram);

                startActivity(instagram);

            }
        });
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uriweb = Uri.parse("https://paranoiasgamers.com");

                Intent web = new Intent(Intent.ACTION_VIEW, uriweb);

                startActivity(web);

            }
        });
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        apps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uriapps = Uri.parse("https://aplicacion.paranoiasgamers.com");

                Intent apps = new Intent(Intent.ACTION_VIEW, uriapps);

                startActivity(apps);

            }
        });
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(menu.this, Informacion.class));
            }
        });

    }




}