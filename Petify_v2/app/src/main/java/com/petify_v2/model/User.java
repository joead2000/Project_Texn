package com.petify_v2.model;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    private final String username;
    private final String email;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    protected User(Parcel in) {
        username = in.readString();
        email = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(username);
        dest.writeString(email);
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}

