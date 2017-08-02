package myandoid.tabhost;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TabHost;

public class tabhost extends AppCompatActivity {

    TabHost tabhost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabhost);

        tabhost = (TabHost) findViewById(R.id.tabhost);
        tabhost.setup();
        TabHost.TabSpec tt=tabhost.newTabSpec("chat");// passing string type parameter  using it for button
        tt.setIndicator("chat");
        tt.setContent(R.id.linearLayout);
        tabhost.addTab(tt);


        tt=tabhost.newTabSpec("search");// passing string type parameter  using it for button
        tt.setIndicator("search");
        tt.setContent(R.id.linearLayout2);
        tabhost.addTab(tt);


         tt=tabhost.newTabSpec("comment");// passing string type parameter  using it for button
        tt.setIndicator("comment");
        tt.setContent(R.id.linearLayout3);
        tabhost.addTab(tt);
+    }
}
