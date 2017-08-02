package myandoid.sqlite_login;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    Button button;
    EditText editText4,editText5;
    SQLiteDatabase sqLiteDatabase;//making object of this

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editText4= (EditText) findViewById(R.id.editText4);
        editText5= (EditText) findViewById(R.id.editText5);

        button= (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=editText4.getText().toString();
                String pass=editText5.getText().toString();

                sqLiteDatabase=openOrCreateDatabase("CD",MODE_PRIVATE,null);
                sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS form(name VARCHAR,password VARCHAR,phone VARCHAR)");

                Cursor cursor=sqLiteDatabase.rawQuery("SELECT * FROM form",null);

                while(cursor.moveToNext()){
                    if(name.equals(cursor.getString(0))&&pass.equals(cursor.getString(1))){
                        Toast.makeText(login.this, "Login successful", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }
}
