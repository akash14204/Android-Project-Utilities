package myandoid.hardware;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class messaging extends AppCompatActivity implements View.OnClickListener{

    EditText edt,edt2;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messaging);

        edt= (EditText) findViewById(R.id.editText);
        edt2= (EditText) findViewById(R.id.editText2);
        btn= (Button) findViewById(R.id.button);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String number=edt.getText().toString();
        String message=edt2.getText().toString();

        SmsManager smsManager= SmsManager.getDefault();
        smsManager.sendTextMessage(number,null,message,null,null);//also give permission of it
    }
}
