package com.example.loginapideneme;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.leanback.app.BrowseSupportFragment;

public class LeanbackLauncherActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leanback_launcher);

        if (savedInstanceState == null) {
            BrowseSupportFragment fragment = new BrowseSupportFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(android.R.id.content, fragment)
                    .commit();
        }
    }
}

