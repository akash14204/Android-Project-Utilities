package myandoid.shareddatabase;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn,btn2;
    EditText editText;
    EditText editText2;
    SharedPreferences sharedPreferences;
   // SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText= (EditText) findViewById(R.id.editText);
        editText2= (EditText) findViewById(R.id.editText2);
        btn= (Button) findViewById(R.id.button);
        btn2= (Button) findViewById(R.id.button2);

       sharedPreferences=getSharedPreferences("DuacteDATABASE",MODE_PRIVATE);//database created

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s=editText.getText().toString();
                String s1=editText.getText().toString();

                //sqLiteDatabase=openOrCreateDatabase("sqldatabase",MODE_PRIVATE,null);
                 //last paarmeter is CURSOR which is act like pointer
                //and it point where data should store ,so it should be move to store data otherwise data is override
                //this is  diffrence between Sharedadtabase and sqlite databse
                //and this is bidefault  and pass here null
                //cursur not used in insert delete and update
                //for read cursur is used method.because we have to point out which data should read

                //now dataabse created
                //now create table
                //start query
               // sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS studenttable(Name VARCHAR,Age VARCHAR)");
                //now insert
                //start querry
               // sqLiteDatabase.execSQL("INSERT INTO studenttable(name,age) VALUES('"+s+"','"+s1+"')");
                //to open sqlite server


                //download sqlite browser
                //otherwise for check put read method


                //make database editable ..without it database cant creatd
                  SharedPreferences.Editor se=sharedPreferences.edit();//now editable
                  se.putString("k", s);
                  se.commit();
                //if u want to see where database submit .1.go to tools,2.go android,3.search AndroidMoniter4.go to file explorer
                //5.go to data then data then package then shared prefrence then it will show database name
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Toast.makeText(MainActivity.this, "" + sharedPreferences.getString("k", ""), Toast.LENGTH_LONG).show();
            }
        });

    }
}
