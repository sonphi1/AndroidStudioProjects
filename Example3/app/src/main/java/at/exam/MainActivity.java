package at.exam;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity {
    //Các hằng dùng cho tạo Option Menu
    private static final int DELETE_WORK = Menu.FIRST;
    private static final int ABOUT = Menu.FIRST + 2;

    ArrayList<Work> array;
    ListWorkAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        array = new ArrayList<Work>();
        arrayAdapter = new ListWorkAdapter(this,R.layout.list,array);
        final EditText workEnter = (EditText) findViewById(R.id.work_enter);
        final EditText hourEdit = (EditText) findViewById(R.id.hour_edit);
        final EditText minuteEdit = (EditText) findViewById(R.id.minute_edit);
        final Button button = (Button) findViewById(R.id.button);
        //Tạo list view cho danh sách công việc
        final ListView list = (ListView) findViewById(R.id.list);
        list.setAdapter(arrayAdapter);
        OnClickListener add = new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(workEnter.getText().toString().equals("")||
                        hourEdit.getText().toString().equals("")||
                        minuteEdit.getText().toString().equals("")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Info missing");
                    builder.setMessage("Please enter all infomation of the work");
                    builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            //TODO auto-generated methos stub
                        }
                    });
                    builder.show();
                }
                else{
                    String workContent = workEnter.getText().toString();
                    String timeContent = hourEdit.getText().toString() + ":" + minuteEdit.getText().toString();
                    Work work = new Work(workContent,timeContent);
                    array.add(0,work);
                    arrayAdapter.notifyDataSetChanged();
                    workEnter.setText("");
                    hourEdit.setText("");
                    minuteEdit.setText("");

                }
            }
        };
        button.setOnClickListener(add);
    }
    //Tạo Option Menu
    public boolean onCreateOptionMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        menu.add(0,DELETE_WORK,0,"Delete").setIcon(android.R.drawable.ic_delete);
        menu.add(0,ABOUT,0,"About").setIcon(android.R.drawable.ic_menu_info_details);
        return true;
    }
    //Xử lý sự kiện khi các option trong Option Menu được lựa chợn
    public boolean onOptionsItemDelected(MenuItem item){
        switch (item.getItemId()){
            case DELETE_WORK:{
                deleteCheckedWork();
                break;
            }
            case ABOUT:{
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Ecample 3");
                builder.setMessage("AUTHOR:" + "\n" + "Phạm Lương Sơn Phi" + "\n" + "SOURCE:" + "\n" + "at.exam");
                builder.setPositiveButton("Close",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which){

                    }
                });
                builder.setIcon(android.R.drawable.ic_dialog_info);
                builder.show();
                break;
            }
        }
        return true;
    }
    private void deleteCheckedWork(){
        if(array.size()>0){
            for(int i = 0; i < array.size();i++){
                if(i > array.size()){
                    break;
                }
                if (array.get(i).isChecked()){
                    array.remove(i);
                    arrayAdapter.notifyDataSetChanged();
                    continue;
                }
            }
        }
    }
}
