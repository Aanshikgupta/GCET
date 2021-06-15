package com.example.gcet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.gcet.UI.About.AboutFragment;
import com.example.gcet.UI.Ebooks.EbooksFragment;
import com.example.gcet.UI.Faculty.FacultyFragment;
import com.example.gcet.UI.Gallery.GalleryFragment;
import com.example.gcet.UI.Home.HomeFragment;
import com.example.gcet.UI.News.NewsFragment;
import com.example.gcet.UI.Notice.NoticeFragment;
import com.example.gcet.UI.Result.ResultFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.navigation.NavigationView;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, NavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView bottomNavigationView;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setItemIconTintList(null);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.start, R.string.close);
        actionBarDrawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();


        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new HomeFragment()).commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull @org.jetbrains.annotations.NotNull MenuItem item) {
        Intent intent = null;
        switch (item.getItemId()) {
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new HomeFragment()).commit();
                break;
            case R.id.notices:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new NoticeFragment()).commit();
                break;
            case R.id.faculty:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new FacultyFragment()).commit();
                break;
            case R.id.gallery:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new GalleryFragment()).commit();
                break;
            case R.id.developer:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new AboutFragment()).commit();
                break;
            case R.id.academicCalendar:
                break;
            case R.id.ebooks:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new EbooksFragment()).commit();
                break;
            case R.id.results:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new ResultFragment()).commit();
                break;
            case R.id.emailUs:
                intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto:"));
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"admissions@galgotiacollege.edu"});
                startActivity(intent);
                break;
            case R.id.website:
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://galgotiacollege.edu/"));
                startActivity(intent);
                break;
            case R.id.news:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new NewsFragment()).commit();
                break;

        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}