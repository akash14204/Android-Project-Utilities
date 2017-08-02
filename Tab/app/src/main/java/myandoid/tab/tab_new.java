package myandoid.tab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class tab_new extends AppCompatActivity implements View.OnClickListener{

//for tabhost
    TabHost tabhost;
//for calculater
    Button btn2,btn3,btn4,btn5;
    EditText edittext1,edittext2;
    String data1;
    String data2;

//for custom layout
    int  image[]={R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,};
    String cloth[]={"a","b","c","d"};
    String price[]={"10","20","30","40"};
    ListView listView;

//for login
    Button btn_login;
    EditText edittext_login;
    String data_login;
    String t="akash";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_new);



//TABHOST START..................................................................................................
        tabhost = (TabHost) findViewById(R.id.tabHost);
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
//FINISH TABHOST..........................................................................................................















  //for login
        btn_login= (Button) findViewById(R.id.button_login);
        btn_login.setOnClickListener(this);
        edittext_login= (EditText) findViewById(R.id.edittext_login);




//for custom layout as listview
        listView= (ListView) findViewById(R.id.listView);

        MyCustomList myCustomList = new MyCustomList();
        listView.setAdapter(myCustomList);



//for calculater
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


      //for login
        data_login=edittext_login.getText().toString(); //this is used to  get the text and store in the string

        if(data_login.equals(t)){
            Intent intent = new Intent(tab_new.this, result_login.class);
            intent.putExtra("", data_login);
            startActivity(intent);}
        else{

            Toast.makeText(tab_new.this,"wrong password",Toast.LENGTH_SHORT).show();
        }



//for calculater
        data1=edittext1.getText().toString();  //getting both values
        data2=edittext2.getText().toString();

        if(v==btn2){

            double numb1 = Double.parseDouble(data1);   //convertng into double
            double numb2=Double.parseDouble(data2);

            Double sum=numb1+numb2;

            Intent intent=new Intent(tab_new.this,result.class);
            intent.putExtra("",Double.toString(sum));//converting into string
            startActivity(intent);

        }
        else if(v==btn3) {

            double numb1 = Double.parseDouble(data1);   //convertng into double
            double numb2 = Double.parseDouble(data2);

            Double sum=numb1-numb2;

            Intent intent = new Intent(tab_new.this, result.class);
            intent.putExtra("",Double.toString(sum));//converting into string
            startActivity(intent);
        }
        else if(v==btn4) {

            double numb1 = Double.parseDouble(data1);   //convertng into double
            double numb2 = Double.parseDouble(data2);

            Double sum=numb1/numb2;

            Intent intent = new Intent(tab_new.this, result.class);
            intent.putExtra("",Double.toString(sum));//converting into string
            startActivity(intent);
        }
        else if(v==btn5) {

            double numb1 = Double.parseDouble(data1);   //convertng into double
            double numb2 = Double.parseDouble(data2);

            Double sum=numb1*numb2;

            Intent intent = new Intent(tab_new.this, result.class);
            intent.putExtra("",Double.toString(sum));//converting into string
            startActivity(intent);
        }


    }


//for custom listview
    public class MyCustomList extends BaseAdapter {  //MycustomlIST class is predefined and extending base adapter class


        @Override
        public int getCount() {
            return image.length;

        }

        @Override
        public Object getItem(int position) {

            return position;
        }

        @Override
        public long getItemId(int id) {
            return id;
        }

        @Override
        public View getView(int position, View view, ViewGroup ViewGroup) {

            view=getLayoutInflater().inflate(R.layout.activity_custom2,ViewGroup,false);
            //inflater is used to connectting to second layout as custom2

            //now making object and find through id
            ImageView imageView= (ImageView) view.findViewById(R.id.imageView2);
            TextView textView= (TextView) view.findViewById(R.id.textView);
            TextView textView2= (TextView) view.findViewById(R.id.textView2);
            Button btn= (Button) view.findViewById(R.id.button);

            //now setting up image
            imageView.setImageResource(image[position]);
            textView.setText(cloth[position]);
            textView.setText(price[position]);
            return view;
        }
    }
}


