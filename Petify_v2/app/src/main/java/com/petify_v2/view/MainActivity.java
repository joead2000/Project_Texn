package com.petify_v2.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


import com.petify_v2.R;
import com.petify_v2.Utils.PlayYoutubeVideos;
import com.petify_v2.model.User;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String[] items;
    Button btngotofind;
    Button btnfindalbum;
    Button openyoutubebtn;
    Button logoutbtn;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnfindalbum = findViewById(R.id.btnfindalbum);
        btnfindalbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ViewAlbumsActivity.class));
            }
        });
        btngotofind = findViewById(R.id.btngotofind);
        btngotofind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ArtistsInfo.class));
            }
        });

        openyoutubebtn = findViewById(R.id.openYoutubeFormbtn);
        openyoutubebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PlayYoutubeVideos.class));
            }
        });

        logoutbtn=findViewById(R.id.logoutbtn);
        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });




        //listView = findViewById(R.id.listViewSong);

        User user = (User) getIntent().getSerializableExtra("user");

        runtimePermission();
    }


    public void runtimePermission() {


    }


    public List<File> findSong(File file) {
        List<File> songsList = new ArrayList<>();


        File[] files = file.listFiles();
        if (files != null) {
            for (File singlefile : files) {
                if (singlefile.isDirectory() && !singlefile.isHidden()) {
                    songsList.addAll(findSong(singlefile));
                } else {
                    if (singlefile.getName().endsWith(".mp3") || singlefile.getName().endsWith(".wav")) {
                        songsList.add(singlefile);
                    }
                }
            }
        }
        return songsList;
    }

    void displaySongs() {


        // final List<File> mySongs = findSong(Environment.getExternalStorageDirectory());
        final List<File> mySongs = findSong(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC));
        items = new String[mySongs.size()];
        for (int i = 0; i < mySongs.size(); i++) {
            items[i] = mySongs.get(i).getName().toString().replace(".mp3", "").replace(".wav", "");

        }
        // ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,items);
        //listView.setAdapter(myAdapter);
        customAdapter customAdapter = new customAdapter();
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {

                String songName = (String) listView.getItemAtPosition(i);

            }
        });


    }

    class customAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return items.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View myView = getLayoutInflater().inflate(R.layout.list_item, null);
            TextView textsong = myView.findViewById(R.id.txtsongname);
            textsong.setSelected(true);

            textsong.setText(items[i]);
            return myView;
        }
    }


}


