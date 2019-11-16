package com.example.careconnect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class sidenavigation extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
private DrawerLayout drawerLayout;//this is for the whole drawerlayout
private ActionBarDrawerToggle drawerToggle;//for item present in the drawer
//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sidenavigation);
        drawerLayout=(DrawerLayout)findViewById(R.id.sidedrawer);
        drawerToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      NavigationView navigationView=(NavigationView)findViewById(R.id.navigate);
      navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(drawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);

    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
       int id=menuItem.getItemId();
       if(id==R.id.profile)
       {
           Intent intent=new Intent(sidenavigation.this,loginactivity.class);
           startActivity(intent);
           Toast.makeText(sidenavigation.this,"profile is clicked",Toast.LENGTH_SHORT).show();
       }

        return false;
    }
}
