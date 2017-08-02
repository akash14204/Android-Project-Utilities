package myandoid.api;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class String_Fetch extends AppCompatActivity {

    RequestQueue requestQueue;//making  refrence
    TextView textView;

    //url which also named as api
    String url="https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=28.5806201,77.3150729&radius=500&types=restaurant&sensor=false&key=AIzaSyBYim7RY_8oUxXfBxnJCb0jjgPCDrFr790";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_string__fetch);

        textView= (TextView) findViewById(R.id.textView);

        requestQueue= Volley.newRequestQueue(this);


        StringRequest stringRequest=new StringRequest(url, new Response.Listener<String>() {//Responce listner
            @Override
            public void onResponse(String s) {
                textView.setText(""+s);
            }
        }, new Response.ErrorListener() {//Error listner
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(String_Fetch.this,""+volleyError,Toast.LENGTH_SHORT).show();
            }
        });

       requestQueue.add(stringRequest);//adding request
    }
}
