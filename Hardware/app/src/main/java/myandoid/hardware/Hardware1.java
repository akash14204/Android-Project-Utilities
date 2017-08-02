package myandoid.hardware;

import android.app.WallpaperManager;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class Hardware1 extends AppCompatActivity implements View.OnClickListener {

    Button btn, btn2, btn3,btn4,btn5,btn6,btn7;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hardware1);

        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(this);

        btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(this);

        btn3 = (Button) findViewById(R.id.button3);
        btn3.setOnClickListener(this);

        btn4 = (Button) findViewById(R.id.button4);//for mp3 play button
        btn4.setOnClickListener(this);

        btn5 = (Button) findViewById(R.id.button5);//for mp3 pause button
        btn5.setOnClickListener(this);

        mp=MediaPlayer.create(Hardware1.this,R.raw.as);//for context and path of song pass

        btn6 = (Button) findViewById(R.id.button8);
        btn6.setOnClickListener(this);

        btn7 = (Button) findViewById(R.id.button7);
        btn7.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {

        if (v == btn) {
            WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());

             try {
                wallpaperManager.setResource(R.raw.ic_launcher);
             } catch (IOException e) {
                e.printStackTrace();
             }
        }
        else if(v==btn2){
            Intent i=new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
            startActivity(i);
        } else if(v==btn3){
            Intent i=new Intent(MediaStore.Audio.Media.RECORD_SOUND_ACTION);
            startActivity(i);
        } else if(v==btn4){
            mp.start();
        } else if(v==btn5){
            mp.pause();
        } else if(v==btn6){
            Intent i=new Intent(Hardware1.this,hardware2.class);
            startActivity(i);
        }
        else if(v==btn7){
            Intent i2=new Intent(Hardware1.this,messaging.class);
            startActivity(i2);
        }



    }

}


