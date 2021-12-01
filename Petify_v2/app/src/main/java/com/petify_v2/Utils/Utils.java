package com.petify_v2.Utils;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.UUID;

public class Utils {
    public static String generateUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
