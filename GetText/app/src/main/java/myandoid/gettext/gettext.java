package myandoid.gettext;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class gettext extends AppCompatActivity implements View.OnClickListener{
    Button btn_login;
    EditText edittext_login;
    String data_login;
    String t="akash";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gettext);

        btn_login= (Button) findViewById(R.id.button_login);
        btn_login.setOnClickListener(this);
        edittext_login= (EditText) findViewById(R.id.edittext_login);


    }

    @Override
    public void onClick(View v) {

            data_login=edittext_login.getText().toString(); //this is used to  get the text and store in the string

        if(data_login.equals(t)){
            Intent intent = new Intent(gettext.this, a.class);
            intent.putExtra("", data_login);
            startActivity(intent);}
        else{

            Intent intent = new Intent(gettext.this, b.class);
            startActivity(intent);
        }
        }
    }

