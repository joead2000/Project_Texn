package com.petify_v2.model;

import java.util.List;

public interface IVolleyCallBackMessage {
    void onSuccess(String message);
    void onSuccessInfo(List<Album> albums);
    void onWarning(String message);
    void onError(String message);
}
