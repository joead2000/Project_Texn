package com.petify_v2.mappers;

import android.util.Log;

import com.petify_v2.exceptions.InvalidArgumentException;
import com.petify_v2.model.Album;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonAlbumMapper {
    public static Album toAlbum(JSONObject jsonObject) throws InvalidArgumentException {
        try {

            String title = jsonObject.getString("strAlbum");
            String year = jsonObject.getString("intYearReleased");
            return new Album(title, year);

        } catch (JSONException e) {
            Log.e("JSONException ", e.getLocalizedMessage());
            throw new InvalidArgumentException("ERR-0021: Unable to retrieve data from server");
        }
    }
    public static List<Album> toAlbums(JSONObject jsonObject) throws InvalidArgumentException {
        try {
            JSONArray artists = jsonObject.getJSONArray("artist");
            List<Album> albumList = new ArrayList<>();

            for (int i = 0; i < artists.length(); i++) {
                Album album = JsonAlbumMapper.toAlbum(artists.getJSONObject(i));
                albumList.add(album);
            }
            return albumList;
        }  catch (JSONException e) {
            Log.e("JSONException ", e.getLocalizedMessage());
            throw new InvalidArgumentException("ERR-0020: Unable to retrieve data from server");
        }
    }
}
