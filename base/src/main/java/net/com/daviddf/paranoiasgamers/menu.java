package net.com.daviddf.paranoiasgamers;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.cardview.widget.CardView;

import net.com.daviddf.paranoiasgamers.chat.main.LoginActivity;

import saschpe.android.customtabs.CustomTabsHelper;
import saschpe.android.customtabs.WebViewFallback;

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
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                builder.addDefaultShareMenuItem();
                builder.setToolbarColor(getColor(R.color.colorPrimary));
                builder.setShowTitle(true);
                CustomTabsIntent customTabsIntent = builder.build();

// This is optional but recommended
                CustomTabsHelper.addKeepAliveExtra(menu.this, customTabsIntent.intent);

// This is where the magic happens...
                CustomTabsHelper.openCustomTab(menu.this, customTabsIntent,
                        Uri.parse("https://foro.paranoiasgamers.com"),
                        new WebViewFallback());
            }
        });
        donaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog builderd = new Dialog(menu.this);
                builderd.setContentView(R.layout.popup);
                TextView title = (TextView) builderd.findViewById(R.id.title);
                ImageButton imageButton = (ImageButton) builderd.findViewById(R.id.image);
                builderd.show();
                Button clickButton = (Button) builderd.findViewById(R.id.buyButtondon);
                clickButton.setOnClickListener(new View.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.M)
                    @Override
                    public void onClick(View v) {
                        builderd.hide();
                        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                        builder.addDefaultShareMenuItem();
                        builder.setToolbarColor(getColor(R.color.colorPrimary));
                        builder.setShowTitle(true);
                        CustomTabsIntent customTabsIntent = builder.build();

// This is optional but recommended
                        CustomTabsHelper.addKeepAliveExtra(menu.this, customTabsIntent.intent);

// This is where the magic happens...
                        CustomTabsHelper.openCustomTab(menu.this, customTabsIntent,
                                Uri.parse("https://paypal.me/DavidDominguezfondo"),
                                new WebViewFallback());
                    }
                });

            }

        });
        twitter.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                builder.addDefaultShareMenuItem();
                builder.setToolbarColor(getColor(R.color.colorPrimary));
                builder.setShowTitle(true);
                CustomTabsIntent customTabsIntent = builder.build();

// This is optional but recommended
                CustomTabsHelper.addKeepAliveExtra(menu.this, customTabsIntent.intent);

// This is where the magic happens...
                CustomTabsHelper.openCustomTab(menu.this, customTabsIntent,
                        Uri.parse("https://twitter.com/ParanoiasGamers"),
                        new WebViewFallback());

            }
        });
        facebook.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                builder.addDefaultShareMenuItem();
                builder.setToolbarColor(getColor(R.color.colorPrimary));
                builder.setShowTitle(true);
                CustomTabsIntent customTabsIntent = builder.build();

// This is optional but recommended
                CustomTabsHelper.addKeepAliveExtra(menu.this, customTabsIntent.intent);

// This is where the magic happens...
                CustomTabsHelper.openCustomTab(menu.this, customTabsIntent,
                        Uri.parse("https://facebook.com/paranoiasgamersyt"),
                        new WebViewFallback());

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
            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                builder.addDefaultShareMenuItem();
                builder.setToolbarColor(getColor(R.color.colorPrimary));
                builder.setShowTitle(true);
                CustomTabsIntent customTabsIntent = builder.build();

// This is optional but recommended
                CustomTabsHelper.addKeepAliveExtra(menu.this, customTabsIntent.intent);

// This is where the magic happens...
                CustomTabsHelper.openCustomTab(menu.this, customTabsIntent,
                        Uri.parse("https://paranoiasgamers.com"),
                        new WebViewFallback());
            }
        });
        chat.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        final Dialog builder = new Dialog(menu.this);
                                        builder.setContentView(R.layout.chatpop);
                                        builder.show();
                                        Button chat = (Button) builder.findViewById(R.id.button_entrar_chat);
                                        chat.setOnClickListener(new View.OnClickListener() {

                                            @Override
                                            public void onClick(View v) {
                                                builder.hide();
                                                startActivity(new Intent(menu.this,LoginActivity.class));

                                            }
                                        });
                                    }
                                }
        );
        apps.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                builder.addDefaultShareMenuItem();
                builder.setToolbarColor(getColor(R.color.colorPrimary));
                builder.setShowTitle(true);
                CustomTabsIntent customTabsIntent = builder.build();

// This is optional but recommended
                CustomTabsHelper.addKeepAliveExtra(menu.this, customTabsIntent.intent);

// This is where the magic happens...
                CustomTabsHelper.openCustomTab(menu.this, customTabsIntent,
                        Uri.parse("https://aplicacion.paranoiasgamers.com"),
                        new WebViewFallback());

            }
        });
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(menu.this, Informacion.class));
            }
        });

        // ATTENTION: This was auto-generated to handle app links.
        Intent appLinkIntent = getIntent();
        String appLinkAction = appLinkIntent.getAction();
        Uri appLinkData = appLinkIntent.getData();
    }




}