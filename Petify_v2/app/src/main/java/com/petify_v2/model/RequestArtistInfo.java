package com.petify_v2.model;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.petify_v2.R;
import com.petify_v2.model.IVolleyCallBackMessage;
import com.petify_v2.model.RequestSingleton;

import org.json.JSONException;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;


public class RequestArtistInfo {

    public static void artistInfo(String artist, Context context, IVolleyCallBackMessage volleyCallBackMessage) {
        String URL = "https://www.theaudiodb.com/api/v1/json/2/search.php?s="+artist;
        System.out.println(URL);


        JsonObjectRequest request = new JsonObjectRequest
                (Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            volleyCallBackMessage.onSuccess(response.getJSONArray("artists").getJSONObject(0).getString("strBiographyEN"));
                        } catch (JSONException e) {
                            volleyCallBackMessage.onSuccess("JSON error");
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        volleyCallBackMessage.onWarning("Connection Error");
                    }
                });

        RequestSingleton.getInstance(context).addToRequestQueue(request);
    }

}
