package myandoid.gallery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Gallery extends AppCompatActivity {
Integer img[]={"R.","ic_launcher"};
    View gallery;
    ImageView imageView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        gallery=findViewById(R.id.gallery);
        imageView= (ImageView) findViewById(R.id.imageView);
    }
}

classs
