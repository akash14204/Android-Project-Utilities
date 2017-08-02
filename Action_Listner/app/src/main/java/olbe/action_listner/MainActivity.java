package olbe.action_listner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button akash_button=(Button)findViewById(R.id.akash_button); //make button connected by variable akash_button

        akash_button.setOnClickListener( //set button
           new Button.OnClickListener(){//what we want after click
               public void onClick(View v){
                        TextView akash_text=(TextView)findViewById(R.id.akash_text);
                        akash_text.setText("u have now access");
               }
           }
        );

        akash_button.setOnLongClickListener(//set Long button
            new Button.OnLongClickListener(){//what we want after click
                public boolean onLongClick(View v) {
                    TextView akash_text=(TextView)findViewById(R.id.akash_text);
                    akash_text.setText("Why u have clicked so long.Save ur Life Bitch");
                    return true;//if u wil return false .then it will no longer hold on this button
                }
            }
        );


    }
}
