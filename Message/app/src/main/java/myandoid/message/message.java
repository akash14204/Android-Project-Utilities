package myandoid.message;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class message extends AppCompatActivity implements View.OnClickListener{

    Button btn,btn2;
    EditText edt,edt2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        edt= (EditText) findViewById(R.id.editText);
        edt2= (EditText) findViewById(R.id.editText);
        btn= (Button) findViewById(R.id.button);

        btn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

    }
}
