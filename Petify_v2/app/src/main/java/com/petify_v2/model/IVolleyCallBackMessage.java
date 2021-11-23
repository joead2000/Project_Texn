package com.petify_v2.model;

public interface IVolleyCallBackMessage {
    void onSuccess(String message);
    void onWarning(String message);
    void onError(String message);
}
