package at.exam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
/**
 * Created by Win 8 32bit VS7 on 27/08/2015.
 */
public class Activity2 extends Activity{
    /**Called when the activity is first created */
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_layout);

        final EditText receiveValueEdit = (EditText) findViewById(R.id.value_receive);
        final Button callReceiveButton = (Button) findViewById(R.id.call_button);

        //Lấy về Bundle được gửi kèm Intent rồi lấy ra giá trị
        Bundle receiveValueBundle = this.getIntent().getExtras();
        final long receiveValue = receiveValueBundle.getLong("value");
        receiveValueEdit.setText(String.valueOf(receiveValue));
        callReceiveButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //Khởi tạo 1 Intent để gửi tới BroadCast Receiver
                //Gán giá trị vào Intent, lần này không cần Bundle nữa
                Intent i = new Intent(Activity2.this,Receiver.class);
                i.putExtra("new value",receiveValue-10);
                sendBroadcast(i);
            }
        });
    }
}
