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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RequestAlbumInfo {

    public static void textViewAlbum(String artist, Context context, IVolleyCallBackMessage volleyCallBackMessage) {
        String URL = "https://theaudiodb.com/api/v1/json/2/discography.php?s="+artist;
        System.out.println(URL);


        JsonObjectRequest request = new JsonObjectRequest
                (Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            List<Album> albums = new ArrayList<>();
                            for (int i = 0; i < response.getJSONArray("album").length(); i++) {
                                String title = response.getJSONArray("album").getJSONObject(i).getString("strAlbum");
                                String year = response.getJSONArray("album").getJSONObject(i).getString("intYearReleased");
                                albums.add(new Album(title,year));


                            }
                            volleyCallBackMessage.onSuccessInfo(albums);





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