package myandoid.gettext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class result extends AppCompatActivity {

     Bundle bundle;
    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        bundle= getIntent().getExtras();
        String s=bundle.getString("");


        textview= (TextView) findViewById(R.id.textView);
        textview.setText(s);

    }
}
