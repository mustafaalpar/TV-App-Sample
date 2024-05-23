package com.example.loginapideneme;

import com.google.gson.annotations.SerializedName;

public class UserResponse {

    @SerializedName("user_id")
    private String userId;

    @SerializedName("user_name")
    private String userName;

    @SerializedName("user_surname")
    private String userSurname;

    @SerializedName("user_email")
    private String userEmail;

    @SerializedName("user_phone")
    private String userPhone;

    @SerializedName("user_ip")
    private String userIp;

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public String getUserIp() { return userIp; }
}
