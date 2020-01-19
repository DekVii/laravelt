package com.dekvii.LARAVELT;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.dekvii.LARAVELT.UI.AccountUI;
import com.dekvii.LARAVELT.UI.CartUI;
import com.dekvii.LARAVELT.UI.CategoryUI;
import com.dekvii.LARAVELT.UI.HighlightUI;
import com.dekvii.LARAVELT.UI.MenuUI;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    //private AppBarConfiguration mAppBarConfiguration;
    private BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        loadFragment(new MenuUI());
        bottomNavigation = findViewById(R.id.bottom_nav);
// beri listener pada saat item/menu bottomnavigation terpilih
        bottomNavigation.setOnNavigationItemSelectedListener(this);
        MenuItem menu = bottomNavigation.getMenu().getItem(0);
        menu.setChecked(true);
        onNavigationItemSelected(menu);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()){
            case R.id.nav_menu:
                fragment = new MenuUI();
                break;
            case R.id.nav_category:
                fragment = new CategoryUI();
                break;
            case R.id.nav_highlight:
                fragment = new HighlightUI();
                break;
            case R.id.nav_cart:
                fragment = new CartUI();
                break;
            case R.id.nav_account:
                fragment = new AccountUI();
                break;
        }
        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_layout, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
