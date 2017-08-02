package myandoid.gettext;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class calculater extends AppCompatActivity implements View.OnClickListener{

    Button btn2,btn3,btn4,btn5;
    EditText edittext1,edittext2;
    String data1;
    String data2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculater);

        btn2= (Button) findViewById(R.id.button2);
        btn3= (Button) findViewById(R.id.button3);
        btn4= (Button) findViewById(R.id.button4);
        btn5= (Button) findViewById(R.id.button5);

        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);

        edittext1= (EditText) findViewById(R.id.editText);
        edittext2= (EditText) findViewById(R.id.editText2);

    }

    @Override
    public void onClick(View v) {

        data1=edittext1.getText().toString();  //getting both values
        data2=edittext2.getText().toString();

        if(v==btn2){

            double numb1 = Double.parseDouble(data1);   //convertng into double
            double numb2=Double.parseDouble(data2);

            Double sum=numb1+numb2;

            Intent intent=new Intent(calculater.this,result.class);
            intent.putExtra("",Double.toString(sum));//converting into string
            startActivity(intent);

        }
        else if(v==btn3) {

            double numb1 = Double.parseDouble(data1);   //convertng into double
            double numb2 = Double.parseDouble(data2);

            Double sum=numb1-numb2;

            Intent intent = new Intent(calculater.this, result.class);
            intent.putExtra("",Double.toString(sum));//converting into string
            startActivity(intent);
        }
        else if(v==btn4) {

            double numb1 = Double.parseDouble(data1);   //convertng into double
            double numb2 = Double.parseDouble(data2);

            Double sum=numb1/numb2;

            Intent intent = new Intent(calculater.this, result.class);
            intent.putExtra("",Double.toString(sum));//converting into string
            startActivity(intent);
        }
        else if(v==btn5) {

            double numb1 = Double.parseDouble(data1);   //convertng into double
            double numb2 = Double.parseDouble(data2);

            Double sum=numb1*numb2;

            Intent intent = new Intent(calculater.this, result.class);
            intent.putExtra("",Double.toString(sum));//converting into string
            startActivity(intent);
        }






    }
}
