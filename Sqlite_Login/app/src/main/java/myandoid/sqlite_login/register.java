package myandoid.sqlite_login;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class register extends AppCompatActivity {
    EditText editText,editText2,editText3;
    Button button;
    SQLiteDatabase sqLiteDatabase;
    ListView listView;
    ArrayList arrayList=new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        editText= (EditText) findViewById(R.id.editText);
        editText2= (EditText) findViewById(R.id.editText2);
        editText3= (EditText) findViewById(R.id.editText3);

        listView= (ListView) findViewById(R.id.listView);
        button= (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//getting edit box data
                String name=editText.getText().toString();
                String pass=editText2.getText().toString();
                String phone=editText3.getText().toString();


                    sqLiteDatabase=openOrCreateDatabase("CD",MODE_PRIVATE,null);
                    sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS form(name VARCHAR,password VARCHAR,phone VARCHAR)");
                    sqLiteDatabase.execSQL("INSERT INTO form(name,password,phone) VALUES ('"+name+"','"+pass+"','"+phone+"')");
                    Toast.makeText(register.this,"Registration successful",Toast.LENGTH_LONG).show();

                Cursor cursor=sqLiteDatabase.rawQuery("SELECT * FROM form",null);
                //use this only for shown purpose
                while ((cursor.moveToNext())){
                    String data=cursor.getString(0);
                    arrayList.add(data);//putting data in arraylist
                }

                ArrayAdapter<String> ad=new ArrayAdapter<>(register.this,android.R.layout.simple_list_item_1,arrayList);//arraylist is
                //passed to put data into array adapter which is in arraylist
                listView.setAdapter(ad);//and now data is set into listview
            }
        });
    }

}
