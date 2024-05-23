package com.example.loginapideneme;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Find the login button
        Button btnLogin = findViewById(R.id.btnLogin);

        // Add a click listener to the login button
        btnLogin.setOnClickListener(v -> handleLogin());
    }

    private void handleLogin() {
        // Get the username and password from EditText fields
        EditText etUsername = findViewById(R.id.etUsername);
        EditText etPassword = findViewById(R.id.etPassword);

        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        // Check if username and password are not empty
        if (username.isEmpty() || password.isEmpty()) {
            // Display an error message to the user
            Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show();
            return;
        }

        ApiService apiService = ApiClient.getApiService();
        Call<LoginResponse> call = apiService.login(username, password, "*enter token here*");

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(@NonNull Call<LoginResponse> call, @NonNull Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    LoginResponse loginResponse = response.body();
                    if (loginResponse != null && loginResponse.isSuccess()) {
                        try {
                            if (response.body() != null) {
                                JSONObject jsonResponse = new JSONObject(response.body().toString());
                                int status = jsonResponse.getInt("status");
                                if (status == 200) {
                                    JSONArray contentArray = jsonResponse.getJSONArray("content");
                                    if (contentArray.length() > 0) {
                                        JSONObject userObject = contentArray.getJSONObject(0);
                                        String userName = userObject.getString("user_name");
                                        // Display the username as a Toast message
                                        Toast.makeText(LoginActivity.this, "Welcome, " + userName, Toast.LENGTH_SHORT).show();
                                    }
                                } else {
                                    // Display an error message
                                    String errorMessage = jsonResponse.optString("error_message", "An error occurred");
                                    Toast.makeText(LoginActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                // Handle the case where response.body() is null
                                Toast.makeText(LoginActivity.this, "Response body is null", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(LoginActivity.this, "JSON parsing error", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        // Login failed, display an error message
                        Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // API call failed, display an error message
                    Toast.makeText(LoginActivity.this, "API request failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<LoginResponse> call, @NonNull Throwable t) {
                // Handle network or other errors
                Toast.makeText(LoginActivity.this, "Network error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
