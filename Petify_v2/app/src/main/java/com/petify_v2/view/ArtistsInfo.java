package com.petify_v2.view;

import androidx.appcompat.app.AppCompatActivity;

//
//import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.petify_v2.R;
import com.petify_v2.model.Album;
import com.petify_v2.model.IVolleyCallBackMessage;
import com.petify_v2.model.RequestArtistInfo;
//
import java.util.List;
//
public class ArtistsInfo extends AppCompatActivity {


    Button btnfind1;
    EditText artistname;
    TextView artistInfo;
    ImageView artistImage;
//
//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artists_info);
//
        btnfind1 = findViewById(R.id.btnfind1);
//
       artistname=findViewById(R.id.editTextArtist);
       artistInfo=findViewById(R.id.artistInfo);
       artistImage = findViewById(R.id.imageView);



        btnfind1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!artistname.getText().toString().isEmpty()) {
                   RequestArtistInfo.textViewAlbum(artistname.getText().toString().trim(),
                           ArtistsInfo.this, new IVolleyCallBackMessage() {

                        @Override
                        public void onSuccess(String message, Object obj) {
                            Bitmap img = null;
                            if (obj instanceof Bitmap) {
                                img = (Bitmap)obj;
                            }

                            if (img != null)
                                artistImage.setImageBitmap(img);

                            artistInfo.setText(message);
                            //Toast.makeText(ArtistsInfo.this, message, Toast.LENGTH_LONG).show();

                        }

                        @Override
                        public void onSuccessInfo(List<Album> albums) {

                        }

                        @Override
                        public void onWarning(String message) {
                            Toast.makeText(ArtistsInfo.this, message, Toast.LENGTH_LONG).show();

                        }

                        @Override
                        public void onError(String message) {
                            Toast.makeText(ArtistsInfo.this, message, Toast.LENGTH_LONG).show();

                        }
                    });

                }
            }
        });






    }
}