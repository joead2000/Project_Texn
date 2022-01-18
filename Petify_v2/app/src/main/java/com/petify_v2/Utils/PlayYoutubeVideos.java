package com.petify_v2.Utils;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.petify_v2.R;

public class PlayYoutubeVideos extends AppCompatActivity {
    Button searchButton;
    EditText videoTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_youtube_videos);

        searchButton = findViewById(R.id.searchButton);
        videoTitle = findViewById(R.id.videoTitle);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                    String videotitle = videoTitle.getText().toString().trim();
                if (videotitle.isEmpty()) {
                    Toast.makeText(PlayYoutubeVideos.this, "Please write something for search!",
                            Toast.LENGTH_LONG).show();

                } else {
                    Intent intent = new Intent(Intent.ACTION_SEARCH);
                    intent.setPackage("com.google.android.youtube");
                    intent.putExtra("query", videotitle);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);

                }
            }
        });


    }
}