package com.petify_v2.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.petify_v2.R;
import com.petify_v2.model.Album;
import com.petify_v2.model.IVolleyCallBackMessage;
import com.petify_v2.model.RequestAlbumInfo;
import com.petify_v2.model.RequestArtistInfo;

import java.util.List;

public class ViewAlbumsActivity extends AppCompatActivity {
    Button btnfind2;
    EditText nameofartist;
    TextView textViewAlbum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_albums);
        btnfind2 = findViewById(R.id.btnfind2);
        nameofartist = findViewById(R.id.nameofartist);
        textViewAlbum = findViewById(R.id.textViewAlbum);


        btnfind2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!nameofartist.getText().toString().isEmpty()) {
                    RequestAlbumInfo.textViewAlbum(nameofartist.getText().toString().trim(),
                            ViewAlbumsActivity.this, new IVolleyCallBackMessage() {
                        @Override
                        public void onSuccess(String message) {


                        }

                        @Override
                        public void onSuccessInfo(List<Album> albums) {
                            for (Album album : albums) {
                                textViewAlbum.setText(textViewAlbum.getText() + album.toString());

                            }


                        }

                        @Override
                        public void onWarning(String message) {
                            Toast.makeText(ViewAlbumsActivity.this, message, Toast.LENGTH_LONG).show();

                        }

                        @Override
                        public void onError(String message) {
                            Toast.makeText(ViewAlbumsActivity.this, message, Toast.LENGTH_LONG).show();

                        }
                    });

                }
            }
        });






    }
}

















