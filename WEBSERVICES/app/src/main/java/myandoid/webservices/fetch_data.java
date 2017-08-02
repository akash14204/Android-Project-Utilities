package myandoid.webservices;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class fetch_data extends AppCompatActivity {


    ListView listView;
    RequestQueue requestQueue;
    String url="http://akashsengar.coolpage.biz/fetch.php";
;    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_data);

        listView= (ListView) findViewById(R.id.listView);

        requestQueue= Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {
                ArrayList myarray=new ArrayList();
                for (int i = 0; i < jsonArray.length(); i++) {
                    try {
                        JSONObject obj = jsonArray.getJSONObject(i);
                        String s = obj.getString("username");
                        myarray.add(s);
                        ArrayAdapter<String> ad=new ArrayAdapter<String>(fetch_data.this,android.R.layout.simple_list_item_1,myarray);
                        listView.setAdapter(ad);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(fetch_data.this, "" + volleyError, Toast.LENGTH_LONG).show();
            }
        });
        requestQueue.add(jsonArrayRequest);


    }
}
