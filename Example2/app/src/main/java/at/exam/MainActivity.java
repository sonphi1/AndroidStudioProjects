package at.exam;

import java.util.ArrayList;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;

import android.widget.EditText;
import android.widget.ListView;



public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Tạo mảng để chứa String nội dung công việc và giờ
        final ArrayList<String> arrayWork = new ArrayList<String>();
        //Adapter dùng để kết nối mảng với List View
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,arrayWork);
        //Các EditText để vào nội dung công việc được lấy về từ XML
        final EditText workEnter = (EditText) findViewById(R.id.work_enter);
        final EditText hourEdit = (EditText) findViewById(R.id.hour_edit);
        final EditText minuteEdit = (EditText) findViewById(R.id.minute_edit);

        //Button khi nhấn sẽ thêm công việc vào ListView
        final Button button = (Button) findViewById(R.id.button);
        //ListView Chứa danh sách công việc
        final ListView list = (ListView) findViewById(R.id.list);
        //cần set Adapter cho list để biết sẽ lấy nội dung từ mảng arrayWork
        list.setAdapter(arrayAdapter);
        //Định nghĩa nghĩa Listener xử lý sự kiện nhấn vào button
        OnClickListener add = new OnClickListener() {

            @Override
            public void onClick(View v) {
                // Nếu 1 trong 3 EditText không có nội dung thì hiện lên thông báo
                if(workEnter.getText().toString().equals("")||
                        hourEdit.getText().toString().equals("")||
                        minuteEdit.getText().toString().equals("")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Info Missing");
                    builder.setMessage("Please enter all information od the work");
                    builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // TODO Auto-generated method stub

                        }
                    });
                    builder.show();
                }
                else{
                    String str = workEnter.getText().toString() + "-" + hourEdit.getText().toString() + ":" + minuteEdit.getText().toString();
                    arrayWork.add(0,str);
                    arrayAdapter.notifyDataSetChanged();
                    workEnter.setText("");
                    hourEdit.setText("");
                    minuteEdit.setText("");
                }

            }
        };
        //Set Listener cho button
        button.setOnClickListener(add);
    }
}
