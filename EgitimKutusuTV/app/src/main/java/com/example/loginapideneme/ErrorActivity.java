package com.example.loginapideneme;

// java/com.example.loginapideneme/ErrorActivity.java

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ErrorActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error);

        TextView textViewErrorMessage = findViewById(R.id.textViewErrorMessage);
        Button buttonRetry = findViewById(R.id.buttonRetry);

        // Get the error message from the intent extras
        String errorMessage = getIntent().getStringExtra("error_message");
        if (errorMessage != null) {
            textViewErrorMessage.setText(errorMessage);
        }

        // Set a click listener for the retry button
        {
            buttonRetry.setOnClickListener(v -> {
                // Handle the retry action (e.g., go back to the login screen)
                finish(); // This will close the ErrorActivity and return to the LoginActivity
            });

        }
    }
}
