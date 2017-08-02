package myandoid.telephony;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Telephony extends AppCompatActivity {
    TelephonyManager telephonyManager;
    TextView textView;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telephony);

        textView = (TextView) findViewById(R.id.textView);

        telephonyManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        String name = telephonyManager.getNetworkOperatorName();
        textView.setText(""+name);
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:473457364763"));
                startActivity(i);//it will run but not my mobile
            }
        });

    }

}