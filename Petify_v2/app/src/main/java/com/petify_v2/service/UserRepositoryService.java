package com.petify_v2.service;

import android.content.Context;
import android.content.Intent;

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
import com.petify_v2.view.LoginActivity;
import com.petify_v2.view.MainActivity;
import com.petify_v2.view.RegisterActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class UserRepositoryService {
    static String link="https://7085-185-44-147-32.ngrok.io";

    public static void registerUser(String username, String email, String password, Context context, IVolleyCallBackMessage volleyCallBackMessage) {
        String URL = link+"/registration";


        JsonObjectRequest request = new JsonObjectRequest
                (Request.Method.POST, URL, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            if (response.getString("result").equals("success")) {
                                volleyCallBackMessage.onSuccess("Registration Succeed", null);
                                return;
                            }
                            volleyCallBackMessage.onWarning("Email already exists");
                        } catch (JSONException e) {
                            volleyCallBackMessage.onSuccess("JSON error", null);
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
                    body.put("username",username);
                    body.put("email",email);
                    body.put("password",password);
                    return body.toString().getBytes(StandardCharsets.UTF_8);
                } catch (Exception exception) {
                    return null;
                }
            }

        };

        RequestSingleton.getInstance(context).addToRequestQueue(request);
    }
    public static void logInUser(String username, String password, Context context, IVolleyCallBackMessage volleyCallBackMessage) {
        String URL = link+"/login";

        JsonObjectRequest request = new JsonObjectRequest
                (Request.Method.POST, URL, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            if (response.getString("result").equals("success")) {
                                volleyCallBackMessage.onSuccess("Logged in successfully");
                                return;
                            }
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
                    body.put("username",username);
                    body.put("password",password);
                    return body.toString().getBytes(StandardCharsets.UTF_8);
                } catch (Exception exception) {
                    return null;
                }
            }

        };

        RequestSingleton.getInstance(context).addToRequestQueue(request);
    }

}
