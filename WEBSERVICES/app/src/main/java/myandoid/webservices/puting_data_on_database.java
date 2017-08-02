package myandoid.webservices;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class puting_data_on_database extends AppCompatActivity {

    Button btn;
    EditText editText;

    RequestQueue requestQueue;
    String url = "http://akashsengar.coolpage.biz/connect.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puting_data_on_database);
        requestQueue = Volley.newRequestQueue(this);


        btn= (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.editText);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                final String s = editText.getText().toString();//puting edittext data in s


                StringRequest stringRequest = new StringRequest(Request.Method.POST,url, new Response.Listener<String>() {//method post is used
                    @Override
                    public void onResponse(String s) {

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText(puting_data_on_database.this, "" + volleyError, Toast.LENGTH_LONG).show();
                    }
                })
                //all above is parameter passiing
                //in this this mehod is called
                {

                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {//get params is important

                        Map<String, String> myparams = new HashMap<String, String>();//this si line used to create a object to put the data in the coloumn
                        myparams.put("username", s);//username is coloumn name and s is the key

                        return myparams;

                    }

                };

                requestQueue.add(stringRequest);//request is added


            }

        });
    }
}