package myandoid.services;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class service extends AppCompatActivity implements View.OnClickListener{
    Button btn1,btn2;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        btn1 = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
    if(btn1==v) {
        startService(new Intent(service.this, Myservice.class));
    }
        else if(btn2==v){
        stopService(new Intent(service.this, Myservice.class));
    }
    }
}
