package myandoid.hardware;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.VideoView;
import android.widget.MediaController;

public class hardware2 extends AppCompatActivity {

    Button btn,btn2;
    VideoView vv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hardware2);

        btn = (Button) findViewById(R.id.button);
        btn2= (Button) findViewById(R.id.button2);
        vv= (VideoView) findViewById(R.id.videoView);

        vv.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.as));//for video put in raw folder only
        vv.start();//there is no need for pause or sart button it will come default with method

        MediaController mediaController=new MediaController(this);//for media controller
        vv.setMediaController(mediaController);
    }
}
