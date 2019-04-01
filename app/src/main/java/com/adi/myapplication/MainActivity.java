package com.adi.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView play;
    MediaPlayer mediaPlayer=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = findViewById(R.id.btn_play);
        mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.faded);

        Intent intent = getIntent();
        final String message = intent.getStringExtra("message");

        if(message != null) {
            if (message.equals("play music")) {
                mediaPlayer.start();
                play.setImageResource(R.drawable.icon_pause);
            }
        }

        play.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.pause();
                        play.setImageResource(R.drawable.icon_play);
                    } else {
                        mediaPlayer.start();
                        play.setImageResource(R.drawable.icon_pause);
                    }
            }
        });
    }
}
