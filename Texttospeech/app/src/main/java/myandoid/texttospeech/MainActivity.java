package myandoid.texttospeech;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener{

    Button btn;
    TextToSpeech textToSpeech;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn= (Button) findViewById(R.id.button);
        editText= (EditText) findViewById(R.id.editText);
         textToSpeech=new TextToSpeech(this,this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=editText.getText().toString();
                textToSpeech.speak(s,TextToSpeech.QUEUE_FLUSH,null );
            }
        });
    }


    @Override
    public void onInit(int status) {
        //nothing will be done here
    }
}
