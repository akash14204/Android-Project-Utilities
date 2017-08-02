package myandoid.api_2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Featch_object_from_json_google_api extends AppCompatActivity {


    //Request Queue refrence
    RequestQueue requestQueue;
    //url known as API where is adatabase is available
    String url="https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=28.5806201,77.3150729&radius=500&types=restaurant&sensor=false&key=AIzaSyBYim7RY_8oUxXfBxnJCb0jjgPCDrFr790";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_featch_object_from_json_google_api);

        //:(
        requestQueue = Volley.newRequestQueue(this);

        //making object of JsonObjectRequest and passing url,listner,error
        //why jsonobject ? it is because the JSON file is started with json object({)
           JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(url,null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                try {
                    JSONArray jsonArray= jsonObject.getJSONArray("results");//results is  array in JSONFILE OF API which u want to access and put in jsonarray
                    //loop is used get all name object
                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject object=jsonArray.getJSONObject(i);//now in results ,object is present now acces that,if string will be start from json array then no need of this
                        String name=object.getString("name");//come out string
                        Toast.makeText(Featch_object_from_json_google_api.this,""+name,Toast.LENGTH_SHORT).show();//put in toast
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
               @Override
               public void onErrorResponse(VolleyError volleyError) {//for volley error
                   Toast.makeText(Featch_object_from_json_google_api.this,""+volleyError,Toast.LENGTH_SHORT).show();
               }
           });
        requestQueue.add(jsonObjectRequest);//as object is main start so pass it
    }


}

