package at.exam;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
/**
 * Created by Win 8 32bit VS7 on 28/08/2015.
 */
public class Receiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent){
        long value = intent.getLongExtra("new value",-10)+10;
        Toast toast = Toast.makeText(context, "Broadcast Receiver cach an Intent"+ "\n" + "The value is stored in the Intent is" + String.valueOf(value),Toast.LENGTH_LONG);
        toast.show();
    }
}
