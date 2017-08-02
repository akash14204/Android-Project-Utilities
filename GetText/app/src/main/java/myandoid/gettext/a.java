package myandoid.gettext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class a extends AppCompatActivity {
    Bundle bundle;
    TextView textview;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        bundle=getIntent().getExtras();
        String s =bundle.getString("");


    textview = (TextView) findViewById(R.id.textview);
    textview.setText(s);



    }
}
