package at.exam;

import android.widget.LinearLayout;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.TextView;
/**
 * Created by Win 8 32bit VS7 on 24/08/2015.
 */
public class CustomViewGroup extends LinearLayout {
    public CheckBox cb;
    public TextView workContent;
    public TextView timeContent;
    public CustomViewGroup(Context context){
        super(context);
        //Sử dụng LayoutInflater để gán giao diện trong list.xml cho class này
        LayoutInflater li = (LayoutInflater) this.getContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);
        li.inflate(R.layout.list,this,true);
        //Lấy về các View qua Id
        cb = (CheckBox) findViewById(R.id.check_work);
        workContent = (TextView) findViewById(R.id.work_content);
        timeContent = (TextView) findViewById(R.id.time_content);
    }
}
