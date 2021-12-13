package com.petify_v2.model;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.petify_v2.model.Album;
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
        String URL = "https://7b9f-2-85-54-248.ngrok.io/artistAlbums";
        System.out.println(URL);

        JsonObjectRequest request = new JsonObjectRequest
                (Request.Method.POST, URL, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            List<Album> albums = new ArrayList<>();
                            for (int i = 0; i < response.getJSONArray("artist").length(); i++) {
                                String title = response.getJSONArray("artist").getJSONObject(i).getString("strAlbum");
                                String year = response.getJSONArray("artist").getJSONObject(i).getString("intYearReleased");
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
                }){

            @Override
            public Map<String, String> getHeaders() {
                HashMap<String, String> headers = new HashMap<>();
                headers.put("Content-Type", "application/json");
                return headers;
            }


            @Override
            public byte[] getBody() {
                try {
                    JSONObject body = new JSONObject();
                    body.put("artist",artist);
                    return body.toString().getBytes(StandardCharsets.UTF_8);
                } catch (Exception exception) {
                    return null;
                }
            }

        };

        RequestSingleton.getInstance(context).addToRequestQueue(request);
    }

}