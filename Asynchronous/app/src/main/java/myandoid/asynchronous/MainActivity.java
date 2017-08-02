package myandoid.asynchronous;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView txt1,txt2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         txt1= (TextView) findViewById(R.id.textView);
        txt2= (TextView) findViewById(R.id.textView3);
        new Myasyntask().execute();
    }

    public  class Myasyntask extends AsyncTask<String,String,String>{


        @Override
        protected String doInBackground(String... params) {
            for(int i=0; i<=10000000;i++){
            }
            return null;
        }

        @Override
        public void onPreExecute(){
            txt1.setText("yo yoy yoy yo");
            Toast.makeText(MainActivity.this,"jsfjdsfs",Toast.LENGTH_LONG).show();
            super.onPreExecute();

        }
        @Override
        public void onPostExecute(String s){
            txt1.setText("no nno non no");
            Toast.makeText(MainActivity.this,"akash",Toast.LENGTH_LONG).show();
            super.onPostExecute(s);

        }
    }
}
