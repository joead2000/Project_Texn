package com.petify_v2.controller;

import android.content.Context;

import com.petify_v2.model.IVolleyCallBackMessage;
import com.petify_v2.service.UserRepositoryService;

public class UserController {
    public static void registerUser(String username, String email, String password, Context context, IVolleyCallBackMessage iVolleyCallBackMessage){
        UserRepositoryService.registerUser(username,email,password,context,iVolleyCallBackMessage);
    }
}
