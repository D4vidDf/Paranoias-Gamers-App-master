package net.com.daviddf.paranoiasgamers;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import net.com.daviddf.paranoiasgamers.fragments.ChannelFragment;
import net.com.daviddf.paranoiasgamers.fragments.Noticias;
import net.com.daviddf.paranoiasgamers.fragments.instagram;
import net.com.daviddf.paranoiasgamers.fragments.twitter;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemReselectedListener, BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragment(new Noticias());
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.navigation_noticias:
                fragment = new Noticias();
                break;

            case R.id.navigation_youtube:
                fragment = new ChannelFragment();
                break;

            case R.id.navigation_twitter:
                fragment = new twitter();
                break;

            case R.id.navigation_instagram:
                fragment = new instagram();
                break;
            case R.id.navigation_menu:
                startActivity(new Intent(this, menu.class));
                break;
        }

        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    public void onNavigationItemReselected(@NonNull MenuItem menuItem) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

}

