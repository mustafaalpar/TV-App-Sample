package com.example.loginapideneme;

import android.os.Bundle;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import androidx.fragment.app.FragmentActivity;

/*
 * Main Activity class that loads {@link MainFragment}.
 */
public class MainActivity extends FragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://egitimkutusu.com/") // Base URL of the API
                .addConverterFactory(GsonConverterFactory.create()) // Use GSON for JSON parsing
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_browse_fragment, new MainFragment())
                    .commitNow();
        }
    }
}