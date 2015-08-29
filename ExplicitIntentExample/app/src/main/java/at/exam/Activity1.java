package at.exam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Activity1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1_layout);
        final EditText editValue = (EditText) findViewById(R.id.value_edit);
        final Button sendButton = (Button) findViewById(R.id.send_button);
        sendButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                String valueString = editValue.getText().toString();
                long value;
                if(valueString!=null){
                    value = Long.parseLong(valueString);
                }else{
                    value = 0;
                }
                //Tạo 1 đối tương Bundle để gửi đi cùng Intent
                Bundle sendBundle = new Bundle();
                sendBundle.putLong("value",value);
                //Tạo Intent để khởi chạy Activity2 và gần sendBundle vào Intent
                Intent i = new Intent(Activity1.this,Activity2.class);
                i.putExtras(sendBundle);
                startActivity(i);
                //Giải phóng Activity1 khỏi Activity Stack vì ta sẽ không quay lại nó nữa
                finish();
            }
        });
    }
}
