package myandoid.api;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;

public class Image_fetch_from_server extends AppCompatActivity {

    RequestQueue requestQueue;
    String url="http://olbe.in/image/1.jpg";
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_fetch_from_server);

        requestQueue= Volley.newRequestQueue(this);

        imageView= (ImageView) findViewById(R.id.imageView);
        ImageRequest imageRequest=new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap bitmap) {


                imageView.setImageBitmap(bitmap);

            }
        }, 500, 500, Bitmap.Config.ARGB_8888, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(Image_fetch_from_server.this, "" + volleyError, Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(imageRequest);//adding request
    }
}
