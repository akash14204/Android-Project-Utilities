package myandoid.tab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class result_login extends AppCompatActivity {

    Bundle bundle;
    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_login);

        bundle=getIntent().getExtras();
        String s =bundle.getString("");


        textview = (TextView) findViewById(R.id.textview);
        textview.setText(s);
    }
}
