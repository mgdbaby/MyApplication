package com.example.myapplication.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.myapplication.R;

public class ToolbarActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private ActionBarDrawerToggle drawerToggle;
    private ShareActionProvider mShareActionProvider;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawerlayout);

        initViews();
//            @Override
//            public void onDrawerSlide(View drawerView, float slideOffset) {
////                WindowManager windowManager= (WindowManager) getSystemService(getApplicationContext().WINDOW_SERVICE);
////                Display display=windowManager.getDefaultDisplay();
////                linearLayout.layout(mNavigationView.getRight(), 0, display.getWidth()+mNavigationView.getRight(), display.getHeight());
////                super.onDrawerSlide(drawerView, slideOffset);
//            }
    }

    private void initViews(){
        //设置Toolbar 的相关操作
        toolbar = (Toolbar) findViewById(R.id.id_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_settings:
                        Toast.makeText(ToolbarActivity.this, "action_settings", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_share:
                        Toast.makeText(ToolbarActivity.this, "action_share", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

        mDrawerLayout = (DrawerLayout) findViewById(R.id.id_drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.id_nv_menu);
        final RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.content_relative);
        drawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.open, R.string.close){
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                WindowManager windowManager= (WindowManager) getSystemService(getApplicationContext().WINDOW_SERVICE);
                Display display=windowManager.getDefaultDisplay();
                relativeLayout.layout(mNavigationView.getRight(), 0, display.getWidth()+mNavigationView.getRight(), display.getHeight());
                super.onDrawerSlide(drawerView, slideOffset);
            }
        };
//        drawerToggle.syncState();
        mDrawerLayout.setDrawerListener(drawerToggle);

        mNavigationView = (NavigationView) findViewById(R.id.id_nv_menu);
        setupDrawerContent(mNavigationView);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            private MenuItem mPreMenuItem;

            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                if (mPreMenuItem != null) mPreMenuItem.setChecked(false);
                menuItem.setChecked(true);
                mDrawerLayout.closeDrawers();
                mPreMenuItem = menuItem;
                return true;
            }
        });
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
            new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(MenuItem menuItem) {
                    menuItem.setChecked(true);
                    mDrawerLayout.closeDrawers();
                    return true;
                }
            });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menu.findItem(R.id.action_share));
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/*");
        mShareActionProvider.setShareIntent(intent);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        if (item.getItemId() == android.R.id.home) {
//            mDrawerLayout.openDrawer(GravityCompat.START);
//            return true;
//        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }
}
