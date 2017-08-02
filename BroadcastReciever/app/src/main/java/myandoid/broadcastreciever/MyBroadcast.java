package myandoid.broadcastreciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by AKASH on 6/21/2016.
 */
public class MyBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.getAction().equals("android.intent.action.ACTION_POWER_CONNECTED")){
            // Intent i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
           //context.startActivity(i);

            Toast.makeText(context.getApplicationContext(),"Charger Connected",Toast.LENGTH_LONG).show();
        }
    }
}
